package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import model.bean.Suite;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import model.bean.Tipo_Suite;

public class SuiteDAO {

    private Connection con = null;

    public SuiteDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean create(Suite suite) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO suite  (nome, valor, disponivel,id_tipo_suite) VALUES (?, ?, ?, ?)");
            stmt.setString(1, suite.getNome());
            stmt.setDouble(2, suite.getValor());
            stmt.setBoolean(3, suite.isDisponivel());
            stmt.setInt(4, suite.getTipo_suite().getId_tipo_suite());

            con.setAutoCommit(false);

            stmt.executeUpdate();
            con.commit();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar - SUITEDAO");
            try {
                con.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback - SUITEDAO");
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

    public ArrayList<Suite> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Suite> listaSuite = new ArrayList<>();

        String sql = "SELECT * FROM suite INNER JOIN tipo_suite on suite.id_tipo_suite = tipo_suite.id_tipo_suite";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Suite suite = new Suite();

                suite.setNome(rs.getString("nome"));
                suite.setValor(rs.getDouble("valor"));
                suite.setDisponivel(rs.getBoolean("disponivel"));
                suite.setId_suite(rs.getInt("id_suite"));
                
                Tipo_Suite tips = new Tipo_Suite();

                tips.setDescricao(rs.getString("descricao"));
                suite.setTipo_suite(tips);

                listaSuite.add(suite);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler suite - SUITEDAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaSuite;
    }

    public boolean update(Suite suite) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE suite SET nome=?, valor=?, disponivel=? WHERE id_suite=?";

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, suite.getNome());
            stmt.setDouble(2, suite.getValor());
            stmt.setBoolean(3, suite.isDisponivel());
            stmt.setInt(4, suite.getId_suite());

            stmt.executeUpdate();

            System.out.println("Suite " + suite.getNome() + " foi atualizado!");

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar - SUITEDAO");
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Suite suite) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM suite WHERE id_suite = ?");
            stmt.setInt(1, suite.getId_suite());

            stmt.executeUpdate();
            System.out.println("Excluído com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar suite - SUITEDAO");
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
      
    }

    public ArrayList<Suite> buscar(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Suite> listaSuite = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM suite WHERE nome LIKE ? ORDER BY id_suite;");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Suite suite = new Suite();
                suite.setId_suite(rs.getInt("id_suite"));
                suite.setDisponivel(rs.getBoolean("disponivel"));

                listaSuite.add(suite);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar suite - SUITEDAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaSuite;
    }

    public ArrayList<Suite> getListaSuiteoporNome(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Suite> listaSuite = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT  nome FROM suite");

            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Suite suite = new Suite();
                suite.setId_suite(rs.getInt("id_suite"));
                suite.setNome(rs.getString("nome"));
                suite.setValor(rs.getDouble("valor"));
                suite.setDisponivel(rs.getBoolean("disponivel"));

                Tipo_Suite tips = new Tipo_Suite();
                tips.setId_tipo_suite(rs.getInt("id_tipo_suite"));
                tips.setDescricao(rs.getString("tdesc"));
                suite.setTipo_suite(tips);

                listaSuite.add(suite);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler produto - SUITEDAO");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listaSuite;
    }

}
