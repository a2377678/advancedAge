package com.example.springboot.dao;

import com.example.springboot.entity.MailRecord;
import com.example.springboot.entity.MailRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MailRecordMapper {
    int countByExample(MailRecordExample example);

    int deleteByExample(MailRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailRecord record);

    int insertSelective(MailRecord record);

    List<MailRecord> selectByExample(MailRecordExample example);

    MailRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailRecord record, @Param("example") MailRecordExample example);

    int updateByExample(@Param("record") MailRecord record, @Param("example") MailRecordExample example);

    int updateByPrimaryKeySelective(MailRecord record);

    int updateByPrimaryKey(MailRecord record);
}