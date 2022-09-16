package com.example.springboot.dao;

import com.example.springboot.entity.EexperienceInheritanceSpeakerList;
import com.example.springboot.entity.EexperienceInheritanceSpeakerListExample;
import com.example.springboot.entity.EexperienceInheritanceSpeakerListKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EexperienceInheritanceSpeakerListMapper {
    int countByExample(EexperienceInheritanceSpeakerListExample example);

    int deleteByExample(EexperienceInheritanceSpeakerListExample example);

    int deleteByPrimaryKey(EexperienceInheritanceSpeakerListKey key);

    int insert(EexperienceInheritanceSpeakerList record);

    int insertSelective(EexperienceInheritanceSpeakerList record);

    List<EexperienceInheritanceSpeakerList> selectByExample(EexperienceInheritanceSpeakerListExample example);

    EexperienceInheritanceSpeakerList selectByPrimaryKey(EexperienceInheritanceSpeakerListKey key);

    int updateByExampleSelective(@Param("record") EexperienceInheritanceSpeakerList record, @Param("example") EexperienceInheritanceSpeakerListExample example);

    int updateByExample(@Param("record") EexperienceInheritanceSpeakerList record, @Param("example") EexperienceInheritanceSpeakerListExample example);

    int updateByPrimaryKeySelective(EexperienceInheritanceSpeakerList record);

    int updateByPrimaryKey(EexperienceInheritanceSpeakerList record);
}