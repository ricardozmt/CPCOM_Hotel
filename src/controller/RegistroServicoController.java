package controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Hospedagem;
import model.bean.RegistroServico;
import model.bean.RegistroServico;
import model.bean.Suite;
import model.dao.HospedagemDAO;
import model.dao.RegistroServicoDAO;
import model.dao.RegistroServicoDAO;

public class RegistroServicoController {

    public boolean create(String descricao, double valor) {

        RegistroServico registro = new RegistroServico();

        registro.setDescricao(descricao);
        registro.setValor(valor);

        RegistroServicoDAO registroDAO = new RegistroServicoDAO();
        return registroDAO.create(registro);
    }

    public ArrayList<RegistroServico> read() {
        RegistroServicoDAO registroServicoDAO = new RegistroServicoDAO();
        return registroServicoDAO.read();
    }

    public boolean update(String descricao, double valor, int id_hospedagem, int id_registro_servicos) {
        RegistroServico registroServico = new RegistroServico();

        registroServico.setDescricao(descricao);
        registroServico.setValor(valor);
        registroServico.setId_hospedagem(id_hospedagem);
        registroServico.setId_registro_servicos(id_registro_servicos);

        RegistroServicoDAO registroDAO = new RegistroServicoDAO();
        return registroDAO.update(registroServico);

    }

    public void delete(RegistroServico registro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM registro_de_servicos WHERE id_registro_servicos = ?");
            stmt.setInt(1, registro.getId_registro_servicos());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
