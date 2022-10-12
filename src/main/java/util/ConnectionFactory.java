package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todolist";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception exception) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados", exception);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao tentar fechar a conexão com o Banco de Dados", exception);
        }
    }

    public static void closeConnection(Connection connection, Statement statement){
        try{
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        } catch (Exception exception) {
            throw new RuntimeException ("Erro ao tentar fechar a conexão com o Banco de Dados", exception);
        }
    }
}
