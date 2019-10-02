package com.cy.ichendb.pj.common.vo;

import java.io.Serializable;

/**
 * VO:封装控制层要返回给哭护短的数据
 */
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 2080943344863436345L;
	/** 状态码 */
	private int state = 1;// 1表示SUCCESS,0表示ERROR
	/** 状态信息 */
	private String message = "OK";
	/** 正确数据 */
	private Object data;

	public JsonResult() {
	}

	// 一般查询时调用
	public JsonResult(Object data) {
		this.data = data;
	}

	public JsonResult(String message) {
		this.message = message;
	}

	// 出现异常时调用
	public JsonResult(Throwable t) {
		this.state = 0;
		this.message = t.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
