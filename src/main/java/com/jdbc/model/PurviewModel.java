package com.jdbc.model;

import java.io.Serializable;
/** 
 * <p>Description: [权限表model]</p>
 */
public class PurviewModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 角色id
     */
	private Integer roleid;
	/**
     * 跳转路径
     */
	private String askurl;
	
	/**
     * 菜单名称
     */
	private String menuname;
	
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
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
	* <p>Discription:[角色id]</p>
    */
	public Integer getRoleid(){
		return roleid;
	}
	/**
	* <p>Discription:[角色id]</p>
	*/
	public void setRoleid(Integer roleid){
		this.roleid = roleid;
	}
	/**
	* <p>Discription:[跳转路径]</p>
    */
	public String getAskurl(){
		return askurl;
	}
	/**
	* <p>Discription:[跳转路径]</p>
	*/
	public void setAskurl(String askurl){
		this.askurl = askurl;
	}
}
