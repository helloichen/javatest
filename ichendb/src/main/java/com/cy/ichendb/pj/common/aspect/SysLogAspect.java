package com.cy.ichendb.pj.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.ichendb.pj.sys.dao.SysLogDao;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Service
@Slf4j
public class SysLogAspect {
	@Autowired
	private SysLogDao sysLogDao;
//
//	@Pointcut("@annotation(com.cy.pj.common.anno.RequestLog)")
//	public void logPointCut() {
//	}
//
//	@Around("logPoingCut()")
//	public Object around(ProceedingJoinPoint jp) throws Throwable {
//		long startTimes = System.currentTimeMillis();
//		// 执行目标方法(result为目标方法的执行结果)
//		Object result = jp.proceed();
//		long totalTime = System.currentTimeMillis() - startTimes;
//		log.info("方法执行的总时长为:" + totalTime);
////		saveSysLog(jp, totalTime);
//		return result;
//	}

	/**
	 * @Pointcut 注解用于定义切入点 bean表达式为切入点表达式 bean表达式内部指定的备案对象中所有方法为切入点(进行功能扩展的点)
	 */
	/*
	 * @Pointcut("bean(sysUserServiceImpl)") public void logPointCut() { }
	 *//**
		 * @Around 描述的方法为around通知,用于功能增强 环绕通知(目标方法执行之前和之后都可以执行
		 * @param jp 连接点(封装了要执行的目标方法信息)
		 * @return 目标方法的执行结果
		 * @throws Throwable
		 *//*
			 * @Around("logPointCut()") public Object around(ProceedingJoinPoint jp) throws
			 * Throwable { try { log.info("start:" + System.currentTimeMillis());
			 * //调用下一个切面或目标方法 Object result = jp.proceed(); log.info("after:" +
			 * System.currentTimeMillis()); return result; } catch (Throwable e) {
			 * log.error(e.getMessage()); throw e; } }
			 */

}
