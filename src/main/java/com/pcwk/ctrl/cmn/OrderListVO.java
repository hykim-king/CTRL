package com.pcwk.ctrl.cmn;

public class OrderListVO extends DTO{
	private long rNum; // 게시글 번호
	
	private long oNum; // 주문번호
	private String dNum; // 주문 상세 번호
	private String dBuy; // 구매수량
	
	private String mName; // 이름
	private String mEmail; // 이메일
	private String mTel; // 전화번호
	private String mAddr; // 주소
	private String mGrade; // 등급
	
	private String oAddr; // 주소
	private String oName; // 이름
	private String oTel; // 전화번호
	private String oStatus; // 주문상태
	private String oDt; // 주문날짜
	private String mNum; // 회원번호
	
	private String pNum; // 상품번호
	private String pCategory; // 카테고리
	private String pName; // 상품이름
	private long pPrice; // 가격
	private String pSize; // 용량
	
	public OrderListVO() {}

	public OrderListVO(long rNum, long oNum, String dNum, String dBuy, String mName, String mEmail, String mTel,
			String mAddr, String mGrade, String oAddr, String oName, String oTel, String oStatus, String oDt,
			String mNum, String pNum, String pCategory, String pName, long pPrice, String pSize) {
		super();
		this.rNum = rNum;
		this.oNum = oNum;
		this.dNum = dNum;
		this.dBuy = dBuy;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mTel = mTel;
		this.mAddr = mAddr;
		this.mGrade = mGrade;
		this.oAddr = oAddr;
		this.oName = oName;
		this.oTel = oTel;
		this.oStatus = oStatus;
		this.oDt = oDt;
		this.mNum = mNum;
		this.pNum = pNum;
		this.pCategory = pCategory;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
	}

	public long getrNum() {
		return rNum;
	}

	public void setrNum(long rNum) {
		this.rNum = rNum;
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

	public String getdBuy() {
		return dBuy;
	}

	public void setdBuy(String dBuy) {
		this.dBuy = dBuy;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public String getmGrade() {
		return mGrade;
	}

	public void setmGrade(String mGrade) {
		this.mGrade = mGrade;
	}

	public String getoAddr() {
		return oAddr;
	}

	public void setoAddr(String oAddr) {
		this.oAddr = oAddr;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoTel() {
		return oTel;
	}

	public void setoTel(String oTel) {
		this.oTel = oTel;
	}

	public String getoStatus() {
		return oStatus;
	}

	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	public String getoDt() {
		return oDt;
	}

	public void setoDt(String oDt) {
		this.oDt = oDt;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public long getpPrice() {
		return pPrice;
	}

	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	@Override
	public String toString() {
		return "OrderListVO [rNum=" + rNum + ", oNum=" + oNum + ", dNum=" + dNum + ", dBuy=" + dBuy + ", mName=" + mName
				+ ", mEmail=" + mEmail + ", mTel=" + mTel + ", mAddr=" + mAddr + ", mGrade=" + mGrade + ", oAddr="
				+ oAddr + ", oName=" + oName + ", oTel=" + oTel + ", oStatus=" + oStatus + ", oDt=" + oDt + ", mNum="
				+ mNum + ", pNum=" + pNum + ", pCategory=" + pCategory + ", pName=" + pName + ", pPrice=" + pPrice
				+ ", pSize=" + pSize + ", toString()=" + super.toString() + "]";
	}

	
	
}
	