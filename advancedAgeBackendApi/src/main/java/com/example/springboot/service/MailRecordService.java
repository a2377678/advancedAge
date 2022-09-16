package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.MailRecordMapper;
import com.example.springboot.entity.MailRecord;
import com.example.springboot.entity.MailRecordExample;

@Service
public class MailRecordService{
	
	@Autowired
	MailRecordMapper mailRecordMapper;
	
	public int insertSelective(MailRecord record) {
		return mailRecordMapper.insertSelective(record);
	}
	
	public List<MailRecord> selectByExample(MailRecordExample example){
		return mailRecordMapper.selectByExample(example);
	}
	
	public MailRecord selectByPrimaryKey(Integer id) {
		return mailRecordMapper.selectByPrimaryKey(id);
	}
}