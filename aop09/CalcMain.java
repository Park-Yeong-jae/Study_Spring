package aop09;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop09/bean.xml");
		
		CalcMethod calcMethod = (CalcMethod) context.getBean("calc");
		calcMethod.sum(10, 2);
		calcMethod.div(10, 0);
		
		context.close();
	}
}
