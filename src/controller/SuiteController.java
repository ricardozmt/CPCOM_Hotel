package controller;

import java.util.ArrayList;
import model.bean.Suite;
import model.bean.Tipo_Suite;
import model.dao.SuiteDAO;

public class SuiteController {

    public SuiteController() {
    }

    public boolean create(String nome, double valor, boolean disponivel, Tipo_Suite tipo_suite) {

        Suite suite = new Suite();

        suite.setNome(nome);
        suite.setValor(valor);
        suite.setDisponivel(disponivel);
        suite.setTipo_suite(tipo_suite);

        SuiteDAO suiteDAO = new SuiteDAO();
        return suiteDAO.create(suite);
    }

    public ArrayList<Suite> read() {
        SuiteDAO suiteDAO = new SuiteDAO();
        return suiteDAO.read();
    }

    public boolean update(
            int id_suite,
            String nome,
            double valor,
            boolean disponivel,
            Tipo_Suite tipo_suite) {
        
        Suite suite = new Suite();

        suite.setNome(nome);
        suite.setValor(valor);
        suite.setDisponivel(disponivel);
        suite.setTipo_suite(tipo_suite);
        suite.setId_suite(id_suite);

        SuiteDAO suiteDAO = new SuiteDAO();
        return suiteDAO.update(suite);
    }

    public boolean delete(int id_suite) {
        Suite suite = new Suite();
        SuiteDAO suiteDAO = new SuiteDAO();

        suite.setId_suite(id_suite);
        suiteDAO.delete(suite);
        return false;
    }

    public ArrayList<Suite> buscar(String nome) {
        SuiteDAO suiteDAO = new SuiteDAO();
        return suiteDAO.buscar(nome);
    }

    public ArrayList<Suite> getListaSuiteporNome(String nome) {
        SuiteDAO suiteDAO = new SuiteDAO();
        return suiteDAO.getListaSuiteoporNome(nome);
    }

}
