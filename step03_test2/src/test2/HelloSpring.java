package test2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. bean.xml 설정 정보를 이용해서 bean 객체를 생성한다.
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("test2/bean.xml");
		
		// 2. bean 객체를 제공한다.
		Sungjuk bean = (Sungjuk) context.getBean("sungjukImpl");
		bean.calcTot();
		bean.calcAvg();
		bean.display();
		bean.modify();

		context.close();
	}
}
