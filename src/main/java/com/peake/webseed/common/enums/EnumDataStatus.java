package com.peake.webseed.common.enums;

public enum EnumDataStatus {

	
	del(-1,"删除"),	//
	normal(0,"正常"),
	freeze(1,"冻结"),
	zhuxiao(2,"注销");//
	
	private int value;
	private String desc;
	
	
	private EnumDataStatus(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumDataStatus setValue(int str) {
		for (EnumDataStatus e:EnumDataStatus.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return normal;

	}
	
}
