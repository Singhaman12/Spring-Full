package com.example.springbootfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
//@EnableResourceServer
//@EnableAuthorizationServer
public class SpringBootFullApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFullApplication.class, args);
    }
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootfull"))
                .build();
                //.apiInfo(apiDetails());
    }

//    private ApiInfo apiDetails(){
//        return new ApiInfo(
//                "Department Information Systemn API",
//                "1.0",
//                "Free to Use",
//                new springfox.documentation.service.Contact("Aman Singh","http://singh/dept/info.ca","info.dept@ca"),
//                "API License",
//                Collections.emptyList());
//
//    }

}
