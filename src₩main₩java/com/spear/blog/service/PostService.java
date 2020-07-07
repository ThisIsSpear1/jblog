package com.spear.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import com.spear.blog.domain.Post;
import com.spear.blog.repository.PostRepository;

public class PostService {
	@Autowired
	PostRepository postRepository;
	
	PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	

}
