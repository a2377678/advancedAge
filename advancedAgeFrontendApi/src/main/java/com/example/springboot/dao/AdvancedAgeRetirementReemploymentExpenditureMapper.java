package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditureExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentExpenditureMapper {
    int countByExample(AdvancedAgeRetirementReemploymentExpenditureExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentExpenditureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvancedAgeRetirementReemploymentExpenditure record);

    int insertSelective(AdvancedAgeRetirementReemploymentExpenditure record);

    List<AdvancedAgeRetirementReemploymentExpenditure> selectByExample(AdvancedAgeRetirementReemploymentExpenditureExample example);

    AdvancedAgeRetirementReemploymentExpenditure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentExpenditure record, @Param("example") AdvancedAgeRetirementReemploymentExpenditureExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentExpenditure record, @Param("example") AdvancedAgeRetirementReemploymentExpenditureExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentExpenditure record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentExpenditure record);
}