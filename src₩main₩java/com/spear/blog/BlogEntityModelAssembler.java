package com.spear.blog;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.spear.blog.controller.BlogController;
import com.spear.blog.domain.Blog;

@Component
public class BlogEntityModelAssembler implements RepresentationModelAssembler<Blog, EntityModel<Blog>>{

	@Override
	public EntityModel<Blog> toModel(Blog blog) {
		// TODO Auto-generated method stub
		return new EntityModel<>(blog, 
				linkTo(methodOn(BlogController.class).one(blog.getBlogId())).withSelfRel(),
				linkTo(methodOn(BlogController.class).all()).withRel("blogs"));
	}

}
