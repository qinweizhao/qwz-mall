package com.qinweizhao.auth.constant;

/**
 * 系统类型
 * @author FrozenWatermelon
 * @date 2020/7/2
 */
public enum SysTypeEnum {

	/**
	 * app 前台系统
	 */
	APP("app"),

	/**
	 * web前台系统
	 */
	WEB("web"),

	/**
	 * 后台管理系统
	 */
	ADMIN("admin"),



	;

	private final String value;

	public String value() {
		return value;
	}

	SysTypeEnum(String value) {
		this.value = value;
	}

}
