package mx.uam.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.integration.SwaggerConfiguration;

public class OpenApiConfig {

    public static SwaggerConfiguration getSwaggerConfiguration() {
        OpenAPI openAPI = new OpenAPI()
                .info(new Info()
                        .title("API de Ejemplo")
                        .version("1.0")
                        .description("Documentación de la API"));

        SwaggerConfiguration config = new SwaggerConfiguration()
                .openAPI(openAPI)
                .prettyPrint(true);

        return config;
    }
}
