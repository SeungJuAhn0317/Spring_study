package com.cloud.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {
	
	
	@GetMapping("/test.comment")
	public void test() {
		System.out.println("dkdkdk");
	}

}
