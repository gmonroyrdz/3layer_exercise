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
        clientDao.getAll();
        System.out.println("ANTES DEL NUEVO REGISTRO");
        Cliente cliente = new Cliente("luisN", "Luis", "Narvarte", "50");
        clientDao.save(cliente);
        clientDao.getAll();

    }
}


