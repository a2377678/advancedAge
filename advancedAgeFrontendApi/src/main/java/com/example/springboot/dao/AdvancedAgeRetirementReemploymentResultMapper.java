package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResultExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResultKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentResultMapper {
    int countByExample(AdvancedAgeRetirementReemploymentResultExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentResultExample example);

    int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentResultKey key);

    int insert(AdvancedAgeRetirementReemploymentResult record);

    int insertSelective(AdvancedAgeRetirementReemploymentResult record);

    List<AdvancedAgeRetirementReemploymentResult> selectByExample(AdvancedAgeRetirementReemploymentResultExample example);

    AdvancedAgeRetirementReemploymentResult selectByPrimaryKey(AdvancedAgeRetirementReemploymentResultKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentResult record, @Param("example") AdvancedAgeRetirementReemploymentResultExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentResult record, @Param("example") AdvancedAgeRetirementReemploymentResultExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentResult record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentResult record);
}