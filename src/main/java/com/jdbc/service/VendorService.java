package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.VendorModel;

/**
 * Description: [供应商表服务]
 */
public interface VendorService {

	/**
	 * <p>Discription:[供应商表数据分页查询]</p>
	 * @param pager 供应商表数据分页条件
	 * @param vendorModel 供应商表数据查询条件
	 * @param queryFields 供应商表数据查询字段集合
	 * @return List<VendorModel>分页数据
	 *
	 */
	 public	List<VendorModel> queryPageVendor(Page page, VendorModel vendorModel, String queryFields);
	 
	 /**
	 * <p>Discription:[供应商表数据不分页查询]</p>
	 * @param pager 供应商表数据分页条件
	 * @param vendorModel 供应商表数据查询条件
	 * @param queryFields 供应商表数据查询字段集合
	 * @return List<VendorModel>分页数据
	 *
	 */
	 public	List<VendorModel> queryListVendor(VendorModel vendorModel, String queryFields);
	
	/**
	 * <p>Discription:[供应商表数据查询总条数]</p>
	 * @param vendorModel 供应商表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountVendor(VendorModel vendorModel);
	
	/**
	 * <p>Discription:[根据id查询供应商表数据]</p>
	 * @param id 供应商表数据id
	 * @return VendorModel 单条数据
	 */
	public VendorModel queryVendorById(Long id);

	/**
	 * <p>Discription:[供应商表数据新增]</p>
	 * @param vendorModel 供应商表数据
	 * @return String 添加成功的id
	 */
	public int save(VendorModel vendorModel);
	
	/**
	 * <p>Discription:[供应商表数据编辑]</p>
	 * @param vendorModel 供应商表数据
	 * @return 成功条数
	 */
	public int edit(VendorModel vendorModel);
	
	/**
	 * <p>Discription:[供应商表数据删除]</p>
	 * @param id 供应商表数据id
	 * @return 成功条数
	 */
	public int removeVendorById(Long id);
	
	/**
	 * <p>Discription:[供应商表数据批量删除]</p>
	 * @param ids 供应商表数据id的集合
	 * @return 成功条数
	 */
	public int removeVendorByIds(String ids);
	
}
