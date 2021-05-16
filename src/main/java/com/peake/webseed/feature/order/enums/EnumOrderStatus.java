package com.peake.webseed.feature.order.enums;

/**
 * 订单状态
 */
public enum EnumOrderStatus {

//0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
	to_pay(0,"待支付"),
	pay_up(1,"已支付"),
	pay_fail(2,"支付失败"),
	on_work(3,"设备工作中"),
	device_broken(4,"设备故障"),
	finished(5,"完成"),
	closed(6,"交易关闭"),
	unknown_error(7,"未知错误");

	private int value;
	private String desc;


	private EnumOrderStatus(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumOrderStatus setValue(int str) {
		for (EnumOrderStatus e: EnumOrderStatus.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return null;

	}
	
}
