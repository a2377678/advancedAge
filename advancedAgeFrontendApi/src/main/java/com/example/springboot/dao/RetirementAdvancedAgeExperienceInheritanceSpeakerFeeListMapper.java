package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListExample example);

    int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListKey key);

    int insert(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList record);

    List<RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList> selectByExample(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListExample example);

    RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListKey key);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList record, @Param("example") RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList record, @Param("example") RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceSpeakerFeeList record);
}