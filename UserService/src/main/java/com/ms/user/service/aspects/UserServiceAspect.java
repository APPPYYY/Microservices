package com.ms.user.service.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class UserServiceAspect {

	@Before(value = "execution(* com.ms.user.service.controller.UserController.*(..))")
	public void beforeUserControllerAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method started executing at "+new Date());
	}
	@After(value = "execution(* com.ms.user.service.controller.UserController.*(..))")
	public void afterUserControllerAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method ended executing at "+new Date());
	}
	@Before(value = "execution(* com.ms.user.service.service.impl.UserServiceImpl.*(..))")
	public void beforeUserServiceImplAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method started executing at "+new Date());
	}
	@After(value = "execution(* com.ms.user.service.service.impl.UserServiceImpl.*(..))")
	public void afterUserServiceImplAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method ended executing at "+new Date());
	}
}
