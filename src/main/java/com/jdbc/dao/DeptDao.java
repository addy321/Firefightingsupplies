
package com.jdbc.dao;

import com.jdbc.model.DeptModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [部门表dao]</p>
*/
public interface DeptDao{

	/**
	* 分页查询固定参数
	*/
	List<DeptModel> queryPageDept(@Param("page")Page page, @Param("entity")DeptModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<DeptModel> queryListDept(@Param("entity")DeptModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountDept(@Param("entity")DeptModel entity);

	/**
	* 查询单个实体
	*/
	DeptModel queryDeptById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addDept(DeptModel entity);

	/**
	* 修改
	*/
	int updateDept(DeptModel entity);

	/**
	* 批量删除
	*/
	int removeDeptByIds(List code);

	/**
	* 删除
	*/
	int removeDeptById(@Param("id")Long id);
}