package tableModel;

import controller.TipoSuiteController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.RegistroServico;
import model.bean.Tipo_Suite;

public class RegistroTableModel extends AbstractTableModel {


    private List<RegistroServico> listaRegistro;
    private String[] colunas = {"Descrição", "Valor"};

    public RegistroTableModel() {

        listaRegistro = new ArrayList<>();
    }

    public RegistroTableModel(List<RegistroServico> registros) {
        this();
        this.listaRegistro.addAll(registros);
    }

    @Override
    public int getRowCount() {
        return listaRegistro.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        RegistroServico registro = listaRegistro.get(linha);

        switch (coluna) {
            case 0:
                return registro.getDescricao();
            case 1:
                return registro.getValor();
               
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public RegistroServico getRegistro(int linha) {
        if (linha >= listaRegistro.size()) {
            return null;
        }
        return listaRegistro.get(linha);
    }

}
