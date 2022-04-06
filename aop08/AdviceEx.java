package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 공통 관심 사항
@Aspect
public class AdviceEx {

	@Around("execution(* zeroMethod(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("JoinPoint 양쪽의 '전'에 실행되는 Advice");
		jp.proceed();
		System.out.println("JoinPoint 양쪽의 '후'에 실행되는 Advice");
	}

	@Before("execution(* zeroMethod(..))")
	public void before() {
		System.out.println("JoinPoint '앞'에서 실행되는 Advice");
	}

	@AfterThrowing(pointcut = "execution(* zeroMethod(..))", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("예외가 발생할 때 호출되는 Advice");
		System.out.println(e.getMessage());
	}

	@AfterReturning(pointcut = "execution(* zeroMethod(..))", returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("JoinPoint가 '정상 종료 후' 실행되는 Advice");
	}

	@After("execution(* zeroMethod(..))")
	public void after() {
		System.out.println("JoinPoint '뒤'에서 실행되는 Advice");
	}
}
