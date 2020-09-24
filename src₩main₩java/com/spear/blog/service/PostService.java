package com.spear.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spear.blog.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;
	
	PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	

}
