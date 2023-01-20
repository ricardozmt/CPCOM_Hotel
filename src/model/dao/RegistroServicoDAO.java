package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.RegistroServico;
import model.bean.Suite;
import model.bean.Tipo_Suite;

public class RegistroServicoDAO {

    private Connection con = null;

    public RegistroServicoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean create(RegistroServico registroServico) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO registro_de_servicos (descricao, valor) VALUES (?, ?)");
            stmt.setString(1, registroServico.getDescricao());
            stmt.setDouble(2, registroServico.getValor());
     

            con.setAutoCommit(false);

            stmt.executeUpdate();
            con.commit();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar - REGISTRODAO");
            try {
                con.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback - REGISTRODAO");
            }
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
            }
        }

    }

    public ArrayList<RegistroServico> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<RegistroServico> listaServico = new ArrayList<>();

        String sql = "SELECT * FROM registro_de_servicos";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                RegistroServico registroServico = new RegistroServico();

                registroServico.setDescricao(rs.getString("descricao"));
                registroServico.setValor(rs.getDouble("valor"));
                registroServico.setId_hospedagem(rs.getInt("id_hospedagem"));
                registroServico.setId_registro_servicos(rs.getInt("id_registro_servicos"));

                RegistroServico registro = new RegistroServico();

                registro.setDescricao(rs.getString("descricao"));
                registro.setValor(rs.getDouble("valor"));
                registro.setId_hospedagem(rs.getInt("id_hospedagem"));
                registro.setId_registro_servicos(rs.getInt("id_registro_servicos"));

                listaServico.add(registro);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler registro - REGISTRODAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaServico;
    }
    
    
     public boolean update(RegistroServico registro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE registro_de_servicos SET  descricao=?, valor=?, id_hospedagem=? WHERE id_registro_servicos=?";

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, registro.getDescricao());
            stmt.setDouble(2, registro.getValor());
            stmt.setInt(3, registro.getId_hospedagem());
            stmt.setInt(4, registro.getId_registro_servicos());

            stmt.executeUpdate();

            System.out.println("Registro de serviços " + registro.getDescricao() + " foi atualizado!");

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar - REGISTRODAO");
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     
     public void delete(RegistroServico registro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM registro_de_servicos WHERE id_registro_servicos = ?");
            stmt.setInt(1, registro.getId_registro_servicos());

            stmt.executeUpdate();
            System.out.println("Excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar suite - REGISTRODAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     public ArrayList<RegistroServico> buscar(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<RegistroServico> listaRegistro = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM registro_de_servicos WHERE nome descricao ? ORDER BY id_registro_servicos;");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                RegistroServico registro = new RegistroServico();
                registro.setId_registro_servicos(rs.getInt("id_registro_servicos"));
                registro.setId_hospedagem(rs.getInt("id_hospedagem"));

                listaRegistro.add(registro);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar suite - REGISTRODAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaRegistro;
    }
     
     public ArrayList<RegistroServico> getListaRegistroNome(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<RegistroServico> listaRegistro = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT descricao FROM registro_de_servicos");

            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                RegistroServico registro = new RegistroServico();
                registro.setDescricao(rs.getString("descricao"));
                registro.setValor(rs.getDouble("valor"));
                registro.setId_hospedagem(rs.getInt("id_hospedagem"));
                registro.setId_registro_servicos(rs.getInt("id_registro_servicos"));
               
                

                listaRegistro.add(registro);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler produto - REGISTRODAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaRegistro;
    }
}
