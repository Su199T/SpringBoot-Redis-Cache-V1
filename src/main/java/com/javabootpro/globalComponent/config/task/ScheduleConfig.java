package com.javabootpro.globalComponent.config.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// https://blog.csdn.net/zc_ad/article/details/83340861
// 注意 Spring Boot里面的定时任务是单线程的
// 所以应该配置 一个线程池
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Value("${task.scheduling.corePoolSize}")
    private Integer corePoolSize;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(corePoolSize); //指定线程池大小
    }
}