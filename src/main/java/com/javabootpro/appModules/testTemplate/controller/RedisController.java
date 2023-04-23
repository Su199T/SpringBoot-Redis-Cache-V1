package com.javabootpro.appModules.testTemplate.controller;

import com.javabootpro.appModules.testTemplate.entity.domain.PersonDO;
import com.javabootpro.globalComponent.redis.MyRedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    static String listKey1 = "listK1";

    @Autowired
    ListOperations<String, Object> listOperations;

    @Autowired
    MyRedisTemplate myRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> template;


    @Autowired
    ZSetOperations<String, Object> zSetOperations;


    // 注解@PostConstruct与@PreDestroy讲解及实例
    // https://blog.csdn.net/yaerfeng/article/details/8447530
    @PostConstruct
    public void init(){
        log.info("RedisController #init()");
    }

    @GetMapping("/rPush")
    public String rightPush(){
        stringRedisTemplate.expire(listKey1,5, TimeUnit.SECONDS);
        // 使用  ListOperations<String, Object> 操作 list
        listOperations.rightPush(listKey1,new PersonDO().setAge(20).setId("kk1"));

        template.opsForList().rightPush(listKey1,new PersonDO().setAge(20).setId("kk2"));

        myRedisTemplate.rightPushToList(listKey1,new PersonDO().setAge(20).setId("kk3"));

        return "ok";
    }

    @GetMapping("/readAll")
    public List<Object> readAll(){
        return listOperations.range(listKey1,0,-1);
    }


    @GetMapping("/rankTest")
    public String rank(){
//        zSetOperations.
        return null;
    }



}
