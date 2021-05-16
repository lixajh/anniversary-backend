package com.peake.webseed.feature.pay.enums;

/**
 * 支付状态
 */
public enum EnumPayStatus {

//0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭
	to_pay(0,"待支付"),//
	pay_up(1,"已支付"),//
	fail(2,"失败"),
	time_out(3,"超时"),//
	cancel(4,"取消"),//
	not_exist(5,"交易不存在"),//
	closed(6,"交易关闭"),
	unknown_error(7,"未知错误");//

	private int value;
	private String desc;


	private EnumPayStatus(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumPayStatus setValue(int str) {
		for (EnumPayStatus e: EnumPayStatus.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return null;
	}
}
