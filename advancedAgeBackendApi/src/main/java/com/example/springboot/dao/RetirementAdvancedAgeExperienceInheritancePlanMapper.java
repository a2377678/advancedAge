package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RetirementAdvancedAgeExperienceInheritancePlanMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritancePlanExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritancePlanExample example);

    int deleteByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int insert(RetirementAdvancedAgeExperienceInheritancePlan record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritancePlan record);

    List<RetirementAdvancedAgeExperienceInheritancePlan> selectByExample(RetirementAdvancedAgeExperienceInheritancePlanExample example);

    RetirementAdvancedAgeExperienceInheritancePlan selectByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritancePlan record, @Param("example") RetirementAdvancedAgeExperienceInheritancePlanExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritancePlan record, @Param("example") RetirementAdvancedAgeExperienceInheritancePlanExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritancePlan record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritancePlan record);
}