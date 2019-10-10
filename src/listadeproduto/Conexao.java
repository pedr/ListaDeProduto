package listadeproduto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
    
    private static String driveName = "com.mysql.jdbc.Driver";
    private static String dsn = "jdbc:mysql://localhost/lista_de_produtos";
    private static String username = "root";
    private static String password = "";
    
    private static Connection connection;
    
    public static Connection getConexao() {
        
        if (connection == null) {
            try {
                Class.forName(driveName);
                
                connection = DriverManager.getConnection(dsn, username, password);
                
                criarBanco();
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return connection;
    }
    
    public static void criarBanco() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos ("
                + "id int AUTO_INCREMENT, "
                + "cod varchar(128), "
                + "descricao varchar(256), "
                + "PRIMARY KEY (id)"
                + ")";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);   
        }
    }
    
}
