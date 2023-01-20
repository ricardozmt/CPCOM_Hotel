package model.dao;

import connection.ConnectionFactory;
import controller.TipoSuiteController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Tipo_Suite;

public class TipoSuiteDAO {

    public void create(Tipo_Suite tips) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tipo_suite (descricao) VALUES (?)");
            stmt.setString(1, tips.getDescricao());

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
                System.out.println("ErroDAO");
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

    public ArrayList<Tipo_Suite> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Tipo_Suite> listaTipoSuite = new ArrayList();
        try {
            stmt = con.prepareStatement("SELECT * FROM tipo_suite ORDER BY id_tipo_suite");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Tipo_Suite tips = new Tipo_Suite();

                tips.setId_tipo_suite(rs.getInt("id_tipo_suite"));
                tips.setDescricao(rs.getString("Descricao"));

                listaTipoSuite.add(tips);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os tipos de suiteDAO! ", "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaTipoSuite;
    }

    public void update(Tipo_Suite tips) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tipo_suite SET descricao=? WHERE id_tipo_suite =?");
            stmt.setString(1, tips.getDescricao());
            stmt.setInt(2, tips.getId_tipo_suite());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizarDAO" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }
    
    public void delete(Tipo_Suite tips) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tipo_suite WHERE id_tipo_suite = ?");
            stmt.setInt(1, tips.getId_tipo_suite());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluirDAO" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Tipo_Suite> getListaTipoSuite(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Tipo_Suite> tipoSuite = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tipo_suite WHERE nome LIKE ? ORDER by id_tipo_suite");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Tipo_Suite tips = new Tipo_Suite();
                tips.setId_tipo_suite(rs.getInt("id_tipo_suite"));
                tips.setDescricao(rs.getString("descricao"));
                

                tipoSuite.add(tips);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os Tipos de suitesDAO!", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipoSuite;
    }
    
    
}
