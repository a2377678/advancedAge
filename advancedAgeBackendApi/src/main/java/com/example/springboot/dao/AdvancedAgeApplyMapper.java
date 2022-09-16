package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeApplyMapper {
    int countByExample(AdvancedAgeApplyExample example);

    int deleteByExample(AdvancedAgeApplyExample example);

    int deleteByPrimaryKey(AdvancedAgeApplyKey key);

    int insert(AdvancedAgeApply record);

    int insertSelective(AdvancedAgeApply record);

    List<AdvancedAgeApply> selectByExample(AdvancedAgeApplyExample example);

    AdvancedAgeApply selectByPrimaryKey(AdvancedAgeApplyKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeApply record, @Param("example") AdvancedAgeApplyExample example);

    int updateByExample(@Param("record") AdvancedAgeApply record, @Param("example") AdvancedAgeApplyExample example);

    int updateByPrimaryKeySelective(AdvancedAgeApply record);

    int updateByPrimaryKey(AdvancedAgeApply record);
}