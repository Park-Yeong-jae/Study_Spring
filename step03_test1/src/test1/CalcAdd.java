package test1;

// Constructor Injection : 생성자
public class CalcAdd implements Calc {
	private int a1;
	private int b1;

	// 생성자
	public CalcAdd() {
		super();
	}

	public CalcAdd(int a1, int b1) {
		super();
		this.a1 = a1;
		this.b1 = b1;
	}

	@Override
	public void calculate() {
		System.out.println(a1 + " + " + b1 + " = " + (a1 + b1));
	}
}
