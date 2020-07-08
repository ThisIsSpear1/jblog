package com.spear.blog.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

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

import com.spear.blog.BlogNotFoundException;
import com.spear.blog.BlogEntityModelAssembler;
import com.spear.blog.domain.Blog;
import com.spear.blog.repository.BlogRepository;

@RestController
public class BlogController {

	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	BlogEntityModelAssembler blogEntityModelAssembler;
	
	BlogController(BlogRepository blogRepository,
			BlogEntityModelAssembler blogEntityModelAssembler){
		this.blogRepository = blogRepository;
		this.blogEntityModelAssembler = blogEntityModelAssembler;
	}
	
	@GetMapping("/blog")
	public CollectionModel<EntityModel<Blog>> all(){
		List<EntityModel<Blog>> blogs = blogRepository.findAll().stream()
				.map(blogEntityModelAssembler::toModel)
				.collect(Collectors.toList());
		return new CollectionModel<>(blogs, linkTo(methodOn(BlogController.class).all()).withSelfRel());
	}
	
	@PostMapping("/blog")
	Blog newBlog(@RequestBody Blog newBlog) {
		return blogRepository.save(newBlog);
	}
	
	@GetMapping("/blog/{id}")
	public EntityModel<Blog> one(@PathVariable Long id) {
		Blog blog = blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException(id));
		return blogEntityModelAssembler.toModel(blog);
	}
	
	@PutMapping("/blog/{id}")
	Blog replaceBlog(@RequestBody Blog newBlog, @PathVariable Long id) {
		return blogRepository.findById(id).map(blog -> 
			{
				blog.setTitle(newBlog.getTitle());
				blog.setLogoFile(newBlog.getLogoFile());
				return blogRepository.save(blog);
			}).orElseGet(() -> {
				newBlog.setId(id);
				return blogRepository.save(newBlog);
			});
	}
	
	@DeleteMapping("/blog/{id}")
	void deleteBlog(@PathVariable Long id) {
		blogRepository.deleteById(id);
	}
}
