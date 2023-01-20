package model.bean;

public class Suite {

    private int id_suite;
    private int id_tipo_suite;
    private String nome;
    private double valor;
    private boolean disponivel;
    private Tipo_Suite tipo_suite;

    public Suite() {
    }

    public int getId_suite() {
        return id_suite;
    }

    public void setId_suite(int id_suite) {
        this.id_suite = id_suite;
    }

    public int getId_tipo_suite() {
        return id_tipo_suite;
    }

    public void setId_tipo_suite(int id_tipo_suite) {
        this.id_tipo_suite = id_tipo_suite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Tipo_Suite getTipo_suite() {
        return tipo_suite;
    }

    public void setTipo_suite(Tipo_Suite tipo_suite) {
        this.tipo_suite = tipo_suite;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
