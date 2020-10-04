package com.spear.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLTestingController {

	@Autowired
	PostController postService;
	
	@GetMapping
	public String mainPage() {
		return "home";
	}
	
	@GetMapping("bloglist")
	public String blogList() {
		return "blog/blog-list";
	}
	
	  
	@GetMapping("blog/list")
	public String list(@PageableDefault Pageable pageable,
			Model model) { 
		model.addAttribute("postList",
		postService.all(pageable)); 
		return "blog/main_blog"; }
 
	
}
