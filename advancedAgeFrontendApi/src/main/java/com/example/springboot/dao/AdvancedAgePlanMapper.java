package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.AdvancedAgePlanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgePlanMapper {
    int countByExample(AdvancedAgePlanExample example);

    int deleteByExample(AdvancedAgePlanExample example);

    int deleteByPrimaryKey(Integer advancedAgeApplyId);

    int insert(AdvancedAgePlan record);

    int insertSelective(AdvancedAgePlan record);

    List<AdvancedAgePlan> selectByExample(AdvancedAgePlanExample example);

    AdvancedAgePlan selectByPrimaryKey(Integer advancedAgeApplyId);

    int updateByExampleSelective(@Param("record") AdvancedAgePlan record, @Param("example") AdvancedAgePlanExample example);

    int updateByExample(@Param("record") AdvancedAgePlan record, @Param("example") AdvancedAgePlanExample example);

    int updateByPrimaryKeySelective(AdvancedAgePlan record);

    int updateByPrimaryKey(AdvancedAgePlan record);
}