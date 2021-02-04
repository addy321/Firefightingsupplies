
package com.jdbc.dao;

import com.jdbc.model.ApparatusModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [入库信息表dao]</p>
*/
public interface ApparatusDao{

	/**
	* 分页查询固定参数
	*/
	List<ApparatusModel> queryPageApparatus(@Param("page")Page page, @Param("entity")ApparatusModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<ApparatusModel> queryListApparatus(@Param("entity")ApparatusModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountApparatus(@Param("entity")ApparatusModel entity);

	/**
	* 查询单个实体
	*/
	ApparatusModel queryApparatusById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addApparatus(ApparatusModel entity);

	/**
	* 修改
	*/
	int updateApparatus(ApparatusModel entity);

	/**
	* 批量删除
	*/
	int removeApparatusByIds(List code);

	/**
	* 删除
	*/
	int removeApparatusById(@Param("id")Long id);
}