package com.pcwk.ctrl.naver;

import java.util.ArrayList;
import java.util.List;

import com.pcwk.ctrl.cmn.DTO;

public class Item extends DTO {

	private String id;
	private String email;
	private String mobile;
	private String name;
	private String mobile_e164;//국제번호
	
	public Item() {}

	private List<Item> items = new ArrayList<Item>();
	
	public List<Item> getItems(){
		return items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_e164() {
		return mobile_e164;
	}

	public void setMobile_e164(String mobile_e164) {
		this.mobile_e164 = mobile_e164;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", email=" + email + ", mobile=" + mobile + ", name=" + name + ", mobile_e164="
				+ mobile_e164 + ", items=" + items + ", toString()=" + super.toString() + "]";
	}

	
	
}
