package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Hospedagem;

public class HospedagemTableModel extends AbstractTableModel {

    private List<Hospedagem> listaHospedagem;
    private String[] colunas = {"Cliente", "Suite", "DataReserva", "Cartao", "Checkin", "checkout", "Pagamento"};

    public HospedagemTableModel() {

       listaHospedagem = new ArrayList<>();
    }

     public HospedagemTableModel(List<Hospedagem> hospedagens) {
        this();
        this.listaHospedagem.addAll(hospedagens);
    }
  
    @Override
    public int getRowCount() {
        return listaHospedagem.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Hospedagem hospedagem = listaHospedagem.get(linha);

        switch (coluna) {
            case 0:
                return hospedagem.getCliente().getNome();
            case 1:
                return hospedagem.getSuite().getNome();
          
            case 2:
                return hospedagem.getData_reserva();
            case 3:
                return hospedagem.getCartao_acesso();
            case 4:
                return hospedagem.getData_checkin();
            case 5:
                return (hospedagem.getData_checkout());
            case 6:
                return hospedagem.getInf_pagamento();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Hospedagem getHospedagem(int linha) {
        if (linha >= listaHospedagem.size()) {
            return null;
        }
        return listaHospedagem.get(linha);
    }
}
