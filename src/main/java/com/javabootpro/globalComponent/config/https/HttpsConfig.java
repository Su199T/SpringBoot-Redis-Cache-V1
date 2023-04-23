package com.javabootpro.globalComponent.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// SSL 配置类
// 根据
// 本地测试需屏蔽 该 @Configuration 注解
@Slf4j
@Configuration
public class HttpsConfig {

//    使用  http请求会报错
// java.lang.IllegalArgumentException: Invalid character found in method name. HTTP method names must be tokens


    // 读取配置文件的配置
    @Value("${server.custom.httpPort}")
    private Integer httpPort;

    //
    @Value("${server.port}")
    private Integer httpsPort;

    // 如果是 dev , 读取 application-dev.yml 配置文件 里面 没有ssl配置
    // 如果是 prod , 读取 application-prod.yml 配置文件 里面 有ssl配置
    @Value("${spring.profiles.active}")
    private String active;// 项目加载的配置文件名称  // prod 、dev


    // 不能注入 null
    //  通过 读取配置的 active 属性, 注入一个 Tomcat 配置bean

    // 更改了配置 本地 http 测试不需要屏蔽注解了
    // 本地测试需屏蔽 该 @Bean 注解
    @Bean
    public TomcatServletWebServerFactory servletContainer() { //springboot2 新变化

        log.info("active : [{}]",active);

        // 测试时 不配置 ssl 证书  ,  则 只返回一个实体类
        if (active.equals("dev") || active.equals("test") ){
            TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() ;
            return tomcat;
//            return null; // 会造成注入空指针 问题

        }else {
            // 如果配置 ssl 证书, 则返回一个new
            TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {

                @Override
                protected void postProcessContext(Context context) {

                    SecurityConstraint securityConstraint = new SecurityConstraint();
                    securityConstraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    collection.addPattern("/*");
                    securityConstraint.addCollection(collection);
                    context.addConstraint(securityConstraint);
                }
            };
            tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
            return tomcat;
        }


    }

    private Connector initiateHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }
}
