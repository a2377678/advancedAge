package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeEmploymentListReceiptMapper {
    int countByExample(AdvancedAgeEmploymentListReceiptExample example);

    int deleteByExample(AdvancedAgeEmploymentListReceiptExample example);

    int deleteByPrimaryKey(AdvancedAgeEmploymentListReceiptKey key);

    int insert(AdvancedAgeEmploymentListReceipt record);

    int insertSelective(AdvancedAgeEmploymentListReceipt record);

    List<AdvancedAgeEmploymentListReceipt> selectByExample(AdvancedAgeEmploymentListReceiptExample example);

    AdvancedAgeEmploymentListReceipt selectByPrimaryKey(AdvancedAgeEmploymentListReceiptKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeEmploymentListReceipt record, @Param("example") AdvancedAgeEmploymentListReceiptExample example);

    int updateByExample(@Param("record") AdvancedAgeEmploymentListReceipt record, @Param("example") AdvancedAgeEmploymentListReceiptExample example);

    int updateByPrimaryKeySelective(AdvancedAgeEmploymentListReceipt record);

    int updateByPrimaryKey(AdvancedAgeEmploymentListReceipt record);
}