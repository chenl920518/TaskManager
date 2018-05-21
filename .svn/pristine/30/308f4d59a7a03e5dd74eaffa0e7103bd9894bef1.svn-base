package com.cn.hnust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.CommentMapper;
import com.cn.hnust.pojo.Comment;
import com.cn.hnust.service.IProjectCommentService;

@Service
public class ProjectCommentServiceImpl implements IProjectCommentService {

	@Autowired
	private  CommentMapper commentMapper;

	@Override
	public void addProjetcComment(Comment comment) {
		commentMapper.insertSelective(comment);
	}

	@Override
	public List<Comment> selectProjectComment(String projectNo) {
		return commentMapper.selectProjectComment(projectNo);
	}
	
}
