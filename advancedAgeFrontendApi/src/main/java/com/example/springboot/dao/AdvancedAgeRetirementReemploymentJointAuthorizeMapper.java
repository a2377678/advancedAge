package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorize;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorizeExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorizeKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentJointAuthorizeMapper {
    int countByExample(AdvancedAgeRetirementReemploymentJointAuthorizeExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentJointAuthorizeExample example);

    int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentJointAuthorizeKey key);

    int insert(AdvancedAgeRetirementReemploymentJointAuthorize record);

    int insertSelective(AdvancedAgeRetirementReemploymentJointAuthorize record);

    List<AdvancedAgeRetirementReemploymentJointAuthorize> selectByExample(AdvancedAgeRetirementReemploymentJointAuthorizeExample example);

    AdvancedAgeRetirementReemploymentJointAuthorize selectByPrimaryKey(AdvancedAgeRetirementReemploymentJointAuthorizeKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentJointAuthorize record, @Param("example") AdvancedAgeRetirementReemploymentJointAuthorizeExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentJointAuthorize record, @Param("example") AdvancedAgeRetirementReemploymentJointAuthorizeExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentJointAuthorize record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentJointAuthorize record);
}