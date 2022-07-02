package com.pcwk.ctrl.cmn;

public class ReviewRdVO {
	private long rNum; // 댓글번호
	private String rContent; // 리뷰 내용
	private String rdCon; // 관리자 댓글 내용
	private String rdName; // 관리자 댓글 작성자
	private String oName; // 회원 이름
	private String mNum; // 회원번호
	private String managerNum; // 관리자 번호
	private String rDt; // 리뷰 작성일
	private String rdReg; // 관리자 댓글 작성일
	private int cnt; // 관리자 등급 유무 알수있는 열
	
	public ReviewRdVO(long rNum, String rContent, String rdCon, String rdName, String oName, String mNum,
			String managerNum, String rDt, String rdReg, int cnt) {
		super();
		this.rNum = rNum;
		this.rContent = rContent;
		this.rdCon = rdCon;
		this.rdName = rdName;
		this.oName = oName;
		this.mNum = mNum;
		this.managerNum = managerNum;
		this.rDt = rDt;
		this.rdReg = rdReg;
		this.cnt = cnt;
	}

	public long getrNum() {
		return rNum;
	}

	public void setrNum(long rNum) {
		this.rNum = rNum;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getRdCon() {
		return rdCon;
	}

	public void setRdCon(String rdCon) {
		this.rdCon = rdCon;
	}

	public String getRdName() {
		return rdName;
	}

	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	public String getManagerNum() {
		return managerNum;
	}

	public void setManagerNum(String managerNum) {
		this.managerNum = managerNum;
	}

	public String getrDt() {
		return rDt;
	}

	public void setrDt(String rDt) {
		this.rDt = rDt;
	}

	public String getRdReg() {
		return rdReg;
	}

	public void setRdReg(String rdReg) {
		this.rdReg = rdReg;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "ReviewRdVO [rNum=" + rNum + ", rContent=" + rContent + ", rdCon=" + rdCon + ", rdName=" + rdName
				+ ", oName=" + oName + ", mNum=" + mNum + ", managerNum=" + managerNum + ", rDt=" + rDt + ", rdReg="
				+ rdReg + ", cnt=" + cnt + ", toString()=" + super.toString() + "]";
	}

	
}
