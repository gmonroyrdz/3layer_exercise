package mx.uam.pl;

import mx.uam.bl.GestorClientes;
import mx.uam.dal.entities.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionClientesUI extends JFrame {
    private GestorClientes gestionClientes;
    private JTextArea textArea;

    public GestionClientesUI() {
        gestionClientes = new GestorClientes();
        setTitle("Gestión de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton btnLoadClients = new JButton("Cargar Clientes");
        btnLoadClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadClients();
            }
        });
        buttonPanel.add(btnLoadClients);

        JButton btnAddClient = new JButton("Agregar Cliente");
        btnAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });
        buttonPanel.add(btnAddClient);

        JButton btnUpdateClient = new JButton("Actualizar Cliente");
        btnUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClient();
            }
        });
        buttonPanel.add(btnUpdateClient);

        JButton btnDeleteClient = new JButton("Eliminar Cliente");
        btnDeleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });
        buttonPanel.add(btnDeleteClient);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }

    private void loadClients() {
        List<Cliente> clientes = gestionClientes.getAllClients();
        textArea.setText("");
        for (Cliente cliente : clientes) {
            textArea.append(cliente.toString() + "\n");
        }
    }

    private void addClient() {
        String username = JOptionPane.showInputDialog(this, "Username:");
        String name = JOptionPane.showInputDialog(this, "Name:");
        String lastname = JOptionPane.showInputDialog(this, "Lastname:");
        String age = JOptionPane.showInputDialog(this, "Age:");
        Cliente cliente = new Cliente(username, name, lastname, age);
        Cliente savedCliente = gestionClientes.agregarCliente(cliente);
        if (savedCliente != null) {
            JOptionPane.showMessageDialog(this, "Cliente agregado: " + savedCliente);
            loadClients();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente.");
        }
    }

    private void updateClient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del Cliente a actualizar:"));
        String username = JOptionPane.showInputDialog(this, "Nuevo Username:");
        String name = JOptionPane.showInputDialog(this, "Nuevo Name:");
        String lastname = JOptionPane.showInputDialog(this, "Nuevo Lastname:");
        String age = JOptionPane.showInputDialog(this, "Nuevo Age:");
        Cliente cliente = new Cliente(username, name, lastname, age);
        cliente.setId(id);
        Cliente updatedCliente = gestionClientes.agregarCliente(cliente);
        if (updatedCliente != null) {
            JOptionPane.showMessageDialog(this, "Cliente actualizado: " + updatedCliente);
            loadClients();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar cliente.");
        }
    }

    private void deleteClient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del Cliente a eliminar:"));
        boolean deleted = gestionClientes.eliminarCliente(id);
        if (deleted) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado.");
            loadClients();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar cliente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionClientesUI().setVisible(true);
            }
        });
    }
}
