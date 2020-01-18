package com.demo.model.rest;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class RespuestaDemo {
	
	protected HttpStatus status;
	
	protected String descripcion;
	
}
