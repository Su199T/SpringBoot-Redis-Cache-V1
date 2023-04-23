package com.javabootpro.appModules.websocket;

import com.javabootpro.globalComponent.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
@RequestMapping("/websocket")
@Controller
public class WebSocketController {

//    @GetMapping("index")
//    public ResponseEntity<String> index(){
//        return ResponseEntity.ok("请求成功");
//    }

    //界面
//    @GetMapping("page")
//    public ModelAndView page(){
//        return new ModelAndView("webSocket");
//    }

    @GetMapping("/index")
    public String page(){
        // 当前线程名称: [http-nio-8881-exec-4]
        // 当前线程名称: [http-nio-8881-exec-5]
        log.info("当前线程名称: [{}]",Thread.currentThread().getName());
        return "/webSocket.html";
    }




    @GetMapping("/webSocketTemp")
    public String webSocketPage(){
        return "/webSocket-template.html";
    }

    // 向 userId 为10 的用户推送消息
    // http://localhost:8881/push/10?msg=hello
    @GetMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(@RequestParam(value = "msg",required = true) String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("已成功向id为"+toUserId+"用户发送【"+message+"】");
    }
}
