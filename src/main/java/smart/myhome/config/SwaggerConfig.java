package smart.myhome.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myHomeApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Example Swagger Api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("ml2003@list.ru")
                                                .url("https://")
                                                .name("Карманова Анна")
                                )
                );
    }

}
