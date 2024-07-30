package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResultExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResultKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RetirementAdvancedAgeExperienceInheritanceResultMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritanceResultExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritanceResultExample example);

    int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceResultKey key);

    int insert(RetirementAdvancedAgeExperienceInheritanceResult record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritanceResult record);

    List<RetirementAdvancedAgeExperienceInheritanceResult> selectByExample(RetirementAdvancedAgeExperienceInheritanceResultExample example);

    RetirementAdvancedAgeExperienceInheritanceResult selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceResultKey key);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritanceResult record, @Param("example") RetirementAdvancedAgeExperienceInheritanceResultExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritanceResult record, @Param("example") RetirementAdvancedAgeExperienceInheritanceResultExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceResult record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceResult record);
}