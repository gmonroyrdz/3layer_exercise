/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.uam;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/";

    public static HttpServer startServer() {
        // Configuración de recursos
        final ResourceConfig config = new ResourceConfig()
                .packages("mx.uam.resource") // Paquete donde están tus recursos
                .register(OpenApiResource.class); // Registro de Swagger OpenAPI
                //.register(JacksonJaxbJsonProvider.class); // Registro de Jackson para JSON

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.println("Servidor corriendo en " + BASE_URI + "clients");
        System.out.println("Swagger JSON disponible en: " + BASE_URI + "openapi.json");
        System.out.println("Swagger UI disponible en: " + BASE_URI + "swagger-ui/");
        try {
            Thread.currentThread().join(); // Mantener el servidor vivo
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


