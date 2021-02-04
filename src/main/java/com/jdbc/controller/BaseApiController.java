package com.jdbc.controller;

import com.jdbc.model.AjaxResult;

public class BaseApiController {
	public AjaxResult  success() {
		AjaxResult result = new AjaxResult(true,0,"请求成功",null);
		return result;
	}
	public AjaxResult success(Object data) {
		AjaxResult result = new AjaxResult(true,0,"请求成功",data);
		return result;
	}
	
	public AjaxResult error() {
		AjaxResult result = new AjaxResult(false,1,"请求失败",null);
		return result;
	}
	public AjaxResult error(String msg) {
		AjaxResult result = new AjaxResult(false,1,msg,null);
		return result;
	}
}
