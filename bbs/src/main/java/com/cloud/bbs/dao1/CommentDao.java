package com.cloud.bbs.dao1;

import java.util.List;

import com.cloud.bbs.dto.CommentDto;

public interface CommentDao {
	public void commentWrite(CommentDto comment);
	public List<CommentDto> getComments(int articleNum);
}
