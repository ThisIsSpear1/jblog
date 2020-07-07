package com.spear.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spear.blog.domain.Post;
import com.spear.blog.repository.PostRepository;


@RestController
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	PostController(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	
	@DeleteMapping("/{idx}")
	public ResponseEntity<?> deleteBoard(@PathVariable("idx")Long idx){
		System.out.println("DeleteMapping");
		
		postRepository.deleteById(idx);
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
	

	@RequestMapping("/post")
	public Page<Post> all(@PageableDefault Pageable pageable){
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
		return postRepository.findAll(pageable);
	}
}
