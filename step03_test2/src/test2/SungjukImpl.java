package test2;

import java.util.Scanner;

public class SungjukImpl implements Sungjuk {

	private SungjukDTO dto;
	private int tot;
	private double avg;

	public SungjukImpl(SungjukDTO dto) {
		this.dto = dto;
	}

	@Override
	public void calcTot() {
		tot = dto.getKor() + dto.getEng() + dto.getMat();
		dto.setTot(tot);
	}

	@Override
	public void calcAvg() {
		avg = (double) tot / 3;
		dto.setAvg(avg);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(dto.toString());
		System.out.println();
	}

	@Override
	public void modify() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름입력 : ");
		dto.setName(sc.next());
		System.out.print("국어입력 : ");
		dto.setKor(sc.nextInt());
		System.out.print("영어입력 : ");
		dto.setEng(sc.nextInt());
		System.out.print("수학입력 : ");
		dto.setMat(sc.nextInt());

		calcTot();
		calcAvg();
	}

}
