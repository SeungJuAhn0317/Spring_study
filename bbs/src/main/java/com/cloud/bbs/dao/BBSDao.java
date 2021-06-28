package com.cloud.bbs.dao;

import com.cloud.bbs.dto.BBSDto;
import java.util.List;

public interface BBSDao {
	public List<BBSDto> list();
	public String login(String id);
	public void write(BBSDto article);
	public BBSDto content(String articleNum);
	public BBSDto updateForm(String articleNum);
	public void update(BBSDto article);
	public void delete(String articleNum);
}
