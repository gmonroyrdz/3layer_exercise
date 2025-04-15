/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.uam;

import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author 
 */
public class Ex1 {


    /*
    public static void main(String[] args) {
         // Launching GestionClientesUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionClientesUI().setVisible(true);
            }
        });
    }
    */

    public static final String BASE_URI = "http://localhost:8080/api/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("mx.uam.resource");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.println("Servidor iniciado en " + BASE_URI);
    }

}


