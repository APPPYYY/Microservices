package com.ms.hotel.service.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class HotelAspect {

	@Before(value = "execution(* com.ms.hotel.service.controllers.HotelController.*(..))")
	public void beforeHotelControllerAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method started executing at "+new Date());
	}
	@After(value = "execution(* com.ms.hotel.service.controller.HotelController.*(..))")
	public void afterHotelControllerAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method ended executing at "+new Date());
	}
	@Before(value = "execution(* com.ms.hotel.service.service.impl.HotelServiceImpl.*(..))")
	public void beforeHotelServiceImplAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method started executing at "+new Date());
	}
	@After(value = "execution(* com.ms.hotel.service.service.impl.HotelServiceImpl.*(..))")
	public void afterHotelServiceImplAdvice(JoinPoint joinPoint) {
		log.info(joinPoint.getSignature()+" method ended executing at "+new Date());
	}
}
