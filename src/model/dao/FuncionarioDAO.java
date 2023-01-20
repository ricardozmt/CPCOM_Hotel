package model.dao;

import connection.ConnectionFactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Funcionario;

public class FuncionarioDAO {

    public FuncionarioDAO() {

    }

     public boolean createCRIP(Funcionario usu) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(usu.getSenha().getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));

            }
            String senhaHex = sb.toString();

            stmt = con.prepareStatement("INSERT INTO funcionario(numero_cdt, nome, telefone, cpf, email, cep, logradouro,numero,complemento,cargo, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, usu.getNumero_cdt());
            stmt.setString(2, usu.getNome());
            stmt.setString(3, usu.getTelefone());
            stmt.setString(4, usu.getCpf());
            stmt.setString(5, usu.getEmail());
            stmt.setString(6, usu.getCep());
            stmt.setString(7, usu.getLogradouro());
            stmt.setString(8, usu.getNumero());
            stmt.setString(9, usu.getComplemento());
            stmt.setString(10, usu.getCargo());
            stmt.setString(11,usu.getUsuario());
            stmt.setString(12, senhaHex);

            con.setAutoCommit(false);

            stmt.executeUpdate();
            con.commit();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar " + ex);
            try {
                con.rollback();
            } catch (SQLException e) {
                System.out.println("Erro");
            }

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Erro" + ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Erro" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
            }
        }
        return false;

    }
   
     
    public ArrayList<Funcionario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> listaFuncionario = new ArrayList();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario ORDER BY id_funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNumero_cdt(rs.getString("numero_cdt"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setLogradouro(rs.getString("logradouro"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                
                listaFuncionario.add(funcionario);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os FuncionariosDAO! ", "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaFuncionario;
    }

    public void update(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE public.funcionario SET  numero_cdt=?, nome=?, telefone=?, cpf=?, email=?, cargo=?, cep=?, logradouro=?, numero=?, complemento=?, usuario=?, senha=? WHERE id_funcionario = ?");
            stmt.setString(1, funcionario.getNumero_cdt());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getCargo());
            stmt.setString(7, funcionario.getCep());
            stmt.setString(8, funcionario.getLogradouro());
            stmt.setString(9, funcionario.getNumero());
            stmt.setString(10, funcionario.getComplemento());
            stmt.setString(11, funcionario.getUsuario());
            stmt.setString(12, funcionario.getSenha());
            stmt.setInt(13, funcionario.getId_funcionario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public void delete(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE id_funcionario = ?");
            stmt.setInt(1, funcionario.getId_funcionario());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Funcionario> getListaFuncionarioporNome(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome LIKE ? ORDER by id_funcionario");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNumero_cdt(rs.getString("numero_cdt"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setLogradouro(rs.getString("logradouro"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setComplemento(rs.getString("complemento"));

                listaFuncionario.add(funcionario);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os FuncionariosDAO!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaFuncionario;
    }

    public boolean verificaLogin(Funcionario fun) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(fun.getSenha().getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));

            }
            String senhaHex = sb.toString();

            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE usuario = ? and senha = ?");
            stmt.setString(1, fun.getUsuario());
            stmt.setString(2, senhaHex);
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro na execução do SQL.");

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

   

}
