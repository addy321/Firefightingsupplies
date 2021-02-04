package com.jdbc.model;

import java.io.Serializable;
/** 
 * <p>Description: [用户表model]</p>
 */
public class UserModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 用户姓名
     */
	private String userName;
	/**
     * 部门id
     */
	private Integer deptId;
	/**
     * 角色id
     */
	private Integer roleId;
	/**
     * 员工编号
     */
	private Integer employeeId;
	/**
     * 登录名
     */
	private String loginName;
	/**
     * 登录密码
     */
	private String password;
	/**
     * 手机号
     */
	private String mobile;
	/**
     * 邮箱
     */
	private String email;
	
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
	* <p>Discription:[用户姓名]</p>
    */
	public String getUserName(){
		return userName;
	}
	/**
	* <p>Discription:[用户姓名]</p>
	*/
	public void setUserName(String userName){
		this.userName = userName;
	}
	/**
	* <p>Discription:[部门id]</p>
    */
	public Integer getDeptId(){
		return deptId;
	}
	/**
	* <p>Discription:[部门id]</p>
	*/
	public void setDeptId(Integer deptId){
		this.deptId = deptId;
	}
	/**
	* <p>Discription:[角色id]</p>
    */
	public Integer getRoleId(){
		return roleId;
	}
	/**
	* <p>Discription:[角色id]</p>
	*/
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	/**
	* <p>Discription:[员工编号]</p>
    */
	public Integer getEmployeeId(){
		return employeeId;
	}
	/**
	* <p>Discription:[员工编号]</p>
	*/
	public void setEmployeeId(Integer employeeId){
		this.employeeId = employeeId;
	}
	/**
	* <p>Discription:[登录名]</p>
    */
	public String getLoginName(){
		return loginName;
	}
	/**
	* <p>Discription:[登录名]</p>
	*/
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	/**
	* <p>Discription:[登录密码]</p>
    */
	public String getPassword(){
		return password;
	}
	/**
	* <p>Discription:[登录密码]</p>
	*/
	public void setPassword(String password){
		this.password = password;
	}
	/**
	* <p>Discription:[手机号]</p>
    */
	public String getMobile(){
		return mobile;
	}
	/**
	* <p>Discription:[手机号]</p>
	*/
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	/**
	* <p>Discription:[邮箱]</p>
    */
	public String getEmail(){
		return email;
	}
	/**
	* <p>Discription:[邮箱]</p>
	*/
	public void setEmail(String email){
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", deptId=" + deptId + ", roleId=" + roleId
				+ ", employeeId=" + employeeId + ", loginName=" + loginName + ", password=" + password + ", mobile="
				+ mobile + ", email=" + email + "]";
	}
}
