/*
 * package com.spring.Department_Service.aspect;
 * 
 * import org.aspectj.lang.JoinPoint; import
 * org.aspectj.lang.ProceedingJoinPoint; import
 * org.aspectj.lang.annotation.After; import org.aspectj.lang.annotation.Around;
 * import org.aspectj.lang.annotation.Aspect; import
 * org.aspectj.lang.annotation.Before; import
 * org.aspectj.lang.annotation.Pointcut; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import org.springframework.stereotype.Component;
 * 
 * 
 * import com.splunk.Receiver; import com.splunk.Service; import
 * com.spring.Department_Service.DepartmentServiceApplication;
 * 
 * @Aspect
 * 
 * @Component public class LoggingAspect {
 * 
 * Service service = DepartmentServiceApplication.getService(); Receiver
 * receiver = service.getReceiver();
 * 
 * 
 * private final Logger log = LoggerFactory.getLogger(this.getClass());
 * 
 * @Pointcut("within(com.*.*.controller.*)") public void controllerAdvice() {
 * 
 * }
 * 
 * @Pointcut("within(com.*.*.service.*)" + "|| within(com.*.*.dao.*)") public
 * void servicesAdvice() {
 * 
 * }
 * 
 * 
 * 
 * @Pointcut("execution(* com.*.*.*.*.getDepartments(..))") public void
 * listDeptAdvice() {}
 * 
 * @Pointcut("execution(* com.*.*.*.DepartmentController.*(..))") public void
 * listAllDeptAdvice() {}
 * 
 * 
 * @Pointcut("execution(* com.*.*.*.*.*(..))") public void listAllAdvice() {}
 * 
 * @Before("listAllAdvice()") public void beforeAdvice() {
 * System.out.println("Department Service:Before All Operations"); }
 * 
 * @Before("controllerAdvice()") public void beforeControllerAdvice(JoinPoint
 * joinPoint) { System.out.println("Path is " + joinPoint.toString());
 * log.info("Starting of  URI"); receiver.log("deptemp",
 * "Department Service,Starting of URI"+ joinPoint.toString()); }
 * 
 * @After("servicesAdvice()") public void afterControllerAdvice(JoinPoint
 * joinPoint) {
 * log.info("After Completion of  Service layers and DAO layers"+joinPoint.
 * toString()); receiver.log("deptemp",
 * "Department Service,After Completion of  Service layers and DAO layers"+
 * joinPoint.toString()); }
 * 
 * 
 * 
 * @After("listAllDeptAdvice()") public void afterAllDepartment() {
 * log.info("Department Advice:All Department related Operations");
 * receiver.log("deptemp",
 * "Department Service:All Department related Operations"); }
 * 
 * 
 * 
 * @Around("listDeptAdvice()") public Object aroundAdvice(ProceedingJoinPoint
 * proceedingJoinPoint) { Object returnvalue = null; try {
 * System.out.println("Before Dept Around Advice"); receiver.log("deptemp",
 * "Department Service,Before Around Advice: Before List All Department");
 * returnvalue=proceedingJoinPoint.proceed();
 * System.out.println("After returning  Dept around Advice");
 * receiver.log("deptemp",
 * "Department Service,After Around Advice: After List all Department "); }
 * catch(Throwable e) { System.out.println("After throwing");
 * receiver.log("deptemp", "Department Service,After Throwing an Exception"); }
 * System.out.println("After finally"); return returnvalue; }
 * 
 * }
 */