package com.javabootpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
//@EnableTransactionManagement
//@EnableScheduling
@SpringBootApplication
public class ApplicationServer {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationServer.class);
        // application.addListeners(); //https://www.cnblogs.com/sybblogs/p/10214165.html
        // 不推荐上面方式 因为Listener 里面不能注入bean
        //  参考使用 com.qd.parkourgame.modules.com.hfqd.common.runner.ApplicationStartRunner
        application.run(args);
    }
}
