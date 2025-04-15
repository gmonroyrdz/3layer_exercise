/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.uam;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.grizzly.http.server.StaticHttpHandler;

import java.io.File;
import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/";

    public static HttpServer startServer() {
        // Configuración de recursos
        final ResourceConfig config = new ResourceConfig()
                .packages("mx.uam.resource") // Paquete donde están tus recursos
                .register(OpenApiResource.class); // Registro de Swagger OpenAPI
  

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
        // Servir archivos estáticos de Swagger UI en /docs
        //StaticHttpHandler staticHandler = new StaticHttpHandler("src/main/resources/swagger-ui");
        StaticHttpHandler staticHandler = new StaticHttpHandler(new File("src/main/resources/swagger-ui/").getAbsolutePath());
        staticHandler.setFileCacheEnabled(false); // (opcional para desarrollo)
        
        
        server.getServerConfiguration().addHttpHandler(staticHandler, "/docs");
        return server;
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.println("Servidor corriendo en " + BASE_URI + "clients");
        System.out.println("Swagger JSON disponible en: " + BASE_URI + "openapi.json");
        System.out.println("Swagger UI disponible en: " + "http://localhost:8080/docs/index.html");
        try {
            Thread.currentThread().join(); // Mantener el servidor vivo
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


