package com.spear.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spear.blog.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
