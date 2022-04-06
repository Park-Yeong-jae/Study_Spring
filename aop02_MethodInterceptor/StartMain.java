package aop02_MethodInterceptor;

import org.springframework.context.support.GenericXmlApplicationContext;


public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop02_MethodInterceptor/bean.xml");
		
		Person person = (Person) context.getBean("woman");
		person.classWork();
		System.out.println("--------------------");
		
		Person person2 = (Person) context.getBean("Man");
		person2.classWork();
		
		
		context.close();
	}
}
