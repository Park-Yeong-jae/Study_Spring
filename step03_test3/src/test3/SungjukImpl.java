package test3;

import java.util.Scanner;

public class SungjukImpl implements Sungjuk {

	private SungjukDTO dto;

	public SungjukDTO getDto() {
		return dto;
	}

	public void setDto(SungjukDTO dto) {
		this.dto = dto;
	}

	@Override
	public void calcTot() {
		dto.setTot(dto.getKor() + dto.getEng() + dto.getMat());
	}

	@Override
	public void calcAvg() {
		dto.setAvg((double) dto.getTot() / 3);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(dto.toString() + "\n");
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
