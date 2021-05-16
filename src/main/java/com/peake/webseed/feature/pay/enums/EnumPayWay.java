package com.peake.webseed.feature.pay.enums;

/**
 * 支付方式
 */
public enum EnumPayWay {


	wechat(1,"微信"),//
	alipay(2,"支付宝");//

	private int value;
	private String desc;


	private EnumPayWay(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumPayWay setValue(int str) {
		for (EnumPayWay e: EnumPayWay.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return null;

	}
	
}
