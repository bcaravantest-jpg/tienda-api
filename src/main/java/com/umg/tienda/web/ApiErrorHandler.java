package com.umg.tienda.web;

import com.umg.tienda.service.NotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class ApiErrorHandler {
	 @ExceptionHandler(NotFoundException.class)
	  public ResponseEntity<?> notFound(NotFoundException ex) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
	  }

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<?> validation(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(errors);
	  }
	}
