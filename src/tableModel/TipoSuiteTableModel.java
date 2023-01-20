package tableModel;

import controller.SuiteController;
import controller.TipoSuiteController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Tipo_Suite;

public class TipoSuiteTableModel extends AbstractTableModel {

    TipoSuiteController tipoSuiteController = new TipoSuiteController();

    private List<Tipo_Suite> listaTipoSuite;
    private String[] colunas = {"Descrição"};

    public TipoSuiteTableModel() {

        listaTipoSuite = new ArrayList<>();
    }

    public TipoSuiteTableModel(List<Tipo_Suite> tipsuites) {
        this();
        this.listaTipoSuite.addAll(tipsuites);
    }

    @Override
    public int getRowCount() {
        return listaTipoSuite.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Tipo_Suite tipo_Suite = listaTipoSuite.get(linha);

        switch (coluna) {
            case 0:
                return tipo_Suite.getDescricao();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Tipo_Suite getTipoSuite(int linha) {
        if (linha >= listaTipoSuite.size()) {
            return null;
        }
        return listaTipoSuite.get(linha);
    }
}
