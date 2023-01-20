package model.bean;

public class Hospedagem {

    private Suite suite;
    private Cliente cliente;
    private Funcionario funcionario;
    private String data_reserva;
    private String inf_pagamento;
    private int cartao_acesso;
    private String data_checkin;
    private String data_checkout;
    private Double valor;
    private int id_hospedagem;
    private int id_cliente;
    private int id_suite;
    

    public Hospedagem() {
        
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    
    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getId_hospedagem() {
        return id_hospedagem;
    }

    public void setId_hospedagem(int id_hospedagem) {
        this.id_hospedagem = id_hospedagem;
    }

    public String getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }

    public String getInf_pagamento() {
        return inf_pagamento;
    }

    public void setInf_pagamento(String inf_pagamento) {
        this.inf_pagamento = inf_pagamento;
    }

    public int getCartao_acesso() {
        return cartao_acesso;
    }

    public void setCartao_acesso(int cartao_acesso) {
        this.cartao_acesso = cartao_acesso;
    }

    

    public String getData_checkin() {
        return data_checkin;
    }

    public void setData_checkin(String data_checkin) {
        this.data_checkin = data_checkin;
    }

    public String getData_checkout() {
        return data_checkout;
    }

    public void setData_checkout(String data_checkout) {
        this.data_checkout = data_checkout;
    }

   

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_suite() {
        return id_suite;
    }

    public void setId_suite(int id_suite) {
        this.id_suite = id_suite;
    }

}
