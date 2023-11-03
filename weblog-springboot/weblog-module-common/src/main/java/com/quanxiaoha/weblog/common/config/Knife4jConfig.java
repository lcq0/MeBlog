package com.quanxiaoha.weblog.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: lcq
 * @Date: 2023/10/31 10:56
 */
@Configuration
//@EnableSwagger2
@EnableKnife4j
//@Profile(value = {"dev","test"})
public class Knife4jConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.asiabill.bank"))
                //.apis(RequestHandlerSelectors.basePackage("com.moneycollect.bank.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description("银行接口测试文档")
                .contact(new Contact("银行接口", "", ""))
                .version("v1.0.0")
                .title("银行接口测试文档")
                .build();
    }

}
