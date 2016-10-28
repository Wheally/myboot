package com.hzm.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @desc SpringBoot中集成Swagger
 * Created by WXQ on 2016/10/20.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .forCodeGeneration(true)
                .apiInfo(testApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hzm.boot"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .forCodeGeneration(true)
                .apiInfo(demoApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hzm.boot"))
                .paths(PathSelectors.any()).build();
    }


    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("SpringBoot学习test", // 大标题
                "Spring boot + swagger + mybatis + dubbo", // 小标题
                "2.0",
                "我来贷Welab service", "wenxiaoqian@wolaidai.com",
                "我来贷Welab", // 链接显示文字
                "http://www.wolaidai.com/"// 网站链接
        );
        return apiInfo;
    }

    private ApiInfo demoApiInfo() {
        ApiInfo apiInfo = new ApiInfo("SpringBoot学习demo", // 大标题
                "Spring boot + swagger + mybatis + dubbo", // 小标题
                "2.0",
                "我来贷Welab service", "wenxiaoqian@wolaidai.com",
                "我来贷Welab", // 链接显示文字
                "http://www.wolaidai.com/"// 网站链接
        );
        return apiInfo;
    }

}
