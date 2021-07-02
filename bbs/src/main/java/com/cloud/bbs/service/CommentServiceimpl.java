package com.cloud.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.bbs.dao1.CommentDao;
import com.cloud.bbs.dto.CommentDto;

@Service
public class CommentServiceimpl implements CommentService {

   
   @Autowired
   private CommentDao commentDao;
   
   @Override
   public List<CommentDto> commentWrite(CommentDto comment) {
      commentDao.commentWrite(comment);
      return commentDao.getComments(comment.getArticleNum());
      
   }

}