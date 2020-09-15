package com.AOPLogging.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.AOPLogging.AopLoggingApplication;
import com.splunk.Receiver;
import com.splunk.Service;


@Aspect
@Component
public class EmployeeLogging {
	Service service = AopLoggingApplication.getService();
	Receiver receiver = service.getReceiver();


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.*.*.controller.*)")
	public void controllerAdvice() {

	}

	@Pointcut("within(com.*.*.service.*)" + "|| within(com.*.*.dao.*)")
	public void servicesAdvice() {

	}

	@Pointcut("execution(* com.*.*.*.*.getEmpByDeptId(..))")
	public void listEmpAdvice() {
	}

	

	@Pointcut("execution(* com.*.*.*.*.*(..))")
	public void listAllAdvice() {
	}

	@Before("listAllAdvice()")
	public void beforeAdvice() {
		System.out.println("Employee Service:Before All Operations");
	}

	

	@After("servicesAdvice()")
	public void afterControllerAdvice(JoinPoint joinPoint) {
		log.info("After Completion of  Service layers and DAO layers"+joinPoint.toString());
		receiver.log("deptemp", "Employee Service:After Completion of  Service layers and DAO layers"+joinPoint.toString());
	}

	

	@Around("listEmpAdvice()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnvalue = null;
		try {
			System.out.println("Before Employee Around Advice");
			receiver.log("deptemp", "Employee Service: Before  Employee Operation");
			returnvalue = proceedingJoinPoint.proceed();
			System.out.println("After returning Employee around Advice");
			receiver.log("deptemp", "Employee Service: After Executing  Employee Operation "+proceedingJoinPoint.toString());
		} catch (Throwable e) {
			System.out.println("After throwing");
			receiver.log("deptemp", "Employee Service:After Throwing an Exception");
		}
		
		return returnvalue;
	}

}
