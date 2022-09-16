package com.example.springboot.dao;

import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceExpenditureExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RretirementAdvancedAgeExperienceInheritanceExpenditureMapper {
    int countByExample(RretirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int deleteByExample(RretirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int deleteByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int insert(RretirementAdvancedAgeExperienceInheritanceExpenditure record);

    int insertSelective(RretirementAdvancedAgeExperienceInheritanceExpenditure record);

    List<RretirementAdvancedAgeExperienceInheritanceExpenditure> selectByExample(RretirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    RretirementAdvancedAgeExperienceInheritanceExpenditure selectByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId);

    int updateByExampleSelective(@Param("record") RretirementAdvancedAgeExperienceInheritanceExpenditure record, @Param("example") RretirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int updateByExample(@Param("record") RretirementAdvancedAgeExperienceInheritanceExpenditure record, @Param("example") RretirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int updateByPrimaryKeySelective(RretirementAdvancedAgeExperienceInheritanceExpenditure record);

    int updateByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceExpenditure record);
}