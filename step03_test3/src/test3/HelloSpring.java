package test3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("test3/bean.xml");

		Sungjuk bean = (Sungjuk) context.getBean("sungjukImpl");
		bean.calcTot();
		bean.calcAvg();
		bean.display();
		bean.modify();

		context.close();

	}
}
