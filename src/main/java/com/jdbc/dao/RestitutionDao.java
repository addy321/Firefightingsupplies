
package com.jdbc.dao;

import com.jdbc.model.RestitutionModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [归还表dao]</p>
*/
public interface RestitutionDao{

	/**
	* 分页查询固定参数
	*/
	List<RestitutionModel> queryPageRestitution(@Param("page")Page page, @Param("entity")RestitutionModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<RestitutionModel> queryListRestitution(@Param("entity")RestitutionModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountRestitution(@Param("entity")RestitutionModel entity);

	/**
	* 查询单个实体
	*/
	RestitutionModel queryRestitutionById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addRestitution(RestitutionModel entity);

	/**
	* 修改
	*/
	int updateRestitution(RestitutionModel entity);

	/**
	* 批量删除
	*/
	int removeRestitutionByIds(List code);

	/**
	* 删除
	*/
	int removeRestitutionById(@Param("id")Long id);
}