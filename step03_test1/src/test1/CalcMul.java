package test1;

// Setter Injection : 초기화
public class CalcMul implements Calc {
	private int a2;
	private int b2;

	@Override
	public void calculate() {
		System.out.println(a2 + " * " + b2 + " = " + (a2 * b2));
	}

	// getter / setter
	public int getA2() {
		return a2;
	}

	public void setA2(int a2) {
		this.a2 = a2;
	}

	public int getB2() {
		return b2;
	}

	public void setB2(int b2) {
		this.b2 = b2;
	}
}
