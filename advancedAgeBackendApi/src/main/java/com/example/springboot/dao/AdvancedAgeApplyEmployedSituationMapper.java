package com.example.springboot.dao;

import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationExample;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdvancedAgeApplyEmployedSituationMapper {
    int countByExample(AdvancedAgeApplyEmployedSituationExample example);

    int deleteByExample(AdvancedAgeApplyEmployedSituationExample example);

    int deleteByPrimaryKey(AdvancedAgeApplyEmployedSituationKey key);

    int insert(AdvancedAgeApplyEmployedSituation record);

    int insertSelective(AdvancedAgeApplyEmployedSituation record);

    List<AdvancedAgeApplyEmployedSituation> selectByExample(AdvancedAgeApplyEmployedSituationExample example);

    AdvancedAgeApplyEmployedSituation selectByPrimaryKey(AdvancedAgeApplyEmployedSituationKey key);

    int updateByExampleSelective(@Param("record") AdvancedAgeApplyEmployedSituation record, @Param("example") AdvancedAgeApplyEmployedSituationExample example);

    int updateByExample(@Param("record") AdvancedAgeApplyEmployedSituation record, @Param("example") AdvancedAgeApplyEmployedSituationExample example);

    int updateByPrimaryKeySelective(AdvancedAgeApplyEmployedSituation record);

    int updateByPrimaryKey(AdvancedAgeApplyEmployedSituation record);
}