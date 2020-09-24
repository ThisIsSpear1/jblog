package com.spear.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spear.blog.domain.Blog;
import com.spear.blog.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@GetMapping("/blog")
	public CollectionModel<EntityModel<Blog>> all(){
		
		return blogService.all();
	}
	
	@PostMapping("/blog")
	Blog newBlog(@RequestBody Blog newBlog) {
		return blogService.newBlog(newBlog);
	}
	
	@GetMapping("/blog/{id}")
	public EntityModel<Blog> one(@PathVariable Long id) {
		return blogService.one(id);
	}
	
	@PutMapping("/blog/{id}")
	Blog replaceBlog(@RequestBody Blog newBlog, @PathVariable Long id) {
		return blogService.replaceBlog(newBlog, id);
	}
	
	@DeleteMapping("/blog/{id}")
	void deleteBlog(@PathVariable Long id) {
		blogService.deleteBlog(id);
	}
}
