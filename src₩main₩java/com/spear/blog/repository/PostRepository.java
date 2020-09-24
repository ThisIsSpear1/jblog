package com.spear.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.spear.blog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
