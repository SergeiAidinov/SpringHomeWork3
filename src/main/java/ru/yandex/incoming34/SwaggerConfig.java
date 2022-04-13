package ru.yandex.incoming34;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan({"ru.yandex.incoming34.controller", "ru.yandex.incoming34.entities", "ru.yandex.incoming34.service"})
public class SwaggerConfig {
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("ru.yandex.incoming34"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
}
