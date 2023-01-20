
package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Tipo_Suite;
import model.dao.ClienteDAO;
import model.dao.TipoSuiteDAO;

public class TipoSuiteController {
    
    
   public void create(String descricao) {
        Tipo_Suite tips = new Tipo_Suite();
        TipoSuiteDAO tipoSuiteDAO = new TipoSuiteDAO();
        tips.setDescricao(descricao);
        

        tipoSuiteDAO.create(tips);
    }
   
   public void TipoSuiteController() {
    
}
   
   public ArrayList<Tipo_Suite> read() {
        TipoSuiteDAO tiposuiteDAO = new TipoSuiteDAO();
        return tiposuiteDAO.read();
    }
   
   public void update(String descricao, int id_tipo_suite) {
       Tipo_Suite tiposuite = new Tipo_Suite();
       TipoSuiteDAO tipoSuiteDAO = new TipoSuiteDAO();

        tiposuite.setDescricao(descricao);
        tiposuite.setId_tipo_suite(id_tipo_suite);

        tipoSuiteDAO.update(tiposuite);
    }
   
   public void delete(int id_tipo_suite) {
       Tipo_Suite tiposuite = new Tipo_Suite();
        TipoSuiteDAO tipoSuiteDAO = new TipoSuiteDAO();

        tiposuite.setId_tipo_suite(id_tipo_suite);
        tipoSuiteDAO.delete(tiposuite);

    }
   public ArrayList<Tipo_Suite> buscarClienteporNome(String nome) {
        TipoSuiteDAO tipoSuiteDAO = new TipoSuiteDAO();
        return tipoSuiteDAO.getListaTipoSuite(nome);
    }
}
