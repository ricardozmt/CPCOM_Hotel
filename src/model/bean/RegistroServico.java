package model.bean;

public class RegistroServico {

    private String descricao;
    private double valor;
    private int id_registro_servicos;
    private int id_hospedagem;

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

    public int getId_registro_servicos() {
        return id_registro_servicos;
    }

    public void setId_registro_servicos(int id_registro_servicos) {
        this.id_registro_servicos = id_registro_servicos;
    }

    public int getId_hospedagem() {
        return id_hospedagem;
    }

    public void setId_hospedagem(int id_hospedagem) {
        this.id_hospedagem = id_hospedagem;
    }

   

}
