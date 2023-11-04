package br.com.eletrica.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.eletrica.api"))
                .paths(PathSelectors.regex("/dimensionar(/condutores|/disjuntores|/eletrodutos)?"))
                .build()
                .apiInfo(apiInfo());
}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Solucao Eletrica")
                .description("API para dimensionamento de componentes eletricos em circuitos residenciais.")
                .version("1.0")
                .contact(new Contact("LarissaGB01", "https://github.com/LarissaGB01/solucao_eletrica_backend", "larissa.barcelos@sempreceub.com"))
                .build();
    }

}
