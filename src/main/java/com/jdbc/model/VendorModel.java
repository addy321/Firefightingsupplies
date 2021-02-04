package com.jdbc.model;

import java.io.Serializable;
/** 
 * <p>Description: [供应商表model]</p>
 */
public class VendorModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * id
     */
	private Integer id;
	/**
     * 供应商名称
     */
	private String vendorName;
	/**
     * 地址
     */
	private String vendorAddress;
	/**
     * 联系人
     */
	private String contact;
	/**
     * 联系电话
     */
	private String phone;
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
	* <p>Discription:[供应商名称]</p>
    */
	public String getVendorName(){
		return vendorName;
	}
	/**
	* <p>Discription:[供应商名称]</p>
	*/
	public void setVendorName(String vendorName){
		this.vendorName = vendorName;
	}
	/**
	* <p>Discription:[地址]</p>
    */
	public String getVendorAddress(){
		return vendorAddress;
	}
	/**
	* <p>Discription:[地址]</p>
	*/
	public void setVendorAddress(String vendorAddress){
		this.vendorAddress = vendorAddress;
	}
	/**
	* <p>Discription:[联系人]</p>
    */
	public String getContact(){
		return contact;
	}
	/**
	* <p>Discription:[联系人]</p>
	*/
	public void setContact(String contact){
		this.contact = contact;
	}
	/**
	* <p>Discription:[联系电话]</p>
    */
	public String getPhone(){
		return phone;
	}
	/**
	* <p>Discription:[联系电话]</p>
	*/
	public void setPhone(String phone){
		this.phone = phone;
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
	public void setRemark(String desc){
		this.remark = desc;
	}
}
