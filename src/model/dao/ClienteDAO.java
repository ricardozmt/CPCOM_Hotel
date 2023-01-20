package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import model.bean.Cliente;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public void create(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (profissao, nome, telefone, cpf, email, cep, logradouro, numero, complemento) VALUES (?,?,?,?,?,?,?,?,? )");
            stmt.setString(1, cliente.getProfissao());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getLogradouro());
            stmt.setString(8, cliente.getNumero());
            stmt.setString(9, cliente.getComplemento());

            con.setAutoCommit(false);

            stmt.executeUpdate();
            con.commit();

            System.out.println("Salvo com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar!" + ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex1);
                System.out.println("Erro");
            }
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> listaCliente = new ArrayList();
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente ORDER BY id_cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setProfissao(rs.getString("profissao"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));

                listaCliente.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os Clientes! ", "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaCliente;
    }

    public void update(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente set profissao = ?, nome = ?, telefone = ?, cpf = ?, email = ?, cep = ?, logradouro = ?, numero = ?, complemento = ?  WHERE id_cliente = ?");
            stmt.setString(1, cliente.getProfissao());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getLogradouro());
            stmt.setString(8, cliente.getNumero());
            stmt.setString(9, cliente.getComplemento());
            stmt.setInt(10, cliente.getId_cliente());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public void delete(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from cliente where id_cliente =? ");
            stmt.setInt(1, cliente.getId_cliente());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Cliente> getListaClienteporNome(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> listaCliente = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ORDER by id_cliente");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setProfissao(rs.getString("profissao"));
                cliente.setEmail(rs.getString("email"));

                listaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os Clientes!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaCliente;
    }

}

