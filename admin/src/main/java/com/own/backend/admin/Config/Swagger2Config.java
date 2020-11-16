package com.own.backend.admin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author fangting
 * @create 2020/11/4 13:45
 * @description
 **/
@Configuration
public class Swagger2Config{

    @Bean
    public Docket createRestApi() {
        RequestParameterBuilder tokenBuilder = new RequestParameterBuilder();
        tokenBuilder
                .name("Authorization")
                .description("access_token")
                .required(false)
                .in("header")
                .build();
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.own.backend.admin.Controller")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("VUE_ADMIN_BACKEND").description("").contact(new Contact("fangting", "", "897045322@qq.com"))
                .version("1.0").build();
    }
}