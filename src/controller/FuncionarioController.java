package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.FuncionarioDAO;
import model.bean.Funcionario;
import model.dao.ClienteDAO;

public class FuncionarioController {

    
    
    public ArrayList<Funcionario> read() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.read();
    }
    
    
    public void update(String numero_cdt, String nome, String telefone, String cpf, String email, String cep, String logradouro, String numero, String complemento, String cargo, String usuario, String senha, int id_funcionario) {
        Funcionario fun = new Funcionario();
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        fun.setNumero_cdt(numero_cdt);
        fun.setNome(nome);
        fun.setTelefone(telefone);
        fun.setCpf(cpf);
        fun.setEmail(email);
        fun.setCep(cep);
        fun.setLogradouro(logradouro);
        fun.setNumero(numero);
        fun.setComplemento(complemento);
        fun.setCargo(cargo);
        fun.setUsuario(usuario);
        fun.setSenha(senha);
        fun.setId_funcionario(id_funcionario);

        funcionarioDAO.update(fun);

    }

    public boolean verificaLogin(String usu, String senha) {
        FuncionarioDAO usuarioDAO = new FuncionarioDAO();

        Funcionario usuario = new Funcionario();
        usuario.setUsuario(usu);
        usuario.setSenha(senha);

        return usuarioDAO.verificaLogin(usuario);
    }

    
     public void createCRIP(String numero_cdt, String nome, String telefone, String cpf, String email, String cep, String logradouro, String numero, String complemento, String cargo, String usuario, String senha) {
        Funcionario fun = new Funcionario();
        
        fun.setNumero_cdt(numero_cdt);
        fun.setNome(nome);
        fun.setTelefone(telefone);
        fun.setCpf(cpf);
        fun.setEmail(email);
        fun.setCep(cep);
        fun.setLogradouro(logradouro);
        fun.setNumero(numero);
        fun.setComplemento(complemento);
        fun.setCargo(cargo);
        fun.setUsuario(usuario);
        fun.setSenha(senha);

        FuncionarioDAO usuarioDAO = new FuncionarioDAO();
        usuarioDAO.createCRIP(fun);
        
    }
     
      public ArrayList<Funcionario> getListaFuncionarioporNome(String nome) {
          FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.getListaFuncionarioporNome(nome);
    }
     
      public void delete(int id_funcionario) {
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        funcionario.setId_funcionario(id_funcionario);
        funcionarioDAO.delete(funcionario);

    }

   
     
}
