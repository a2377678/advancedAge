package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RetirementAdvancedAgeExperienceInheritanceScheduleMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceScheduleKey key);

    int insert(RetirementAdvancedAgeExperienceInheritanceSchedule record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritanceSchedule record);

    List<RetirementAdvancedAgeExperienceInheritanceSchedule> selectByExample(RetirementAdvancedAgeExperienceInheritanceScheduleExample example);

    RetirementAdvancedAgeExperienceInheritanceSchedule selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceScheduleKey key);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritanceSchedule record, @Param("example") RetirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritanceSchedule record, @Param("example") RetirementAdvancedAgeExperienceInheritanceScheduleExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceSchedule record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceSchedule record);
}