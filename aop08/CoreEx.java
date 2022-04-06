package aop08;

// 핵심 관심 사항
public class CoreEx {
	public void zeroMethod(int a, int b) {
		try {
			System.out.println(a + " / " + b + " = " + (a / b));
		} catch (Exception e) {
			System.out.println("O으로 나눌 수 없습니다.");
			//throw new RuntimeException("O으로 나눌 수 없습니다."); // 예외를 발생시켜서 던져버림
		}
	}
}
