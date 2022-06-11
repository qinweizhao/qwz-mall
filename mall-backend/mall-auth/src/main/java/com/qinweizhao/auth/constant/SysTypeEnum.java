package com.qinweizhao.auth.constant;

/**
 * 系统类型
 * @author FrozenWatermelon
 * @date 2020/7/2
 */
public enum SysTypeEnum {

	/**
	 * web前台系统
	 */
	WEB(0),

	/**
	 * 后台管理系统
	 */
	ADMIN(1),


	;

	private final Integer value;

	public Integer value() {
		return value;
	}

	SysTypeEnum(Integer value) {
		this.value = value;
	}

}
