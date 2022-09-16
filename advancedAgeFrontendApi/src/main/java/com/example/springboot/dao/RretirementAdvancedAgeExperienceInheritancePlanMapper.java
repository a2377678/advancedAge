package com.example.springboot.dao;

import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritancePlanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RretirementAdvancedAgeExperienceInheritancePlanMapper {
    int countByExample(RretirementAdvancedAgeExperienceInheritancePlanExample example);

    int deleteByExample(RretirementAdvancedAgeExperienceInheritancePlanExample example);

    int deleteByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int insert(RretirementAdvancedAgeExperienceInheritancePlan record);

    int insertSelective(RretirementAdvancedAgeExperienceInheritancePlan record);

    List<RretirementAdvancedAgeExperienceInheritancePlan> selectByExample(RretirementAdvancedAgeExperienceInheritancePlanExample example);

    RretirementAdvancedAgeExperienceInheritancePlan selectByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int updateByExampleSelective(@Param("record") RretirementAdvancedAgeExperienceInheritancePlan record, @Param("example") RretirementAdvancedAgeExperienceInheritancePlanExample example);

    int updateByExample(@Param("record") RretirementAdvancedAgeExperienceInheritancePlan record, @Param("example") RretirementAdvancedAgeExperienceInheritancePlanExample example);

    int updateByPrimaryKeySelective(RretirementAdvancedAgeExperienceInheritancePlan record);

    int updateByPrimaryKey(RretirementAdvancedAgeExperienceInheritancePlan record);
}