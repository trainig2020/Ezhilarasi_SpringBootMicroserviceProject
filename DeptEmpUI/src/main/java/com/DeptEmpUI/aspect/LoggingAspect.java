/*
 * package com.DeptEmpUI.aspect;
 * 
 * import org.aspectj.lang.JoinPoint; import
 * org.aspectj.lang.ProceedingJoinPoint; import
 * org.aspectj.lang.annotation.After; import org.aspectj.lang.annotation.Around;
 * import org.aspectj.lang.annotation.Aspect; import
 * org.aspectj.lang.annotation.Before; import
 * org.aspectj.lang.annotation.Pointcut; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import org.springframework.stereotype.Component;
 * 
 * import com.DeptEmpUI.DeptEmpUiApplication; import com.splunk.Receiver; import
 * com.splunk.Service;
 * 
 * @Aspect
 * 
 * @Component public class LoggingAspect {
 * 
 * Service service = DeptEmpUiApplication.getService(); Receiver receiver =
 * service.getReceiver();
 * 
 * 
 * private final Logger log = LoggerFactory.getLogger(this.getClass());
 * 
 * @Pointcut("within(com.*.controller.*)") public void controllerAdvice() {
 * 
 * }
 * 
 * 
 * 
 * @Pointcut("execution(* com.*.*.*.listDepartment(..))") public void
 * listDeptAdvice() {}
 * 
 * @Pointcut("execution(* com.*.*.DeptController.*(..))") public void
 * listAllDeptAdvice() {}
 * 
 * @Pointcut("execution(* com.*.*.EmployeeController.*(..))") public void
 * listAllEmployeeAdvice() {}
 * 
 * @Pointcut("execution(* com.*.*.*.*(..))") public void listAllAdvice() {}
 * 
 * 
 * 
 * @Before("controllerAdvice()") public void beforeControllerAdvice(JoinPoint
 * joinPoint) { System.out.println("Path is " + joinPoint.toString());
 * log.info("Starting of  URI"); receiver.log("deptemp",
 * "Client,Starting of URI"); }
 * 
 * 
 * 
 * 
 * @After("listAllDeptAdvice()") public void afterAllDepartment() {
 * log.info("Department Advice:All Department related Operations");
 * receiver.log("deptemp",
 * "Client,Department Advice:All Department related Operations"); }
 * 
 * @After("listAllEmployeeAdvice()") public void afterAllEmployee() {
 * log.info("Employee Advice:All Employee related Operations");
 * receiver.log("deptemp",
 * "Client,Employee Advice:All Employee related Operations"); }
 * 
 * @Around("listDeptAdvice()") public Object aroundAdvice(ProceedingJoinPoint
 * proceedingJoinPoint) { Object returnvalue = null; try {
 * System.out.println("Client,Before Around Advice"); receiver.log("deptemp",
 * "Client,Before Around Advice: Before List All Department");
 * returnvalue=proceedingJoinPoint.proceed();
 * System.out.println("Client,After returning around Advice");
 * receiver.log("deptemp",
 * "Client,After Around Advice: After List all Department "); } catch(Throwable
 * e) { System.out.println("Client,After throwing"); receiver.log("deptemp",
 * "Client,After Throwing an Exception"); }
 * System.out.println("Client,After finally"); return returnvalue; }
 * 
 * }
 */

