package com.jdbc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/** 
 * <p>Description: [归还表model]</p>
 */
public class RestitutionModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 领用id
     */
	private Integer receiveId;
	/**
     * 实际归还时间
     */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date returnTime;
	/**
     * 归还状态
     */
	private Integer state;
	/**
     * 创建时间
     */
	private java.util.Date createTime;
	/**
     * 备注
     */
	private String remark;
	
	// setter and getter
	/**
	* <p>Discription:[id]</p>
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[id]</p>
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[领用id]</p>
    */
	public Integer getReceiveId(){
		return receiveId;
	}
	/**
	* <p>Discription:[领用id]</p>
	*/
	public void setReceiveId(Integer receiveId){
		this.receiveId = receiveId;
	}
	/**
	* <p>Discription:[实际归还时间]</p>
    */
	public String getReturnTime(){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		if (returnTime != null)
			time = format1.format(returnTime);
		return time;
	}
	/**
	* <p>Discription:[实际归还时间]</p>
	*/
	public void setReturnTime(java.util.Date returnTime){
		this.returnTime = returnTime;
	}
	/**
	* <p>Discription:[归还状态]</p>
    */
	public Integer getState(){
		return state;
	}
	/**
	* <p>Discription:[归还状态]</p>
	*/
	public void setState(Integer state){
		this.state = state;
	}
	/**
	* <p>Discription:[创建时间]</p>
    */
	public String getCreateTime(){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		if (createTime != null)
			time = format1.format(createTime);
		return time;
	}
	/**
	* <p>Discription:[创建时间]</p>
	*/
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	* <p>Discription:[备注]</p>
    */
	public String getRemark(){
		return remark;
	}
	/**
	* <p>Discription:[备注]</p>
	*/
	public void setRemark(String remark){
		this.remark = remark;
	}
}
