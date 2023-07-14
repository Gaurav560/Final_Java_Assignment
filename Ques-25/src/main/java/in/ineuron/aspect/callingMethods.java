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
import org.springframework.stereotype.Component;

@Aspect
@Component
public class callingMethods {
	@Pointcut("execution(public * in.ineuron.service.*.add(int, int))")
	public void p1() {
	}

	@Before("p1()") // join point
	public void beginTrans() {

		System.out.println("begin the trans");

	}

	@After("p1()")
	public void aftertrans() {
		System.out.println("Have a great day ahead");
	}

	@AfterReturning(value = "p1()", returning = "obj") // join point
	public void commitTrans(Object obj) {

		System.out.println("Sum of number is  :: " + obj);

		System.out.println("commit transation");
	}

	@AfterThrowing(value = "p1()", throwing = "obj") // join point
	public void rollThrow(Throwable obj) {
		System.out.println("object rollback..." + obj.getMessage());

	}

	@After(value = "p1()") // join point
	public void emailSetUpCerdentials() {
		System.out.println("thanks for using");

	}

}
