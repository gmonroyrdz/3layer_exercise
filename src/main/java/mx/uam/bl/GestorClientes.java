package mx.uam.bl;

import java.util.ArrayList;
import java.util.List;

import mx.uam.bl.dto.ClienteDto;
import mx.uam.dal.ClientDao;
import mx.uam.dal.entities.Cliente;
import mx.uam.dal.entities.Domicilio;

public class GestorClientes {
    ClientDao clienteDao = new ClientDao();

    public ClienteDto agregarCliente(Cliente cliente) {
        

        Cliente savedClient = clienteDao.save(cliente);

       
        return new ClienteDto();
    }

    public boolean eliminarCliente(int id) {
        return false;
    }

    public ClienteDto agregarDomicilio(Cliente cliente, Domicilio domicilio) {
        
        // Se realiza el Mapping a partir de las entities Cliente y Domicilio hacia el Dto para el Cliente en el PL.

        ClienteDto dto = new ClienteDto();
        dto.setName(cliente.getName());
        dto.setLastname(cliente.getLastname());
        dto.setAge(cliente.getAge());
        dto.setCalle(domicilio.getCalle());
        dto.setColonia(domicilio.getColonia());
        dto.setCiudad(domicilio.getCiudad());

        // update en cliente para agregar o asociar el domicilio en la BD a traves de la DAL

        return dto;
    }

    public void eliminarDomicilio(Cliente cliente, Domicilio domicilio) {
        // Implementation for deleting an address from a client
    }

    public void autenticacion(String username, String password) {
        // Implementation for accessing a client
    }

    public List<ClienteDto> getAllClients() {
        List<Cliente> clientes = clienteDao.getAll();
        List<ClienteDto> clientesDto = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDto dto = new ClienteDto();
            dto.setName(cliente.getName());
            dto.setLastname(cliente.getLastname());
            dto.setAge(cliente.getAge());
            // Add other properties as needed
            clientesDto.add(dto);
        }
        return clientesDto;

    }

    public Cliente getUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

}
