
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Funcionario;


public class FuncionarioTableModel extends AbstractTableModel{
    
   

    private List<Funcionario> listaFuncionario;
    private String[] colunas = {"Nome", "Cargo", "CPF", "E-mail"};

    public FuncionarioTableModel() {

       listaFuncionario = new ArrayList<>();
    }

     public FuncionarioTableModel(List<Funcionario> funcionarios) {
        this();
        this.listaFuncionario.addAll(funcionarios);
    }
  
    @Override
    public int getRowCount() {
        return listaFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Funcionario funcionario = listaFuncionario.get(linha);

        switch (coluna) {
            case 0:
                return funcionario.getNome();
            case 1:
                return funcionario.getCargo();
            case 2:
                return funcionario.getCpf();
            case 3:
                return funcionario.getEmail();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Funcionario getFuncionario(int linha) {
        if (linha >= listaFuncionario.size()) {
            return null;
        }
        return listaFuncionario.get(linha);
    }
}

