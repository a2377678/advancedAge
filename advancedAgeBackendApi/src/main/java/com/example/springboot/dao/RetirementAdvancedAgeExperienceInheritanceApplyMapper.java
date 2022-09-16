package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RetirementAdvancedAgeExperienceInheritanceApplyMapper {
    int countByExample(RetirementAdvancedAgeExperienceInheritanceApplyExample example);

    int deleteByExample(RetirementAdvancedAgeExperienceInheritanceApplyExample example);

    int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceApplyKey key);

    int insert(RetirementAdvancedAgeExperienceInheritanceApply record);

    int insertSelective(RetirementAdvancedAgeExperienceInheritanceApply record);

    List<RetirementAdvancedAgeExperienceInheritanceApply> selectByExample(RetirementAdvancedAgeExperienceInheritanceApplyExample example);

    RetirementAdvancedAgeExperienceInheritanceApply selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceApplyKey key);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeExperienceInheritanceApply record, @Param("example") RetirementAdvancedAgeExperienceInheritanceApplyExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeExperienceInheritanceApply record, @Param("example") RetirementAdvancedAgeExperienceInheritanceApplyExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceApply record);

    int updateByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceApply record);
}