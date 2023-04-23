package com.javabootpro.appModules.testTemplate.entity.domain;

import lombok.Data;

import java.util.List;

@Data
public class FruitDO {
    private String name;
    private List<String> values;
}
