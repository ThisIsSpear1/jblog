package com.spear.blog;

public class BlogNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogNotFoundException(Long id){
		super("Could not find Blog" + id);
	}
	
}
