package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    List<Comment> selectProjectComment(String projectNo);
}