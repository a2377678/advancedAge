package com.example.springboot.dao;

import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceScheduleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RretirementAdvancedAgeExperienceInheritanceScheduleMapper {
    int countByExample(RretirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int deleteByExample(RretirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int deleteByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int insert(RretirementAdvancedAgeExperienceInheritanceSchedule record);

    int insertSelective(RretirementAdvancedAgeExperienceInheritanceSchedule record);

    List<RretirementAdvancedAgeExperienceInheritanceSchedule> selectByExample(RretirementAdvancedAgeExperienceInheritanceScheduleExample example);

    RretirementAdvancedAgeExperienceInheritanceSchedule selectByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int updateByExampleSelective(@Param("record") RretirementAdvancedAgeExperienceInheritanceSchedule record, @Param("example") RretirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int updateByExample(@Param("record") RretirementAdvancedAgeExperienceInheritanceSchedule record, @Param("example") RretirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int updateByPrimaryKeySelective(RretirementAdvancedAgeExperienceInheritanceSchedule record);

    int updateByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceSchedule record);
}