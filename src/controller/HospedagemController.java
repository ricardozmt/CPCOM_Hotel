package controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Hospedagem;
import model.bean.Suite;
import model.dao.HospedagemDAO;

public class HospedagemController {

    public boolean create(Cliente cliente, Suite suite, String data_reserva, String inf_pagamento, int cartao_acesso, String data_checkin, String data_checkout) {
        Hospedagem hosp = new Hospedagem();

        hosp.setCliente(cliente);
        hosp.setSuite(suite);
        hosp.setData_reserva(data_reserva);
        hosp.setInf_pagamento(inf_pagamento);
        hosp.setCartao_acesso(cartao_acesso);
        hosp.setData_checkin(data_checkin);
        hosp.setData_checkout(data_checkout);

        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        return hospedagemDAO.create(hosp);
    }

    public ArrayList<Hospedagem> read() {
        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        return hospedagemDAO.read();
    }

    public boolean update(Cliente cliente, Suite suite, String data_reserva, String inf_pagamento, int cartao_acesso, String data_checkin, String data_checkout, int id_hospedagem) {
        Hospedagem hosp = new Hospedagem();

        hosp.setCliente(cliente);
        hosp.setSuite(suite);
        hosp.setData_reserva(data_reserva);
        hosp.setInf_pagamento(inf_pagamento);
        hosp.setCartao_acesso(cartao_acesso);
        hosp.setData_checkin(data_checkin);
        hosp.setData_checkout(data_checkout);
        hosp.setId_hospedagem(id_hospedagem);

        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        return hospedagemDAO.update(hosp);

    }

    
    public void delete(Hospedagem hospedagem) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM hospedagem WHERE id_hospedagem = ?");
            stmt.setInt(1, hospedagem.getId_hospedagem());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}
