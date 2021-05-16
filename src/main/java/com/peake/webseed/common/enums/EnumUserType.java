package com.peake.webseed.common.enums;

public enum EnumUserType {

	manager(0,"管理员"),
	member(1,"会员");//

	private int value;
	private String desc;


	private EnumUserType(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumUserType setValue(int str) {
		for (EnumUserType e:EnumUserType.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return null;

	}
	
}
