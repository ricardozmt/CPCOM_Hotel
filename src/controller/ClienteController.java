
package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.ClienteDAO;

public class ClienteController {
    
     public void create(String profissao, String nome, String telefone, String cpf, String email, String cep, String logradouro, String numero, String complemento) {
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();

        cliente.setProfissao(profissao);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setCep(cep);
        cliente.setLogradouro(logradouro);
        cliente.setNumero(numero);
        cliente.setComplemento(complemento);
        
        

        clienteDAO.create(cliente);
    }

    public  void ClienteController() {
    }
    
    public ArrayList<Cliente> read(){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read();
    }

    public void update (int id_cliente, String profissao, String nome, String telefone, String cpf, String email, String cep, String logradouro, String numero, String complemento){
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();

        cliente.setProfissao(profissao);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setCep(cep);
        cliente.setLogradouro(logradouro);
        cliente.setNumero(numero);
        cliente.setComplemento(complemento);
        
        clienteDAO.update(cliente);
        
    }
    
    public void delete(int id_cliente){
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        cliente.setId_cliente(id_cliente);
        clienteDAO.delete(cliente);
        
    }
    
   public ArrayList<Cliente> buscar(String nome){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getListaClienteporNome(nome);
    }
    
}



