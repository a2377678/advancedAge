package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdvancedAgeBaseMapper {
    int countByExample(AdvancedAgeBaseExample example);

    int deleteByExample(AdvancedAgeBaseExample example);

    int deleteByPrimaryKey(String aaid);

    int insert(AdvancedAgeBase record);

    int insertSelective(AdvancedAgeBase record);

    List<AdvancedAgeBase> selectByExample(AdvancedAgeBaseExample example);

    AdvancedAgeBase selectByPrimaryKey(String aaid);

    int updateByExampleSelective(@Param("record") AdvancedAgeBase record, @Param("example") AdvancedAgeBaseExample example);

    int updateByExample(@Param("record") AdvancedAgeBase record, @Param("example") AdvancedAgeBaseExample example);

    int updateByPrimaryKeySelective(AdvancedAgeBase record);

    int updateByPrimaryKey(AdvancedAgeBase record);
}