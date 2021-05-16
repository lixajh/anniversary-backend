package com.peake.webseed.feature.product.enums;

/**
 * 产品状态
 */
public enum EnumProductDataStatus {


	del(-1,"删除"),	//
	not_sale(0,"未上架"),
	saling(1,"已上架");//

	private int value;
	private String desc;


	private EnumProductDataStatus(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumProductDataStatus setValue(int str) {
		for (EnumProductDataStatus e:EnumProductDataStatus.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return null;

	}
	
}
