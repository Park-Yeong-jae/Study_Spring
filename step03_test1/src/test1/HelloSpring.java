package test1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// bean 객체 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("test1/bean.xml");

		Calc calc_add = (Calc) context.getBean("add");
		calc_add.calculate();
		System.out.println("------------------");

		Calc calc_mul = (Calc) context.getBean("mul");
		calc_mul.calculate();

		context.close();
	}
}
