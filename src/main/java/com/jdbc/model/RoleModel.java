package com.jdbc.model;

import java.io.Serializable;
/** 
 * <p>Description: [角色表model]</p>
 */
public class RoleModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 角色名称
     */
	private String roleName;
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
	* <p>Discription:[角色名称]</p>
    */
	public String getRoleName(){
		return roleName;
	}
	/**
	* <p>Discription:[角色名称]</p>
	*/
	public void setRoleName(String roleName){
		this.roleName = roleName;
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
		return "RoleModel [id=" + id + ", roleName=" + roleName + ", remark=" + remark + "]";
	}
	
}
