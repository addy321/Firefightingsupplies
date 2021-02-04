package com.jdbc.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserReceiveModel {
	private Integer apparatusId;
	private String remarks;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	public Integer getApparatusId() {
		return apparatusId;
	}
	public void setApparatusId(Integer apparatusId) {
		this.apparatusId = apparatusId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserReceiveModel [apparatusId=" + apparatusId + ", remarks=" + remarks + ", time=" + time + "]";
	}


	
}
