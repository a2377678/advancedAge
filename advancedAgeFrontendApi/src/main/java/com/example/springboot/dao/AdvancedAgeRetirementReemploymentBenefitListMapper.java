package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentBenefitListMapper {
    int countByExample(AdvancedAgeRetirementReemploymentBenefitListExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentBenefitListExample example);

    int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentBenefitListKey key);

    int insert(AdvancedAgeRetirementReemploymentBenefitList record);

    int insertSelective(AdvancedAgeRetirementReemploymentBenefitList record);

    List<AdvancedAgeRetirementReemploymentBenefitList> selectByExample(AdvancedAgeRetirementReemploymentBenefitListExample example);

    AdvancedAgeRetirementReemploymentBenefitList selectByPrimaryKey(AdvancedAgeRetirementReemploymentBenefitListKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentBenefitList record, @Param("example") AdvancedAgeRetirementReemploymentBenefitListExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentBenefitList record, @Param("example") AdvancedAgeRetirementReemploymentBenefitListExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentBenefitList record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentBenefitList record);
}