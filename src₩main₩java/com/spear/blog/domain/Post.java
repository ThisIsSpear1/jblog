package com.spear.blog.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Post {
	
	private static final long serialVersionUID = 1L;
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	
	@NonNull
	@NotBlank(message = "Title is empty")
	private String title;
	
	@NonNull
	@NotBlank(message = "Content is empty")
	private   String content;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final LocalDateTime regDate;

	@NonNull
	private Long userId;
	
	@NonNull
	private Long blogId;
	
}
