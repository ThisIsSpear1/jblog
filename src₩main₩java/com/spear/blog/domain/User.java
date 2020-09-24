package com.spear.blog.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.spear.blog.domain.enums.Status;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class User {
	
	private static final long serialVersionUID = 1L;
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@NonNull
	@Email
	private String email;
	
	@NonNull
	private String user_name;
	
	@NonNull
	private Status user_status;
	
	@NonNull
	@NotBlank
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final LocalDateTime joinDate;

}
