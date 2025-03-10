package mx.uam.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements EntityDao<Cliente>{

    private Connection connection;

    public ClientDao() {
        DbConnection db = new DbConnection();
        db.connect();
        this.connection = db.getConnection();
    }

    @Override
    public List<Cliente> getAll() {
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
            }
            return  clientes;
          } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> getByExample(Cliente cliente){
        List<Cliente> foundClientes = new ArrayList<>();
        try {
            String sql = "SELECT * from cliente WHERE username=? or name=? or lastname=? or age=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getUsername());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getLastname());
            stmt.setString(4, cliente.getAge());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente found = new Cliente();
                found.setId(rs.getInt(1));
                found.setUsername(rs.getString(2));
                found.setName(rs.getString(3));
                found.setLastname(rs.getString(4));
                found.setAge(rs.getString(5));
                foundClientes.add(found);
                //System.out.println(found.toString());
            }
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en la consulta: " + e.getMessage());
            e.printStackTrace();
        }
        return foundClientes;
    }

    @Override
    public Cliente save(Cliente cliente){
        try {
            String sql = "INSERT INTO cliente (username, name, lastname, age) VALUES(?,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getUsername());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getLastname());
            stmt.setString(4, cliente.getAge());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                cliente.setId(rs.getInt(1));
                return cliente;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Cliente update(Cliente cliente){
        try {
            String sql = "UPDATE cliente SET username=?, name=?, lastname=?, age=? WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cliente.getUsername());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getLastname());
            stmt.setString(4, cliente.getAge());
            stmt.setInt(5, cliente.getId());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return cliente;
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id){
        try {
            String sql = "DELETE FROM cliente WHERE id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Cliente cliente){
        return delete(cliente.getId());
    }
}