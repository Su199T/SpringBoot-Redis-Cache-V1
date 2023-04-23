package com.javabootpro.utils.reflect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Accessors(chain = true)   //链式set
@AllArgsConstructor  //生成全参数构造函数
@NoArgsConstructor //生成无参构造函数
@Builder(toBuilder=true) //Builder的作用之一是为了解决在某个类有很多构造函数的情况，也省去写很多构造函数  修改实体，要求实体上添加@Builder(toBuilder=true)
@Data //生成Getter,Setter,equals,canEqual,hasCode,toString等方法
public class TestReflectDO {
    private String id; // 数据库唯一 id
    private String name;
    private int playerId;//对应的玩家 id
    private Integer age;
    private Double money;
    private Boolean b1;
    private boolean b2;
    private Date registerDate; // 帐号注册时间
}
