
package com.jdbc.dao;

import com.jdbc.model.PurviewModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [权限表dao]</p>
*/
public interface PurviewDao{

	/**
	* 分页查询固定参数
	*/
	List<PurviewModel> queryPagePurview(@Param("page")Page page, @Param("entity")PurviewModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<PurviewModel> queryListPurview(@Param("entity")PurviewModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountPurview(@Param("entity")PurviewModel entity);

	/**
	* 查询单个实体
	*/
	PurviewModel queryPurviewById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addPurview(PurviewModel entity);

	/**
	* 修改
	*/
	int updatePurview(PurviewModel entity);

	/**
	* 批量删除
	*/
	int removePurviewByIds(List code);

	/**
	* 删除
	*/
	int removePurviewById(@Param("id")Long id);
}