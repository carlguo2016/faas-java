package com.asu.ota.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: carl
 * @Date: 2020-04-01 14:10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Ota接口文档")
                .apiInfo(new ApiInfoBuilder()
                        .title("Ota接口文档")
                        .contact(new Contact("asu", "", "asu@cloud.com")).version("1.0")
                        .build())
                .select().paths(PathSelectors.any()).build();
    }
}
