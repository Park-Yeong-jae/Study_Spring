package aop02_MethodInterceptor;

public class Woman implements Person{

	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜고 Shopping을 시작한다");
	}
}
