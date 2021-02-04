package com.jdbc.model;

public class AjaxResult {
	
	public AjaxResult(boolean success, int errorCode, String msg, Object data) {
		super();
		this.success = success;
		this.errorCode = errorCode;
		this.msg = msg;
		this.data = data;
	}
	public boolean success;
	public int errorCode;
	public String msg;
	public Object data;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "AjaxResult [success=" + success + ", errorCode=" + errorCode + ", msg=" + msg + ", data=" + data + "]";
	}

	
	
	
}
