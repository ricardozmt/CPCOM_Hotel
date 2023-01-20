package tableModel;

import controller.SuiteController;
import java.util.ArrayList;
import java.util.List;
import model.bean.Suite;
import javax.swing.table.AbstractTableModel;
import model.bean.Tipo_Suite;

public class SuiteTableModel extends AbstractTableModel {

        private Tipo_Suite tipo_suite;

    
    SuiteController suiteController = new SuiteController();
    private List<Suite> listaSuite;
    private String[] colunas = {"Suite", "Quarto", "Valor", "Situação"};

    public SuiteTableModel() {

        listaSuite = new ArrayList<>();
    }

    public SuiteTableModel(List<Suite> suites) {
        this();
        this.listaSuite.addAll(suites);
    }

    @Override
    public int getRowCount() {
        return listaSuite.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Suite suite = listaSuite.get(linha);

        switch (coluna) {
            case 0:
                return suite.getTipo_suite().getDescricao();
            case 1:
                return suite.getNome();
            case 2:
                return suite.getValor();
            case 3:
                return suite.isDisponivel();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Suite getSuite(int linha) {
        if (linha >= listaSuite.size()) {
            return null;
        }
        return listaSuite.get(linha);
    }
}
