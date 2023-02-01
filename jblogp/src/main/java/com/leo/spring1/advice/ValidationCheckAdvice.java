package com.leo.spring1.advice;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.leo.spring1.dto.ResponseDTO;


// AOP를 이용한 유효성검사 p201
@Component
@Aspect

public class ValidationCheckAdvice {
	@Around("execution(* com.leo..controller.*Controller.*(..))")
	public Object validationCheck(ProceedingJoinPoint jp) throws Throwable{
		Object[] args = jp.getArgs();
		for(Object arg:args) {
			BindingResult bindingResult = (BindingResult)arg;
			if(bindingResult.hasErrors()) {
				Map<String, String> errorMap = new HashMap<>();
				for(FieldError error: bindingResult.getFieldErrors()) {
					errorMap.put(error.getField(), error.getDefaultMessage());
				}
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
			}
		}
		return jp.proceed();
	}
}
