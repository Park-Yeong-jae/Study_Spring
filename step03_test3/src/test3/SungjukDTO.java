package test3;

public class SungjukDTO {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + String.format("%.1f", avg);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}
