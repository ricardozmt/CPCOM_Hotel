package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Hospedagem;
import model.bean.Suite;

public class HospedagemDAO {

    private Connection con = null;

    public HospedagemDAO() {

        con = ConnectionFactory.getConnection();
    }

    public boolean create(Hospedagem hospedagem) {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO hospedagem"
                + "(data_reserva, inf_pagamento, numero_cartao_acesso, data_checkout, data_checkin, id_cliente, id_suite)"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, (hospedagem.getData_reserva()));
            stmt.setString(2, (hospedagem.getInf_pagamento()));
            stmt.setInt(3, Integer.parseInt(String.valueOf(hospedagem.getCartao_acesso())));
            stmt.setString(4, hospedagem.getData_checkout());
            stmt.setString(5, hospedagem.getData_checkin());
            stmt.setInt(6, hospedagem.getCliente().getId_cliente());
            stmt.setInt(7, hospedagem.getSuite().getId_suite());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean update(Hospedagem hospedagem) {
        PreparedStatement stmt = null;

        String sql = "UPDATE hospedagem SET data_reserva=?, inf_pagamento=?, numero_cartao_acesso=?, data_checkout=?, data_checkin=?, id_suite=?, id_cliente=? WHERE id_hospedagem = ?";

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, (hospedagem.getData_reserva()));
            stmt.setString(2, (hospedagem.getInf_pagamento()));
            stmt.setInt(3, hospedagem.getCartao_acesso());
            stmt.setString(4, hospedagem.getData_checkout());
            stmt.setString(5, hospedagem.getData_checkin());
            stmt.setInt(6, hospedagem.getSuite().getId_suite());
            stmt.setInt(7, hospedagem.getCliente().getId_cliente());
            stmt.setInt(8, hospedagem.getId_hospedagem());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Hospedagem hospedagem) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM hospedagem WHERE id_hospedagem = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, hospedagem.getId_hospedagem());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    public ArrayList<Hospedagem> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Hospedagem> listaHospedagem = new ArrayList<>();
        String sql = "SELECT * FROM view_hospedagem";

        try {
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Hospedagem hospedagem = new Hospedagem();

                hospedagem.setId_hospedagem(rs.getInt("id_hospedagem"));
                hospedagem.setData_reserva(rs.getString("data_reserva"));
                hospedagem.setInf_pagamento(rs.getString("inf_pagamento"));
                hospedagem.setCartao_acesso(rs.getInt("numero_cartao_acesso"));
                hospedagem.setData_checkin(rs.getString("data_checkin"));
                hospedagem.setData_checkout(rs.getString("data_checkout"));

                Cliente cliente = new Cliente();
//                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                hospedagem.setCliente(cliente);

                Suite suite = new Suite();
//                suite.setId_suite(rs.getInt("id_suite"));
                suite.setNome(rs.getString("suite"));
                hospedagem.setSuite(suite);

                listaHospedagem.add(hospedagem);
            }

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaHospedagem;

    }

    public ArrayList<Hospedagem> read(int id_hospedagem) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Hospedagem> listaHospedagem = new ArrayList<>();
        String sql = "SELECT * FROM view_hospedagem WHERE id_hospedagem = ? ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_hospedagem);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Hospedagem hospedagem = new Hospedagem();

                hospedagem.setId_hospedagem(rs.getInt("id_hospedagem"));
                hospedagem.setData_reserva(rs.getString("data_reserva"));
                hospedagem.setInf_pagamento(rs.getString("inf_pagamento"));
                hospedagem.setCartao_acesso(rs.getInt("numero_cartao_acesso"));
                hospedagem.setData_checkin(rs.getString("data_checkin"));
                hospedagem.setData_checkout(rs.getString("data_checkout"));

                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                hospedagem.setCliente(cliente);

                Suite suite = new Suite();
                suite.setId_suite(rs.getInt("id_suite"));
                suite.setNome(rs.getString("nome"));
                hospedagem.setSuite(suite);

            }

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaHospedagem;

    }

}
