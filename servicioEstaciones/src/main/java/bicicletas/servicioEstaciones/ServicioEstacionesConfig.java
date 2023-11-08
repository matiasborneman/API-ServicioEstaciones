package bicicletas.servicioEstaciones;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicioEstacionesConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Servicio de Estaciones API")
                        .description("Microservicio API REST de Estaciones para el TPI")
                        .version("1.0"));
    }
}
