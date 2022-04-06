package aop02_MethodInterceptor;

public class Man implements Person{

	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜도 Game을 시작한다.");
	}
}
