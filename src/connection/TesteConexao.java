package connection;

import java.sql.Connection;
  
public class TesteConexao {

    public static void main(String args[]) {

        Connection con = ConnectionFactory.getConnection();

        if (con != null) {
            System.out.println("Conectado com sucesso!");
        }
    }

}
