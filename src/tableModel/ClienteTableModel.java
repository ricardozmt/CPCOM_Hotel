
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Hospedagem;
import model.bean.Cliente;


public class ClienteTableModel extends AbstractTableModel{
    
    private List<Cliente> listaCliente;
    private String[] colunas = {"Nome", "Cpf", "Numero", "Profissao", "E-mail"};

    public ClienteTableModel(){
        listaCliente = new ArrayList<>();
    }
    
    public ClienteTableModel(List<Cliente> clientes){
        this();
        this.listaCliente.addAll(clientes);
    }
    
    @Override
    public int getRowCount() {
        return listaCliente.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente cliente = listaCliente.get(linha);
        
        
        switch (coluna) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getCpf();
            case 2:
                return cliente.getTelefone();
            case 3:
                return cliente.getProfissao();
            case 4:
                return cliente.getEmail();                
            default:
                return "";
        }
        
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Cliente getCliente(int linha) {
        if (linha >= listaCliente.size()) {
            return null;
        }
        return listaCliente.get(linha);
    }
    
}
