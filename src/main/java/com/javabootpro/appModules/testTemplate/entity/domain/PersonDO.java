package com.javabootpro.appModules.testTemplate.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


// 使用 @RequestBody  注解接收json的时候  必须加上 构造器
// 如果是 VO 必须加上构造器注解
// 这里使用 lombok 的注解
@Accessors(chain = true)   //链式set
@AllArgsConstructor  //生成全参数构造函数
@NoArgsConstructor //生成无参构造函数
@Builder(toBuilder=true) //Builder的作用之一是为了解决在某个类有很多构造函数的情况，也省去写很多构造函数  修改实体，要求实体上添加@Builder(toBuilder=true)
@Data //生成Getter,Setter,equals,canEqual,hasCode,toString等方法
public class PersonDO implements Serializable {
    private String id;
    private String name;
    private Integer age;
}
