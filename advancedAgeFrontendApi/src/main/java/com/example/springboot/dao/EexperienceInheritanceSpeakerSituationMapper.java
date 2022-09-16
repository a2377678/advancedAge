package com.example.springboot.dao;

import com.example.springboot.entity.EexperienceInheritanceSpeakerSituation;
import com.example.springboot.entity.EexperienceInheritanceSpeakerSituationExample;
import com.example.springboot.entity.EexperienceInheritanceSpeakerSituationKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EexperienceInheritanceSpeakerSituationMapper {
    int countByExample(EexperienceInheritanceSpeakerSituationExample example);

    int deleteByExample(EexperienceInheritanceSpeakerSituationExample example);

    int deleteByPrimaryKey(EexperienceInheritanceSpeakerSituationKey key);

    int insert(EexperienceInheritanceSpeakerSituation record);

    int insertSelective(EexperienceInheritanceSpeakerSituation record);

    List<EexperienceInheritanceSpeakerSituation> selectByExample(EexperienceInheritanceSpeakerSituationExample example);

    EexperienceInheritanceSpeakerSituation selectByPrimaryKey(EexperienceInheritanceSpeakerSituationKey key);

    int updateByExampleSelective(@Param("record") EexperienceInheritanceSpeakerSituation record, @Param("example") EexperienceInheritanceSpeakerSituationExample example);

    int updateByExample(@Param("record") EexperienceInheritanceSpeakerSituation record, @Param("example") EexperienceInheritanceSpeakerSituationExample example);

    int updateByPrimaryKeySelective(EexperienceInheritanceSpeakerSituation record);

    int updateByPrimaryKey(EexperienceInheritanceSpeakerSituation record);
}