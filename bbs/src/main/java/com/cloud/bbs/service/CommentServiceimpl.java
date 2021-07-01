package com.cloud.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.bbs.dao1.CommentDao;

@Service
public class CommentServiceimpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public void test() {
		System.out.println(commentDao.test("human"));
		
	}

}
