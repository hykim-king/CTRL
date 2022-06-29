package com.pcwk.ctrl.cmn;

public class ReviewRdVO {
	private long rNum; // 댓글번호
	private String rContent; // 리뷰 내용
	private String rdCon; // 관리자 댓글 내용
	private String rdName; // 관리자 댓글 작성자
	private String oName; // 회원 이름
	private String mNum; // 회원번호
	private long oNum; // 주문번호
	private String dNum; // 주문 상세 번호
	private String rDt; // 리뷰 작성일
	private String rdReg; // 관리자 댓글 작성일
	
	public ReviewRdVO(long rNum, String rContent, String rdCon, String rdName, String oName, String mNum, long oNum,
			String dNum, String rDt, String rdReg) {
		super();
		this.rNum = rNum;
		this.rContent = rContent;
		this.rdCon = rdCon;
		this.rdName = rdName;
		this.oName = oName;
		this.mNum = mNum;
		this.oNum = oNum;
		this.dNum = dNum;
		this.rDt = rDt;
		this.rdReg = rdReg;
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

	public long getoNum() {
		return oNum;
	}

	public void setoNum(long oNum) {
		this.oNum = oNum;
	}

	public String getdNum() {
		return dNum;
	}

	public void setdNum(String dNum) {
		this.dNum = dNum;
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

	@Override
	public String toString() {
		return "ReviewRdVO [rNum=" + rNum + ", rContent=" + rContent + ", rdCon=" + rdCon + ", rdName=" + rdName
				+ ", oName=" + oName + ", mNum=" + mNum + ", oNum=" + oNum + ", dNum=" + dNum + ", rDt=" + rDt
				+ ", rdReg=" + rdReg + ", toString()=" + super.toString() + "]";
	}




	
	
}
