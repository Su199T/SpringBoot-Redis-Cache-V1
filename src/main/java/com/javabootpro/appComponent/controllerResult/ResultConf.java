package com.javabootpro.appComponent.controllerResult;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResultConf {

    @Bean(name = "RS_")
    ResultDTO<Boolean> resultDTO1(){
        return new ResultDTO<Boolean>();
    }
}
