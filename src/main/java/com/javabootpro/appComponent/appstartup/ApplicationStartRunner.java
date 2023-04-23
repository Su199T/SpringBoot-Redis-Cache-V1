package com.javabootpro.appComponent.appstartup;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *   APP 启动
 */

//系统启动 初始化一些 数据
// 读取 数据库信息 保存到redis
@Component
@Slf4j
@Order(value = 1) //值越小 优先级越高
public class ApplicationStartRunner implements ApplicationRunner {

   // 可以注入
   @Value("${server.port}")
   private Integer httpsPort;

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("=========== ApplicationStartRunner run ===========");
        log.info("=========== 应用已经启动 ===========");
        log.info("应用名称: [{}] 启动端口: [{}]",appName,httpsPort);
        initSys();
    }

        private void initSys(){

    }
}
