package com.apoio.apoio_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("APOIO Platform - API Backend")
                        .version("1.0.0")
                        .description("REST API for the APOIO ecosystem (Integrated Post-Occupancy Evaluation Oriented to Urbanism). "
                                + "A platform for citizen auditing and multifactorial diagnosis of public spaces.")
                        .contact(new Contact()
                                .name("Mylena Avellar")
                                .email("mylenatavellar@gmail.com")
                                .url("https://github.com/mylenaavellar"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}