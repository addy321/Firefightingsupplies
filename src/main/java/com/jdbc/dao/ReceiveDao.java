
package com.jdbc.dao;

import com.jdbc.model.ReceiveModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [领用表dao]</p>
*/
public interface ReceiveDao{

	/**
	* 分页查询固定参数
	*/
	List<ReceiveModel> queryPageReceive(@Param("page")Page page, @Param("entity")ReceiveModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<ReceiveModel> queryListReceive(@Param("entity")ReceiveModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountReceive(@Param("entity")ReceiveModel entity);

	/**
	* 查询单个实体
	*/
	ReceiveModel queryReceiveById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addReceive(ReceiveModel entity);

	/**
	* 修改
	*/
	int updateReceive(ReceiveModel entity);

	/**
	* 批量删除
	*/
	int removeReceiveByIds(List code);

	/**
	* 删除
	*/
	int removeReceiveById(@Param("id")Long id);
}