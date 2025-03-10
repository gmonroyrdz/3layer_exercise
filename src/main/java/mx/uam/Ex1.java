/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.uam;

import mx.uam.dal.ClientDao;
import mx.uam.dal.Cliente;

/**
 *
 * @author 
 */
public class Ex1 {

    public static void main(String[] args) {
        ClientDao clientDao = new ClientDao();

        // Test save() method
        Cliente cliente = new Cliente("luisN", "Luis", "Narvarte", "50");
        Cliente insertado = clientDao.save(cliente);
        System.out.println("Inserted: " + insertado);

        // Test getAll() method
        System.out.println("All clients:");
        for (Cliente c : clientDao.getAll()) {
            System.out.println(c);
        }

        // Test update() method
        insertado.setName("Luis Updated");
        Cliente actualizado = clientDao.update(insertado);
        System.out.println("Updated: " + actualizado);

        // Test getAll() method again
        System.out.println("All clients after update:");
        
        for (Cliente c : clientDao.getAll()) {
            System.out.println(c);
        }

        // Test delete() method
        boolean deleted = clientDao.delete(insertado.getId());
        System.out.println("Deleted: " + deleted);

        // Test getAll() method again
        System.out.println("All clients after delete:");
        for (Cliente c : clientDao.getAll()) {
            System.out.println(c);
        }
    }
}


