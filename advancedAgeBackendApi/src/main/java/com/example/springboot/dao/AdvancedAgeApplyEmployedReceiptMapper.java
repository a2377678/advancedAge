package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeApplyEmployedReceipt;
import com.example.springboot.entity.AdvancedAgeApplyEmployedReceiptExample;
import com.example.springboot.entity.AdvancedAgeApplyEmployedReceiptKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdvancedAgeApplyEmployedReceiptMapper {
    int countByExample(AdvancedAgeApplyEmployedReceiptExample example);

    int deleteByExample(AdvancedAgeApplyEmployedReceiptExample example);

    int deleteByPrimaryKey(AdvancedAgeApplyEmployedReceiptKey key);

    int insert(AdvancedAgeApplyEmployedReceipt record);

    int insertSelective(AdvancedAgeApplyEmployedReceipt record);

    List<AdvancedAgeApplyEmployedReceipt> selectByExample(AdvancedAgeApplyEmployedReceiptExample example);

    AdvancedAgeApplyEmployedReceipt selectByPrimaryKey(AdvancedAgeApplyEmployedReceiptKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeApplyEmployedReceipt record, @Param("example") AdvancedAgeApplyEmployedReceiptExample example);

    int updateByExample(@Param("record") AdvancedAgeApplyEmployedReceipt record, @Param("example") AdvancedAgeApplyEmployedReceiptExample example);

    int updateByPrimaryKeySelective(AdvancedAgeApplyEmployedReceipt record);

    int updateByPrimaryKey(AdvancedAgeApplyEmployedReceipt record);
}