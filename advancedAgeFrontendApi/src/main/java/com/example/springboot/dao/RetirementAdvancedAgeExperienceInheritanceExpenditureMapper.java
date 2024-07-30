package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RetirementAdvancedAgeExperienceInheritanceExpenditureMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceExpenditureKey key);

    int insert(RetirementAdvancedAgeExperienceInheritanceExpenditure record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritanceExpenditure record);

    List<RetirementAdvancedAgeExperienceInheritanceExpenditure> selectByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    RetirementAdvancedAgeExperienceInheritanceExpenditure selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceExpenditureKey key);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritanceExpenditure record, @Param("example") RetirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritanceExpenditure record, @Param("example") RetirementAdvancedAgeExperienceInheritanceExpenditureExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceExpenditure record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceExpenditure record);
}