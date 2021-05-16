package com.peake.webseed.feature.merchant.enums;

/**
 * 分润计算方式
 */
public enum EnumBonusCalTypeStatus {

//0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
	pay_amount_ratio(0,"按照支付金额比例分成");//

	private int value;
	private String desc;


	private EnumBonusCalTypeStatus(int value, String desc) {
		this.value = value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
		
	public static EnumBonusCalTypeStatus setValue(int str) {
		for (EnumBonusCalTypeStatus e: EnumBonusCalTypeStatus.values()) {
			if(e.getValue()==str){
				return e;
			}
		}
		return null;

	}
	
}
