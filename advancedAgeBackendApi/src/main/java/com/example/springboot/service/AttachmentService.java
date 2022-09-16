package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AttachmentMapper;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.AttachmentExample;
import com.example.springboot.entity.AttachmentKey;

@Service
public class AttachmentService{
	
	@Autowired
	AttachmentMapper attachmentMapper;
	
	public int insertSelective(Attachment record) {
		return attachmentMapper.insertSelective(record);
	}
	
	public Attachment selectByPrimaryKey(AttachmentKey key) {
		return attachmentMapper.selectByPrimaryKey(key);
	}
	
	public List<Attachment> selectByExample(AttachmentExample example){
		return attachmentMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(Attachment record) {
		return attachmentMapper.updateByPrimaryKeySelective(record);
	}
}