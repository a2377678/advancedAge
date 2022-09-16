package com.example.springboot.dao;

import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceReceipt;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceReceiptExample;
import com.example.springboot.entity.RretirementAdvancedAgeExperienceInheritanceReceiptKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RretirementAdvancedAgeExperienceInheritanceReceiptMapper {
    int countByExample(RretirementAdvancedAgeExperienceInheritanceReceiptExample example);

    int deleteByExample(RretirementAdvancedAgeExperienceInheritanceReceiptExample example);

    int deleteByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceReceiptKey key);

    int insert(RretirementAdvancedAgeExperienceInheritanceReceipt record);

    int insertSelective(RretirementAdvancedAgeExperienceInheritanceReceipt record);

    List<RretirementAdvancedAgeExperienceInheritanceReceipt> selectByExample(RretirementAdvancedAgeExperienceInheritanceReceiptExample example);

    RretirementAdvancedAgeExperienceInheritanceReceipt selectByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceReceiptKey key);

    int updateByExampleSelective(@Param("record") RretirementAdvancedAgeExperienceInheritanceReceipt record, @Param("example") RretirementAdvancedAgeExperienceInheritanceReceiptExample example);

    int updateByExample(@Param("record") RretirementAdvancedAgeExperienceInheritanceReceipt record, @Param("example") RretirementAdvancedAgeExperienceInheritanceReceiptExample example);

    int updateByPrimaryKeySelective(RretirementAdvancedAgeExperienceInheritanceReceipt record);

    int updateByPrimaryKey(RretirementAdvancedAgeExperienceInheritanceReceipt record);
}