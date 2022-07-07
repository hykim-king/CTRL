package com.pcwk.ctrl.cmn;

public class CartVO extends DTO {
	private String mNum;
	private int cNum;
	private String pNum;
	private String pName;
	private int cBuy;
	private int pPrice;
	private int cTotal;
	
	public CartVO() {
		
	}

	public CartVO(String mNum, int cNum, String pNum, String pName, int cBuy, int pPrice, int cTotal) {
		super();
		this.mNum = mNum;
		this.cNum = cNum;
		this.pNum = pNum;
		this.pName = pName;
		this.cBuy = cBuy;
		this.pPrice = pPrice;
		this.cTotal = cTotal;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getcBuy() {
		return cBuy;
	}

	public void setcBuy(int cBuy) {
		this.cBuy = cBuy;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getcTotal() {
		return cTotal;
	}

	public void setcTotal(int cTotal) {
		this.cTotal = cTotal;
	}

	@Override
	public String toString() {
		return "CartVO [mNum=" + mNum + ", cNum=" + cNum + ", pNum=" + pNum + ", pName=" + pName + ", cBuy=" + cBuy
				+ ", pPrice=" + pPrice + ", cTotal=" + cTotal + ", toString()=" + super.toString() + "]";
	}
	
}