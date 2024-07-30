package com.example.springboot.dao;

import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentExample;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RetirementAdvancedAgeParticipateStudentMapper {
    int countByExample(RetirementAdvancedAgeParticipateStudentExample example);

    int deleteByExample(RetirementAdvancedAgeParticipateStudentExample example);

    int deleteByPrimaryKey(RetirementAdvancedAgeParticipateStudentKey key);

    int insert(RetirementAdvancedAgeParticipateStudent record);

    int insertSelective(RetirementAdvancedAgeParticipateStudent record);

    List<RetirementAdvancedAgeParticipateStudent> selectByExample(RetirementAdvancedAgeParticipateStudentExample example);

    RetirementAdvancedAgeParticipateStudent selectByPrimaryKey(RetirementAdvancedAgeParticipateStudentKey key);

    int updateByExampleSelective(@Param("record") RetirementAdvancedAgeParticipateStudent record, @Param("example") RetirementAdvancedAgeParticipateStudentExample example);

    int updateByExample(@Param("record") RetirementAdvancedAgeParticipateStudent record, @Param("example") RetirementAdvancedAgeParticipateStudentExample example);

    int updateByPrimaryKeySelective(RetirementAdvancedAgeParticipateStudent record);

    int updateByPrimaryKey(RetirementAdvancedAgeParticipateStudent record);
}