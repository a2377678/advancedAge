package com.example.springboot.dao;

import com.example.springboot.entity.SiteInspection;
import com.example.springboot.entity.SiteInspectionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SiteInspectionMapper {
    int countByExample(SiteInspectionExample example);

    int deleteByExample(SiteInspectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SiteInspection record);

    int insertSelective(SiteInspection record);

    List<SiteInspection> selectByExample(SiteInspectionExample example);

    SiteInspection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SiteInspection record, @Param("example") SiteInspectionExample example);

    int updateByExample(@Param("record") SiteInspection record, @Param("example") SiteInspectionExample example);

    int updateByPrimaryKeySelective(SiteInspection record);

    int updateByPrimaryKey(SiteInspection record);
}