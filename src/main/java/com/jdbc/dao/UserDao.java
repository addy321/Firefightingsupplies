
package com.jdbc.dao;

import com.jdbc.model.UserModel;
import com.jdbc.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* <p>Description: [用户表dao]</p>
*/
public interface UserDao{

	/**
	* 分页查询固定参数
	*/
	List<UserModel> queryPageUser(@Param("page")Page page, @Param("entity")UserModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询固定参数
	*/
	List<UserModel> queryListUser(@Param("entity")UserModel entity, @Param("queryFields")List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountUser(@Param("entity")UserModel entity);

	/**
	* 查询单个实体
	*/
	UserModel queryUserById(@Param("id")Long id,  @Param("queryFields")List queryFields);

	/**
	* 新增
	*/
	int addUser(UserModel entity);

	/**
	* 修改
	*/
	int updateUser(UserModel entity);

	/**
	* 批量删除
	*/
	int removeUserByIds(List code);

	/**
	* 删除
	*/
	int removeUserById(@Param("id")Long id);
}