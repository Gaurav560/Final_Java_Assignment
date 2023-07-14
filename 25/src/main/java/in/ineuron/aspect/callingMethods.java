package in.ineuron.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.service.Serviceclass;


@Aspect
@Component
public class callingMethods {
	@Autowired
	private Serviceclass service;
	@Pointcut("execution(public * in.ineuron.service.*.add(int, int))")
	public void p1() {
	}
	@Around("p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("before transaction");

		try {
			  System.out.println("Around method: " + jp.getSignature().getName());
			  service.add(2, 2);
			Object object = jp.proceed();
			System.out.println("DATA IS ::" + object);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After transaction");

	}

	/*
	 * @Before("p1()") // join point public void beginTrans() {
	 * 
	 * System.out.println("begin the trans");
	 * 
	 * }
	 * 
	 * @AfterReturning(value = "p1()", returning = "obj") // join point public void
	 * commitTrans(Object obj) {
	 * 
	 * System.out.println("Sum of number is  :: " + obj);
	 * 
	 * System.out.println("commit transation"); }
	 * 
	 * @AfterThrowing(value = "p1()", throwing = "obj") // join point public void
	 * rollThrow(Throwable obj) { System.out.println("object rollback..." +
	 * obj.getMessage());
	 * 
	 * }
	 * 
	 * @After(value = "p1()") // join point public void emailSetUpCerdentials() {
	 * System.out.println("thanks for using");
	 * 
	 * }
	 */

}
