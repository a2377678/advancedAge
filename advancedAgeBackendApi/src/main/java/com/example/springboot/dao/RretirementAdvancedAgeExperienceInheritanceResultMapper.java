package com.example.springboot.dao;

import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceResultExample;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceResultKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RretirementAdvancedAgeExperienceInheritanceResultMapper {
    int countByExample(RretirementAdvancedAgeExperienceInheritanceResultExample example);

    int deleteByExample(RretirementAdvancedAgeExperienceInheritanceResultExample example);

    int deleteByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceResultKey key);

    int insert(RretirementAdvancedAgeExperienceInheritanceResult record);

    int insertSelective(RretirementAdvancedAgeExperienceInheritanceResult record);

    List<RretirementAdvancedAgeExperienceInheritanceResult> selectByExample(RretirementAdvancedAgeExperienceInheritanceResultExample example);

    RretirementAdvancedAgeExperienceInheritanceResult selectByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceResultKey key);

    int updateByExampleSelective(@Param("record") RretirementAdvancedAgeExperienceInheritanceResult record, @Param("example") RretirementAdvancedAgeExperienceInheritanceResultExample example);

    int updateByExample(@Param("record") RretirementAdvancedAgeExperienceInheritanceResult record, @Param("example") RretirementAdvancedAgeExperienceInheritanceResultExample example);

    int updateByPrimaryKeySelective(RretirementAdvancedAgeExperienceInheritanceResult record);

    int updateByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceResult record);
}