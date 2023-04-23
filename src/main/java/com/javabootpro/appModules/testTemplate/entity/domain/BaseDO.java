package com.javabootpro.appModules.testTemplate.entity.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BaseDO implements Serializable {

    private String id;
    private Long simpleId;
    private String name;
    private Integer count;
    private Enum sex;
    private BigDecimal price;
    private Float fCount;
    private Date startDate;
    private Date endDate;
    private String info;

}
