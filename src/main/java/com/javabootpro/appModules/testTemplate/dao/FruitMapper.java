package com.javabootpro.appModules.testTemplate.dao;


import com.javabootpro.appModules.testTemplate.entity.domain.FruitDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FruitMapper {
    FruitDO getById(String id);
}
