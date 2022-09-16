package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeEmploymentListMapper {
    int countByExample(AdvancedAgeEmploymentListExample example);

    int deleteByExample(AdvancedAgeEmploymentListExample example);

    int deleteByPrimaryKey(AdvancedAgeEmploymentListKey key);

    int insert(AdvancedAgeEmploymentList record);

    int insertSelective(AdvancedAgeEmploymentList record);

    List<AdvancedAgeEmploymentList> selectByExample(AdvancedAgeEmploymentListExample example);

    AdvancedAgeEmploymentList selectByPrimaryKey(AdvancedAgeEmploymentListKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeEmploymentList record, @Param("example") AdvancedAgeEmploymentListExample example);

    int updateByExample(@Param("record") AdvancedAgeEmploymentList record, @Param("example") AdvancedAgeEmploymentListExample example);

    int updateByPrimaryKeySelective(AdvancedAgeEmploymentList record);

    int updateByPrimaryKey(AdvancedAgeEmploymentList record);
}