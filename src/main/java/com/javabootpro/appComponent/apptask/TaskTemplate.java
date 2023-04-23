package com.javabootpro.appComponent.apptask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskTemplate {

    // initialDelay= 20000 第一次延迟 20秒
    //
    // 5 秒更新一次排行
//    @Scheduled(initialDelay = 5000 ,fixedRate = 5000)
//    public void t1(){
//        log.info("[{}]",Thread.currentThread().getName());
//    }
//
//    @Scheduled(initialDelay = 5000 ,fixedRate = 3000)
//    public void t2(){
//        log.info("[{}]",Thread.currentThread().getName());
//    }

}
