package com.javabootpro.appComponent.thymeleaf;

import org.springframework.context.ApplicationContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

// 可以基于 yml 配置
// 该配置文件可以不配置
//@Configuration
public class ThymeleafConfig {

    /**
     * 创建模板解析器的bean
     * @param ctx
     * @return
     */
//    @Bean
    public SpringResourceTemplateResolver templateResolver(ApplicationContext ctx){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        // 设置解析器的属性，甚至可以使用自定义的属性
        templateResolver.setApplicationContext(ctx);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    /**
     *  创建模板引擎bean
     * @param templateResolver
     * @return
     */
//    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
//        Context context = new Context();
//        context.setVariable("baseIp","http://localhost:8021/");
        return templateEngine;
    }
}
