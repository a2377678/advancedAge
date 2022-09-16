package com.example.springboot.dao;

import com.example.springboot.entity.FunctionPermission;
import com.example.springboot.entity.FunctionPermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FunctionPermissionMapper {
    int countByExample(FunctionPermissionExample example);

    int deleteByExample(FunctionPermissionExample example);

    int deleteByPrimaryKey(Integer jurisdiction);

    int insert(FunctionPermission record);

    int insertSelective(FunctionPermission record);

    List<FunctionPermission> selectByExample(FunctionPermissionExample example);

    FunctionPermission selectByPrimaryKey(Integer jurisdiction);

    int updateByExampleSelective(@Param("record") FunctionPermission record, @Param("example") FunctionPermissionExample example);

    int updateByExample(@Param("record") FunctionPermission record, @Param("example") FunctionPermissionExample example);

    int updateByPrimaryKeySelective(FunctionPermission record);

    int updateByPrimaryKey(FunctionPermission record);
}