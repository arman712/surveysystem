package ru.fr.surveysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SurveysystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveysystemApplication.class, args);




    }


  /*  @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.fr.surveysystem.*"))
                .paths(PathSelectors.any())
                .build();
    }*/
}
