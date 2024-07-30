package com.example.springboot.dao;

import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListExample;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ExperienceInheritanceSpeakerListMapper {
    int countByExample(ExperienceInheritanceSpeakerListExample example);

    int deleteByExample(ExperienceInheritanceSpeakerListExample example);

    int deleteByPrimaryKey(ExperienceInheritanceSpeakerListKey key);

    int insert(ExperienceInheritanceSpeakerList record);

    int insertSelective(ExperienceInheritanceSpeakerList record);

    List<ExperienceInheritanceSpeakerList> selectByExample(ExperienceInheritanceSpeakerListExample example);

    ExperienceInheritanceSpeakerList selectByPrimaryKey(ExperienceInheritanceSpeakerListKey key);

    int updateByExampleSelective(@Param("record") ExperienceInheritanceSpeakerList record, @Param("example") ExperienceInheritanceSpeakerListExample example);

    int updateByExample(@Param("record") ExperienceInheritanceSpeakerList record, @Param("example") ExperienceInheritanceSpeakerListExample example);

    int updateByPrimaryKeySelective(ExperienceInheritanceSpeakerList record);

    int updateByPrimaryKey(ExperienceInheritanceSpeakerList record);
}