package com.javabootpro.appModules.testTemplate.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootpro.appComponent.constant.ResultCode;
import com.javabootpro.appComponent.controllerResult.ResultDTO;
import com.javabootpro.appModules.testTemplate.entity.domain.FruitDO;
import com.javabootpro.appModules.testTemplate.entity.domain.PersonDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    // 可以返回中文 不乱码
    @GetMapping("/t0")
    public ResultDTO<FruitDO> t1(){
        ResultDTO<FruitDO> result = new ResultDTO<>("", ResultCode.OK_CODE);
        FruitDO fruitDO = new FruitDO();
        fruitDO.setName("水果");
        result.setData(fruitDO);
        return result;
    }

    // jackson 测试
    //
    @GetMapping("jsonTest1")
    public String jsonTest1(@RequestBody JSONObject jsonParam  ){
        log.info("sendTo ,传来数据 {}",jsonParam.toJSONString());
        return jsonParam.toJSONString();
    }

    // 出现
    //  ObjectMapper mapper
//    @PostMapping(value = "jsonTest2",consumes = "application/json;charset=UTF-8",produces = "application/json")
//    public  void jsonTest2(@RequestBody ObjectMapper mapperParam){
//        log.info("sendTo ,传来数据 {}",mapperParam.toString());
////        return mapperParam.toString();
//
//    }

    @RequestMapping(value = "jsonTest2",consumes = "application/json;charset=UTF-8",produces = "application/json")
    public String jsonTest2(@RequestBody ObjectMapper mapperParam){
//        log.info("sendTo ,传来数据 {}",mapperParam.toString());
        return mapperParam.toString();

    }


    // 传来的 json 数据示例
    // {"id":"689895","name":"tom","age":18}
    @GetMapping("jsonTest3")
    public String jsonTest3(@RequestBody PersonDO jsonParam){
        log.info("传来数据 {}",jsonParam.toString());
        return jsonParam.toString();
    }

    @GetMapping("jsonTest4")
    public String jsonTest4(@RequestBody PersonDO jsonParam){
        log.info("传来数据 {}",jsonParam.toString());
        // 将 实体类 转为 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        try {
           String jsonStr = mapper.writeValueAsString(jsonParam);
           // 打印 {"id":"689895","name":"tom","age":18}
           log.info("转为 json 字符串 {}",jsonStr);
        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonParam.toString();
    }

}
