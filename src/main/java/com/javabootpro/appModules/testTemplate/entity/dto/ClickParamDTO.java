package com.javabootpro.appModules.testTemplate.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 数据查询实体

// 返回必须有构造器
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClickParamDTO {
    // 包含数据库 所有对应的 字段
    private String id;
    private String gameName;
    private Date clickDate;
    private String clickName; // 打点名称
    private Integer clickType; // 打点类型
    private String  runPlatform; // 游戏运行平台  Platform

    // 查询日期
    private Date queryStartDate ;
    private Date queryEndDate ;

    // count(*) 最大最小数量
    private Integer minCount;
    private Integer maxCount;

    private Long queryCount;


}
