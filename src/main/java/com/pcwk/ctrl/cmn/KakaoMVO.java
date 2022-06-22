package com.pcwk.ctrl.cmn;

public class KakaoMVO extends DTO {
	private long kNum; // 회원번호
	private String kName; // 이름
	private String kEmail; // 이메일
	private String kTel; // 전화번호
	private String kAddr; // 주소
	private String kGrade; // 등급
	
	public KakaoMVO() {}

	public KakaoMVO(int kNum, String kName, String kEmail, String kTel, String kAddr, String kGrade) {
		super();
		this.kNum = kNum;
		this.kName = kName;
		this.kEmail = kEmail;
		this.kTel = kTel;
		this.kAddr = kAddr;
		this.kGrade = kGrade;
	}

	public long getkNum() {
		return kNum;
	}

	public void setkNum(long kNum) {
		this.kNum = kNum;
	}

	public String getkName() {
		return kName;
	}

	public void setkName(String kName) {
		this.kName = kName;
	}

	public String getkEmail() {
		return kEmail;
	}

	public void setkEmail(String kEmail) {
		this.kEmail = kEmail;
	}

	public String getkTel() {
		return kTel;
	}

	public void setkTel(String kTel) {
		this.kTel = kTel;
	}

	public String getkAddr() {
		return kAddr;
	}

	public void setkAddr(String kAddr) {
		this.kAddr = kAddr;
	}

	public String getkGrade() {
		return kGrade;
	}

	public void setkGrade(String kGrade) {
		this.kGrade = kGrade;
	}

	@Override
	public String toString() {
		return "KakaoMVO [kNum=" + kNum + ", kName=" + kName + ", kEmail=" + kEmail + ", kTel=" + kTel + ", kAddr="
				+ kAddr + ", kGrade=" + kGrade + ", toString()=" + super.toString() + "]";
	}
	
}
