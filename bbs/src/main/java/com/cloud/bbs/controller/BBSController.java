package com.cloud.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.bbs.dto.BBSDto;
import com.cloud.bbs.service.BBSService;

@Controller
public class BBSController {
	
	@Autowired
	private BBSService bbsService;
	
	@RequestMapping("/list.bbs")
	public String test(Model model) {
		model.addAttribute("articleList", bbsService.list());
		return "list";
	}
	
//	@RequestMapping(value="/write.bbs", method = RequestMethod.GET)
	@GetMapping("/write.bbs")
	public String writeForm(HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "login";
		} 
		return "writeForm";
	}
	
	@PostMapping("/write.bbs")
	public String write(BBSDto article, HttpSession session) {
//	public String write(@RequestParam("title") String title, @RequestParam("content") String content) {
//	public String write(@RequestParam String title, @RequestParam String content) {
		bbsService.write(article);
		return "redirect:/list.bbs";
	}

	
	@PostMapping("/login.bbs")
	public String login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session) {
		return bbsService.login(id,pass,session);
	}
	
	@GetMapping("/content.bbs")
	public String content(@RequestParam("articleNum") String articleNum, Model model) {
		model.addAttribute("article", bbsService.content(articleNum));
		return "content";
	}
	
	@GetMapping("/update.bbs")
	public String updateForm(@RequestParam("articleNum") String articleNum, Model model) {
		model.addAttribute("article", bbsService.updateForm(articleNum));
		return "updateForm";
	}
	
	@PostMapping("/update.bbs")
	public String update(BBSDto article) {
		bbsService.update(article);
		return "redirect:/content.bbs?articleNum="+article.getArticleNum();
	}
	
	@GetMapping("/delete.bbs")
	public String delete(@RequestParam("articleNum") String articleNum) {
		bbsService.delete(articleNum);
		return "redirect:/list.bbs";
	}
	
}
