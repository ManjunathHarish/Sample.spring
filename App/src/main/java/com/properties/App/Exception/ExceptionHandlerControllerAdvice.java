package com.properties.App.Exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpServerConnection;
import org.apache.http.impl.bootstrap.HttpServer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class ExceptionHandlerControllerAdvice 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse HandlerReosurceNotFound(final ResourceNotFoundException exception, final HttpServletRequest request)
	{
		ExceptionResponse error =new ExceptionResponse();
		error.setDescription(exception.getMessage());
		error.setPath(request.getRequestURI());
		return error;
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse HandleOtherExceptions(final Exception exception,final HttpServletRequest request)
	{
		ExceptionResponse error =new ExceptionResponse();
		error.setDescription(exception.getMessage());
		error.setPath(request.getRequestURI());
		return error;
	}
	
	
}

