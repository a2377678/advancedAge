package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentPlanMapper {
    int countByExample(AdvancedAgeRetirementReemploymentPlanExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentPlanExample example);

    int deleteByPrimaryKey(Integer advancedAgeRetirementReemploymentApplyId);

    int insert(AdvancedAgeRetirementReemploymentPlan record);

    int insertSelective(AdvancedAgeRetirementReemploymentPlan record);

    List<AdvancedAgeRetirementReemploymentPlan> selectByExample(AdvancedAgeRetirementReemploymentPlanExample example);

    AdvancedAgeRetirementReemploymentPlan selectByPrimaryKey(Integer advancedAgeRetirementReemploymentApplyId);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentPlan record, @Param("example") AdvancedAgeRetirementReemploymentPlanExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentPlan record, @Param("example") AdvancedAgeRetirementReemploymentPlanExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentPlan record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentPlan record);
}