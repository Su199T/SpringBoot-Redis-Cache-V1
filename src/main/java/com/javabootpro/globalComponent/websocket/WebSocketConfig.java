package com.javabootpro.globalComponent.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启WebSocket支持
 * @author zhengkai
 */
@Configuration
public class WebSocketConfig {

    // 注入一个 ServerEndpointExporter
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

//    @Bean
//    public ServerEndpointExporter serverEndpointExporter2() {
//        return new ServerEndpointExporter();
//    }
}