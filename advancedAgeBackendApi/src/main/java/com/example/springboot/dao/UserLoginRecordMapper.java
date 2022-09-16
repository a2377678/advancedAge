package com.example.springboot.dao;

import com.example.springboot.entity.UserLoginRecord;
import com.example.springboot.entity.UserLoginRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginRecordMapper {
    int countByExample(UserLoginRecordExample example);

    int deleteByExample(UserLoginRecordExample example);

    int insert(UserLoginRecord record);

    int insertSelective(UserLoginRecord record);

    List<UserLoginRecord> selectByExample(UserLoginRecordExample example);

    int updateByExampleSelective(@Param("record") UserLoginRecord record, @Param("example") UserLoginRecordExample example);

    int updateByExample(@Param("record") UserLoginRecord record, @Param("example") UserLoginRecordExample example);
}