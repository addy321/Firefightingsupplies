package com.jdbc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/** 
 * <p>Description: [领用表model]</p>
 */

public class ReceiveModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 领用的消防用品id
     */
	private Integer apparatusId;
	/**
     * 领用用户id
     */
	private Integer userId;
	/**
     * 领用时间
     */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date receiveTime;
	/**
     * 约定归还时间
     */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date returnTime;
	/**
     * 创建时间
     */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
	* <p>Discription:[领用的消防用品id]</p>
    */
	public Integer getApparatusId(){
		return apparatusId;
	}
	/**
	* <p>Discription:[领用的消防用品id]</p>
	*/
	public void setApparatusId(Integer apparatusId){
		this.apparatusId = apparatusId;
	}
	/**
	* <p>Discription:[领用用户id]</p>
    */
	public Integer getUserId(){
		return userId;
	}
	/**
	* <p>Discription:[领用用户id]</p>
	*/
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	/**
	* <p>Discription:[领用时间]</p>
    */
	public String getReceiveTime(){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		if (receiveTime != null)
			time = format1.format(receiveTime);
		return time;
	}
	/**
	* <p>Discription:[领用时间]</p>
	*/
	public void setReceiveTime(java.util.Date receiveTime){
		this.receiveTime = receiveTime;
	}
	/**
	* <p>Discription:[约定归还时间]</p>
    */
	public String getReturnTime(){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		if (returnTime != null)
			time = format1.format(returnTime);
		return time;
	}
	/**
	* <p>Discription:[约定归还时间]</p>
	*/
	public void setReturnTime(java.util.Date returnTime){
		this.returnTime = returnTime;
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
	@Override
	public String toString() {
		return "ReceiveModel [id=" + id + ", apparatusId=" + apparatusId + ", userId=" + userId + ", receiveTime="
				+ receiveTime + ", returnTime=" + returnTime + ", createTime=" + createTime + ", remark=" + remark
				+ "]";
	}
}
