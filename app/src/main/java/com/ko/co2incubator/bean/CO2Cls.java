package com.ko.co2incubator.bean;

/**
 * @author lxm
 * @version 2019/7/5-10:10
 * @des ${CO2JavaBean}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class CO2Cls {
	private String msg;
	private int code;
	private String data;

	public CO2Cls(String msg, int code, String data) {
		this.msg = msg;
		this.code = code;
		this.data = data;
	}

	public CO2Cls() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CO2Cls{" + "msg='" + msg + '\'' + ", code=" + code + ", data='" + data + '\'' + '}';
	}
}
