package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureDetails;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample example);

    int deleteByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceResultId);

    int insert(RetirementAdvancedAgeExperienceInheritanceExpenditureDetails record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritanceExpenditureDetails record);

    List<RetirementAdvancedAgeExperienceInheritanceExpenditureDetails> selectByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample example);

    RetirementAdvancedAgeExperienceInheritanceExpenditureDetails selectByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceResultId);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritanceExpenditureDetails record, @Param("example") RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritanceExpenditureDetails record, @Param("example") RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceExpenditureDetails record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceExpenditureDetails record);
}