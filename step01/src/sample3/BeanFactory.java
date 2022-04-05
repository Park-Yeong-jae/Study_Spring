package sample3;

// 팩토리 패턴으로 객체 생성
public class BeanFactory {
	public MessageBean getBean(String beanName) {
		MessageBean bean = null;
		if (beanName.equals("en")) {
			bean = new MessageBeanEn();
		} else if (beanName.equals("kr")) {
			bean = new MessageBeanKr();
		}
		return bean;
	}
}
