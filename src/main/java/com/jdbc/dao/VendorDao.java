
package com.jdbc.dao;

import com.jdbc.model.VendorModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [供应商表dao]</p>
*/
public interface VendorDao{

	/**
	* 分页查询固定参数
	*/
	List<VendorModel> queryPageVendor(@Param("page")Page page, @Param("entity")VendorModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<VendorModel> queryListVendor(@Param("entity")VendorModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountVendor(@Param("entity")VendorModel entity);

	/**
	* 查询单个实体
	*/
	VendorModel queryVendorById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addVendor(VendorModel entity);

	/**
	* 修改
	*/
	int updateVendor(VendorModel entity);

	/**
	* 批量删除
	*/
	int removeVendorByIds(List code);

	/**
	* 删除
	*/
	int removeVendorById(@Param("id")Long id);
}