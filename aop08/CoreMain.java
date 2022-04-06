package aop08;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CoreMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop08/bean.xml");

		CoreEx ex = (CoreEx) context.getBean("core");
		ex.zeroMethod(5, 7);
		System.out.println("--------------------");

		ex.zeroMethod(5, 0);

		context.close();
	}
}
