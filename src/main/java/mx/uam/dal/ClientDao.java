package mx.uam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements EntityDao{

    private Connection connection;

    public ClientDao() {
        DbConnection db = new DbConnection();
        db.connect();
        this.connection = db.getConnection();
    }

    @Override
    public void getAll() {
        try {
            List<Cliente> clientes = new ArrayList<>();

            String sql = "SELECT * FROM cliente";
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setUsername(rs.getString(2));
                cliente.setName(rs.getString(3));
                cliente.setLastname(rs.getString(4));
                cliente.setAge(rs.getString(5));
                clientes.add(cliente);
                System.out.println(cliente.toString());
            }
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
    }

    //public int save(String username, String name, String lastname, String age) {
    public int save(Cliente cliente){
        try {
            // Definimos la sentencia SQL
            String sql = "INSERT INTO cliente VALUES(0,?,?,?,?)";
            // Creación de la sentencia (Statement)
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getUsername());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getLastname());
            stmt.setString(4, cliente.getAge());
            stmt.execute();

            return -1;
        } catch (SQLException ex) {
            System.err.println(ex.getStackTrace());
        }
        return -1;
    }

    /**
     * 
     * @param cliente
     */
    public void update(Cliente cliente){
        
    }

    public boolean delete(int id){
        return false;
    }

    public boolean delete(Cliente cliente){
        return false;
    }


}
