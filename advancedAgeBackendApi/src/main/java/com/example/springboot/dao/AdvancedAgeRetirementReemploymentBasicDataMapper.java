package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeRetirementReemploymentBasicDataMapper {
    int countByExample(AdvancedAgeRetirementReemploymentBasicDataExample example);

    int deleteByExample(AdvancedAgeRetirementReemploymentBasicDataExample example);

    int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentBasicDataKey key);

    int insert(AdvancedAgeRetirementReemploymentBasicData record);

    int insertSelective(AdvancedAgeRetirementReemploymentBasicData record);

    List<AdvancedAgeRetirementReemploymentBasicData> selectByExample(AdvancedAgeRetirementReemploymentBasicDataExample example);

    AdvancedAgeRetirementReemploymentBasicData selectByPrimaryKey(AdvancedAgeRetirementReemploymentBasicDataKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeRetirementReemploymentBasicData record, @Param("example") AdvancedAgeRetirementReemploymentBasicDataExample example);

    int updateByExample(@Param("record") AdvancedAgeRetirementReemploymentBasicData record, @Param("example") AdvancedAgeRetirementReemploymentBasicDataExample example);

    int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentBasicData record);

    int updateByPrimaryKey(AdvancedAgeRetirementReemploymentBasicData record);
}