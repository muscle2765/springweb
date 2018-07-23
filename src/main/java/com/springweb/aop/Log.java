package com.springweb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log {
	@Before("execution(* com.springweb.service.*.*(..))")
	public void before() {
		System.out.println("方法执行前");
	}

	@After("execution(* com.springweb.service.*.*(..))")
	public void after() {
		System.out.println("方法执行后");
	}

	@Around("execution(* com.springweb.service.*.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("环绕前");
		System.out.println("方法" + jp.getSignature());
		Object result = jp.proceed();
		System.out.println("环绕后");
		return result;
	}
}
