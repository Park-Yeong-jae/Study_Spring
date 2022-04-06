package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalcAdvice {
	// 핵심관심사항 함수 설정
	@Pointcut("execution(public * *(..))")
	public void myCalc() {}
	
	@Around("myCalc()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("** 연산시작 **");
		jp.proceed();
		System.out.println("** 연산종료 **\n\n");
	}
}
