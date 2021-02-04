
package com.jdbc.dao;

import com.jdbc.model.RoleModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [角色表dao]</p>
*/
public interface RoleDao{

	/**
	* 分页查询固定参数
	*/
	List<RoleModel> queryPageRole(@Param("page")Page page, @Param("entity")RoleModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<RoleModel> queryListRole(@Param("entity")RoleModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountRole(@Param("entity")RoleModel entity);

	/**
	* 查询单个实体
	*/
	RoleModel queryRoleById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addRole(RoleModel entity);

	/**
	* 修改
	*/
	int updateRole(RoleModel entity);

	/**
	* 批量删除
	*/
	int removeRoleByIds(List code);

	/**
	* 删除
	*/
	int removeRoleById(@Param("id")Long id);
}