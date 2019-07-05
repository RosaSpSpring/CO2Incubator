package com.ko.co2incubator.bean;

/**
 * @author lxm
 * @version 2019/7/5-10:28
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class TempratureSetBean {
	private String msg;
	private int code;
	private String data;

	public TempratureSetBean() {
	}

	public TempratureSetBean(String msg, int code, String data) {
		this.msg = msg;
		this.code = code;
		this.data = data;
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
}
