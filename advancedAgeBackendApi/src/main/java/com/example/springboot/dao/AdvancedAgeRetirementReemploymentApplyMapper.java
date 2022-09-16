package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApplyExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApplyKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentApplyMapper {
    int countByExample(AdvancedAgeRetirementReemploymentApplyExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentApplyExample example);

    int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentApplyKey key);

    int insert(AdvancedAgeRetirementReemploymentApply record);

    int insertSelective(AdvancedAgeRetirementReemploymentApply record);

    List<AdvancedAgeRetirementReemploymentApply> selectByExample(AdvancedAgeRetirementReemploymentApplyExample example);

    AdvancedAgeRetirementReemploymentApply selectByPrimaryKey(AdvancedAgeRetirementReemploymentApplyKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentApply record, @Param("example") AdvancedAgeRetirementReemploymentApplyExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentApply record, @Param("example") AdvancedAgeRetirementReemploymentApplyExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentApply record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentApply record);
}