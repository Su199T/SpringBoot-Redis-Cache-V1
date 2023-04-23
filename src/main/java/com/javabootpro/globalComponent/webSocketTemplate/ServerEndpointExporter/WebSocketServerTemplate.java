package com.javabootpro.globalComponent.webSocketTemplate.ServerEndpointExporter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Slf4j
@ServerEndpoint("/ws/{openId}")
@Component
public class WebSocketServerTemplate {


    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        log.info("on Open");
    }
}
