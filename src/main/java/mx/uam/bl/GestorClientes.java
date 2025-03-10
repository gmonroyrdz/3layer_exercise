package mx.uam.bl;

import java.util.List;

import mx.uam.dal.entities.Cliente;
import mx.uam.dal.entities.Domicilio;

public class GestorClientes {

    public Cliente agregarCliente(Cliente cliente) {
        return null;
    }

    public boolean eliminarCliente(int id) {
        return false;
    }

    public void agregarDomicilio(Cliente cliente, Domicilio domicilio) {
        // Implementation for adding an address to a client
    }

    public void eliminarDomicilio(Cliente cliente, Domicilio domicilio) {
        // Implementation for deleting an address from a client
    }

    public void autenticacion(String username, String password) {
        // Implementation for accessing a client
    }

    public List<Cliente> getAllClients() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
