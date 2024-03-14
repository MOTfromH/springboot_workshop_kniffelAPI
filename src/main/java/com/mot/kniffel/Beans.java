package com.mot.kniffel;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
public class Beans {


    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Kniffel Game API")
                        .description("Kniffel as a service - KaaS")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Kniffel Regeln")
                        .url("https://www.schmidtspiele.de/files/Produkte/4/49030%20-%20Kniffel/49203_49030_Kniffel_DE.pdf"));
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
