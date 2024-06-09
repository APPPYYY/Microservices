package com.ms.rating.service.aspects;

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
public class RatingServiceAspect {

	@Before(value = "execution(* com.ms.rating.service.services.impl.RatingServiceImpl.*(..))")
	public void beforeRatingServiceImplAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method started executing at "+new Date());
	}
	@After(value = "execution(* com.ms.rating.service.services.impl.RatingServiceImpl.*(..))")
	public void afterRatingServiceImplAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method ended executing at "+new Date());
	}
	@Before(value = "execution(* com.ms.rating.service.controllers.RatingController.*(..))")
	public void beforeRatingControllerAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method started executing at "+new Date());
	}
	@After(value = "execution(* com.ms.rating.service.controllers.RatingController.*(..))")
	public void afterRatingControllerAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method ended executing at "+new Date());
	}
}
