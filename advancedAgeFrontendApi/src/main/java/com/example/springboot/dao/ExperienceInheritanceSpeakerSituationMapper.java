package com.example.springboot.dao;

import com.example.springboot.entity.ExperienceInheritanceSpeakerSituation;
import com.example.springboot.entity.ExperienceInheritanceSpeakerSituationExample;
import com.example.springboot.entity.ExperienceInheritanceSpeakerSituationKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ExperienceInheritanceSpeakerSituationMapper {
    int countByExample(ExperienceInheritanceSpeakerSituationExample example);

    int deleteByExample(ExperienceInheritanceSpeakerSituationExample example);

    int deleteByPrimaryKey(ExperienceInheritanceSpeakerSituationKey key);

    int insert(ExperienceInheritanceSpeakerSituation record);

    int insertSelective(ExperienceInheritanceSpeakerSituation record);

    List<ExperienceInheritanceSpeakerSituation> selectByExample(ExperienceInheritanceSpeakerSituationExample example);

    ExperienceInheritanceSpeakerSituation selectByPrimaryKey(ExperienceInheritanceSpeakerSituationKey key);

    int updateByExampleSelective(@Param("record") ExperienceInheritanceSpeakerSituation record, @Param("example") ExperienceInheritanceSpeakerSituationExample example);

    int updateByExample(@Param("record") ExperienceInheritanceSpeakerSituation record, @Param("example") ExperienceInheritanceSpeakerSituationExample example);

    int updateByPrimaryKeySelective(ExperienceInheritanceSpeakerSituation record);

    int updateByPrimaryKey(ExperienceInheritanceSpeakerSituation record);
}