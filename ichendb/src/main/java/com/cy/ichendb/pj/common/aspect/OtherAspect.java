package com.cy.ichendb.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Service
@Aspect
@Slf4j
public class OtherAspect {
//	@Around("")
	public Object around(ProceedingJoinPoint jp)throws Throwable {
		log.info("start:"+System.currentTimeMillis());
		Object result = jp.proceed();
		log.info("end:"+System.currentTimeMillis());
		return result;
	}
}
