package com.spear.blog.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spear.blog.BlogEntityModelAssembler;
import com.spear.blog.BlogNotFoundException;
import com.spear.blog.controller.BlogController;
import com.spear.blog.domain.Blog;
import com.spear.blog.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	BlogEntityModelAssembler blogEntityModelAssembler;
	
	BlogService(BlogRepository blogRepository,
			BlogEntityModelAssembler blogEntityModelAssembler){
		this.blogRepository = blogRepository;
		this.blogEntityModelAssembler = blogEntityModelAssembler;
	}
	
	public CollectionModel<EntityModel<Blog>> all(){
		List<EntityModel<Blog>> blogs = blogRepository.findAll().stream()
				.map(blogEntityModelAssembler::toModel)
				.collect(Collectors.toList());
		return new CollectionModel<>(blogs, linkTo(methodOn(BlogController.class).all()).withSelfRel());
	}
	
	public Blog newBlog(@RequestBody Blog newBlog) {
		return blogRepository.save(newBlog);
	}
	
	public EntityModel<Blog> one(Long id) {
		Blog blog = blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException(id));
		return blogEntityModelAssembler.toModel(blog);
	}
	
	public Blog replaceBlog(@RequestBody Blog newBlog, Long id) {
		return blogRepository.findById(id).map(blog -> 
			{
				blog.setTitle(newBlog.getTitle());
				blog.setLogoFile(newBlog.getLogoFile());
				return blogRepository.save(blog);
			}).orElseGet(() -> {
				newBlog.setBlogId(id);
				return blogRepository.save(newBlog);
			});
	}
	
	public void deleteBlog(Long id) {
		blogRepository.deleteById(id);
	}
}
