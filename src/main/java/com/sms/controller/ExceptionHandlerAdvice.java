package com.sms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.sms.exception.SmsException;
import com.sms.model.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	 @ExceptionHandler(SmsException.class)
	 public ResponseEntity<ErrorResponse> handlerException( Exception ex, WebRequest request){
		 ErrorResponse er  = new ErrorResponse();
		 er.setMessage(ex.getMessage());
		 return new ResponseEntity<ErrorResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
}
