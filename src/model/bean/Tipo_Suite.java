
package model.bean;
public class Tipo_Suite {
   
    private int id_tipo_suite;
    private String descricao;
    private double valor;

    public Tipo_Suite() {
    }

    public int getId_tipo_suite() {
        return id_tipo_suite;
    }

    public void setId_tipo_suite(int id_tipo_suite) {
        this.id_tipo_suite = id_tipo_suite;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    @Override
    public String toString(){
        return this.getDescricao();
    }

    
    
    
    
    
    
}
