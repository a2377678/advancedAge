package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditureDetails;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditureDetailsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentExpenditureDetailsMapper {
    int countByExample(AdvancedAgeRetirementReemploymentExpenditureDetailsExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentExpenditureDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvancedAgeRetirementReemploymentExpenditureDetails record);

    int insertSelective(AdvancedAgeRetirementReemploymentExpenditureDetails record);

    List<AdvancedAgeRetirementReemploymentExpenditureDetails> selectByExample(AdvancedAgeRetirementReemploymentExpenditureDetailsExample example);

    AdvancedAgeRetirementReemploymentExpenditureDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentExpenditureDetails record, @Param("example") AdvancedAgeRetirementReemploymentExpenditureDetailsExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentExpenditureDetails record, @Param("example") AdvancedAgeRetirementReemploymentExpenditureDetailsExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentExpenditureDetails record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentExpenditureDetails record);
}