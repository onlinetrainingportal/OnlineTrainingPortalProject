package com.project.Exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message)
	
	{
		super(message);
	}
}