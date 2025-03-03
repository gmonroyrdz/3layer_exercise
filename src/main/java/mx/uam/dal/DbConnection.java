package mx.uam.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private String database = "jdbc:mysql://";
    private String host = "localhost";
    private String port = "3306";
    private String scheme = "shop";
    private String user ="root";
    private String pass = "7vvlryPngn";

    private Connection connection;

    private String getStringConnection(){
        StringBuilder str = new StringBuilder();
        str.append(database);
        str.append(host);
        str.append(":");
        str.append(port);
        str.append("/");
        str.append(scheme);
        return str.toString();
    }

    public void connect(){
        try {
            String stringConnection = getStringConnection();
            this.connection = DriverManager. getConnection(stringConnection,user,pass);
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void disconnect() throws SQLException{
        if (this.connection != null){
            this.connection.close();
        }
    }

    
}
