package com.javabootpro.appModules.testTemplate.entity.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 打点分组查询返回实体
// 返回必须有构造器
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClickSimpleQuery {

    private String id; //
    private String gameName;
    private String clickName; // 打点名称
    private Long queryCount; // 数量
    private Integer clickType;// 类型
    private String  runPlatform; // 平台
    private Date queryDate; // 查询日期



}
