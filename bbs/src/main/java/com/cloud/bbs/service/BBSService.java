package com.cloud.bbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cloud.bbs.dto.BBSDto;

public interface BBSService {
	public List<BBSDto> list();
	public String login(String id, String pass, HttpSession session);
	public void write(BBSDto article);
	public BBSDto content(String articleNum);
	public BBSDto updateForm(String articleNum);
	public void update(BBSDto article);
	public void delete(String articleNum);
}
