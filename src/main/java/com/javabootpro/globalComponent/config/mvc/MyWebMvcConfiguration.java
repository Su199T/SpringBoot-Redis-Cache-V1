package com.javabootpro.globalComponent.config;


import com.javabootpro.globalComponent.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


// 关于 拦截器的注入 问题
// 一个坑
// 关于使用 @Autowired 注入是null 的情况
// https://blog.csdn.net/qq_40980680/article/details/103167170


// 关于 拦截器的注入 更多参考 :
// 在 Interceptor 中使用 @autowired 自动注入
// https://blog.csdn.net/SwordSnapLiu/article/details/79665861


//使用 WebMvcConfigurationSupport
@Configuration
public class MyWebMvcConfiguration extends WebMvcConfigurationSupport {


    //====================================== Spring Boot 的bean 的注入  ======================================

    //拦截器必须使用这种方法注入 否则拦截器里面注入的 会是null
    @Bean
    BaseInterceptor getBaseInterceptor(){
        return new BaseInterceptor();
    }

    //拦截器必须使用这种方法注入 否则拦截器里面注入的 会是null
//    @Bean
//    UserLoginInterceptor getUserLoginInterceptor() {
//        return new UserLoginInterceptor();
//    }


    //====================================== 对json 的配置  ======================================
    // https://blog.csdn.net/EnjoySelfLife/article/details/79009417
    //解决返回的Json中文乱码 没有成功
    @Bean
    public HttpMessageConverter responseBodyConverter() {
        // StandardCharsets.UTF_8   Charset.forName("UTF-8")
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        return converter;
    }

    //除了上面的 还需添加下面的 解决了乱码问题
    // https://blog.csdn.net/weixin_42278016/java/article/details/105731012

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        List<StringHttpMessageConverter> stringHttpMessageConverters = converters.stream()
                .filter(converter -> converter.getClass().equals(StringHttpMessageConverter.class))
                .map(converter -> (StringHttpMessageConverter) converter)
                .collect(Collectors.toList());

        if (stringHttpMessageConverters.isEmpty()) {
            converters.add(responseBodyConverter());
        } else {
            stringHttpMessageConverters.forEach(converter -> converter.setDefaultCharset(StandardCharsets.UTF_8));
        }
    }


    //========  使用示例 使用 fastJson========
//    @ResponseBody
//    @PostMapping(value = "/queryData")
//    public String queryData(@RequestBody JSONObject jsonParam, HttpServletResponse response){
//        JSONObject jsonObject =new JSONObject();
//        //  HttpUtils.responseAjaxJson(response,jsonObject);
//        return jsonObject.toJSONString();
//    }

    //======================================  ======================================
    //Spring Boot2精髓 p64
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }

    //====================================== 对 url 资源的处理 ======================================
    //不拦截的 url 资源
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 映射 本地系统文件
        // http://localhost:8021/filePath/write.txt  ---> F:\write.txt
//        registry.addResourceHandler("/filePath/**").addResourceLocations("file:/F:/");

        //不拦截的url
        // 把/res/** 请求 映射到 src\main\resources\res
        //localhost:9906//res/test.png
        registry.addResourceHandler("/res/**").addResourceLocations("classpath:/res/");

        // 推荐静态资源都放在这个文件夹下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        // registry.addResourceHandler("/swagger-ui.html/**");

        super.addResourceHandlers(registry);
    }

    //====================================== 添加请求拦截器  ======================================
    //拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链

        registry.addInterceptor(getBaseInterceptor())
                .addPathPatterns("/**")
                 .excludePathPatterns(
                         "/res/**", "/static/**", //静态资源 (生产环境必须保留)
                         "/auth/**" //登录首页
                 );

//        registry.addInterceptor(getUserLoginInterceptor())
//                .addPathPatterns("/user/**","/game/**","/share/**","/giftPack/getReward")
//        .excludePathPatterns("/giftPack/generate","/auth/**");

         //拦截器
        super.addInterceptors(registry);
    }


    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    /**
     * 利用fastjson替换掉jackson，且解决中文乱码问题
     * @param converters
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
////        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        // 处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMediaTypes);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastConverter);
//    }
}
