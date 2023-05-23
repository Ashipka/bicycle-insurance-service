package io.swagger.configuration;

import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Insurance API")
                .packagesToScan("io.swagger.api")
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Bicycle Insurance API")
                .description("API for calculating premiums for bicycle insurance policies")
                .termsOfService("")
                .version("1.0")
                .license(apiLicense())
                .contact(apiContact()));
    }

    private License apiLicense() {
        return new License()
                .name("")
                .url("http://unlicense.org");
    }

    private Contact apiContact() {
        return new Contact()
                .name("Oleksandr Shypka")
                .email("a.s.shipka@gmail.com")
                .url("https://github.com/Ashipka/bicycle-insurance-service");
    }

}
