package com.w.attendance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger自定义配置类实现
 *
 * @author: vipinchan
 * @date: 2019/4/25 11:19 AM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        List<Parameter> parameters = new ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2)
                // 分组名
                .groupName("考勤系统")
                .apiInfo(apiInfo())
                .select()
                // 指定接口所有包路径
                .apis(RequestHandlerSelectors.basePackage("com.w.attendance.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 服务标题
                .title("考勤系统api文档")
                // 服务地址
                .termsOfServiceUrl("")
                // 服务负责人信息
                .contact(new Contact("Magic","http://ww.baidu.com","2536862227@qq.com"))
                .version("1.0.2")
                .build();
    }
}
