package com.jdbc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * Description: [入库信息表model]
 * </p>
 */
public class ApparatusModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 消防用品id
	 */
	private Integer id;
	/**
	 * 消防用品名称
	 */
	private String apparatusName;
	/**
	 * 品牌型号
	 */
	private String model;
	/**
	 * 进货价格
	 */
	private java.math.BigDecimal price;
	/**
	 * 供应商id
	 */
	private String vendorId;
	/**
	 * 入库时间
	 */
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date storageTime;
	/**
	 * 存放分类
	 */
	private String storageClassify;
	/**
	 * 存放位置
	 */
	private String location;
	/**
	 * 唯一标识号
	 */
	private String uin;
	/**
	 * 生产日期
	 */
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date productionDate;
	/**
	 * 维护类型
	 */
	private String mtype;
	/**
	 * 下次维护时间
	 */
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date nextMTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否被领用
	 */
	private String state;

	// setter and getter
	/**
	 * <p>
	 * Discription:[消防用品id]
	 * </p>
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * <p>
	 * Discription:[消防用品id]
	 * </p>
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Discription:[消防用品名称]
	 * </p>
	 */
	public String getApparatusName() {
		return apparatusName;
	}

	/**
	 * <p>
	 * Discription:[消防用品名称]
	 * </p>
	 */
	public void setApparatusName(String apparatusName) {
		this.apparatusName = apparatusName;
	}

	/**
	 * <p>
	 * Discription:[品牌型号]
	 * </p>
	 */
	public String getModel() {
		return model;
	}

	/**
	 * <p>
	 * Discription:[品牌型号]
	 * </p>
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * <p>
	 * Discription:[进货价格]
	 * </p>
	 */
	public java.math.BigDecimal getPrice() {
		return price;
	}

	/**
	 * <p>
	 * Discription:[进货价格]
	 * </p>
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	/**
	 * <p>
	 * Discription:[供应商id]
	 * </p>
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * <p>
	 * Discription:[供应商id]
	 * </p>
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * <p>
	 * Discription:[入库时间]
	 * </p>
	 */
	public String getStorageTime() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		if (storageTime != null)
			time = format1.format(storageTime);
		return time;
	}

	/**
	 * <p>
	 * Discription:[入库时间]
	 * </p>
	 */
	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}

	/**
	 * <p>
	 * Discription:[存放分类]
	 * </p>
	 */
	public String getStorageClassify() {
		return storageClassify;
	}

	/**
	 * <p>
	 * Discription:[存放分类]
	 * </p>
	 */
	public void setStorageClassify(String storageClassify) {
		this.storageClassify = storageClassify;
	}

	/**
	 * <p>
	 * Discription:[存放位置]
	 * </p>
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <p>
	 * Discription:[存放位置]
	 * </p>
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * <p>
	 * Discription:[唯一标识号]
	 * </p>
	 */
	public String getUin() {
		return uin;
	}

	/**
	 * <p>
	 * Discription:[唯一标识号]
	 * </p>
	 */
	public void setUin(String uin) {
		this.uin = uin;
	}

	/**
	 * <p>
	 * Discription:[生产日期]
	 * </p>
	 */
	public String getProductionDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		if (productionDate != null) {
			time = format1.format(productionDate);
		}
			
		return time;
	}

	/**
	 * <p>
	 * Discription:[生产日期]
	 * </p>
	 */
	public void setProductionDate(java.util.Date productionDate) {
		this.productionDate = productionDate;
	}

	 

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	/**
	 * <p>
	 * Discription:[下次维护时间]
	 * </p>
	 */
	public String getNextMTime() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = null;
		if (nextMTime != null)
			time = format1.format(nextMTime);
		return time;
	}

	/**
	 * <p>
	 * Discription:[下次维护时间]
	 * </p>
	 */
	public void setNextMTime(java.util.Date nextMTime) {
		this.nextMTime = nextMTime;
	}

	/**
	 * <p>
	 * Discription:[备注]
	 * </p>
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * <p>
	 * Discription:[备注]
	 * </p>
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * <p>
	 * Discription:[备注]
	 * </p>
	 */
	public String getState() {
		return state;
	}


	/**
	 * <p>
	 * Discription:[备注]
	 * </p>
	 */
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ApparatusModel [id=" + id + ", apparatusName=" + apparatusName + ", model=" + model + ", price=" + price
				+ ", vendorId=" + vendorId + ", storageTime=" + storageTime + ", storageClassify=" + storageClassify
				+ ", location=" + location + ", uin=" + uin + ", productionDate=" + productionDate + ", mType=" + mtype
				+ ", nextMTime=" + nextMTime + ", remark=" + remark + ", state=" + state+"]";
	}

}
