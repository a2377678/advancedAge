package com.example.springboot.dao;

import com.example.springboot.entity.FunctionList;
import com.example.springboot.entity.FunctionListExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FunctionListMapper {
    int countByExample(FunctionListExample example);

    int deleteByExample(FunctionListExample example);

    int deleteByPrimaryKey(String functionCode);

    int insert(FunctionList record);

    int insertSelective(FunctionList record);

    List<FunctionList> selectByExample(FunctionListExample example);

    FunctionList selectByPrimaryKey(String functionCode);

    int updateByExampleSelective(@Param("record") FunctionList record, @Param("example") FunctionListExample example);

    int updateByExample(@Param("record") FunctionList record, @Param("example") FunctionListExample example);

    int updateByPrimaryKeySelective(FunctionList record);

    int updateByPrimaryKey(FunctionList record);
}