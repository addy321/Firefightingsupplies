package com.jdbc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
/** 
 * <p>Description: [部门表model]</p>
 */
public class DeptModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 部门名称
     */
	private String deptName;
	/**
     * 创建时间
     */

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
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
	* <p>Discription:[部门名称]</p>
    */
	public String getDeptName(){
		return deptName;
	}
	/**
	* <p>Discription:[部门名称]</p>
	*/
	public void setDeptName(String deptName){
		this.deptName = deptName;
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
		return "DeptModel [id=" + id + ", deptName=" + deptName + ", createTime=" + createTime + ", remark=" + remark
				+ "]";
	}
	
}
