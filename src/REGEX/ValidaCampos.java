
package REGEX;
public class ValidaCampos {
    public static boolean validaNome (String nome){
        return nome.matches("\\p{Upper}[\\p{IsLatin}[ ]]+");   
    }
    
    
     public static boolean validaEndereco (String endereco){
        return endereco.matches("\\p{Upper}[\\p{IsLatin}\\p{Alnum}[ ][,-]]+");   
    }
     
     public static boolean validaEmail (String email){
        return email.matches("([\\p{Alnum}\\._-])+@([\\p{Alnum}])+(\\.([\\p{Alnum}])+)*");   
    }
     
     public static boolean validaFone (String fone){
        return fone.matches("\\(\\p{Digit}{2}\\)\\p{Digit}{4,5}-\\p{Digit}{4}");   
    } 
     
      public static boolean validaCpf (String cpf){
        return cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");   
    } 
      
      public static boolean validaCep (String cep){
        return cep.matches("[0-9]{5}-[\\d]{3}");   
    } 
      
     public static boolean validaUsuario (String usuario){
        return usuario.matches("[a-zA-Z0-9]{4,16}");   
    } 
     
       public static boolean validaSenha (String senha){
        return senha.matches("[a-zA-Z0-9@]{4,20}");   
    } 
     
    
      
      
     
  
      
  
  
      
     
    

    
}


