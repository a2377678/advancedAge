package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentReceipt;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentReceiptExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentReceiptKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentReceiptMapper {
    int countByExample(AdvancedAgeRetirementReemploymentReceiptExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentReceiptExample example);

    int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentReceiptKey key);

    int insert(AdvancedAgeRetirementReemploymentReceipt record);

    int insertSelective(AdvancedAgeRetirementReemploymentReceipt record);

    List<AdvancedAgeRetirementReemploymentReceipt> selectByExample(AdvancedAgeRetirementReemploymentReceiptExample example);

    AdvancedAgeRetirementReemploymentReceipt selectByPrimaryKey(AdvancedAgeRetirementReemploymentReceiptKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentReceipt record, @Param("example") AdvancedAgeRetirementReemploymentReceiptExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentReceipt record, @Param("example") AdvancedAgeRetirementReemploymentReceiptExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentReceipt record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentReceipt record);
}