package com.spear.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.spear.blog.domain.Post;

@CrossOrigin
public interface PostRepository extends JpaRepository<Post, Long> {
}
