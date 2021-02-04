package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.UserModel;

/**
 * Description: [用户表服务]
 */
public interface UserService {

	/**
	 * <p>Discription:[用户表数据分页查询]</p>
	 * @param pager 用户表数据分页条件
	 * @param userModel 用户表数据查询条件
	 * @param queryFields 用户表数据查询字段集合
	 * @return List<UserModel>分页数据
	 *
	 */
	 public	List<UserModel> queryPageUser(Page page, UserModel userModel, String queryFields);
	 
	 /**
	 * <p>Discription:[用户表数据不分页查询]</p>
	 * @param pager 用户表数据分页条件
	 * @param userModel 用户表数据查询条件
	 * @param queryFields 用户表数据查询字段集合
	 * @return List<UserModel>分页数据
	 *
	 */
	 public	List<UserModel> queryListUser(UserModel userModel, String queryFields);
	
	/**
	 * <p>Discription:[用户表数据查询总条数]</p>
	 * @param userModel 用户表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountUser(UserModel userModel);
	
	/**
	 * <p>Discription:[根据id查询用户表数据]</p>
	 * @param id 用户表数据id
	 * @return UserModel 单条数据
	 */
	public UserModel queryUserById(Long id);

	/**
	 * <p>Discription:[用户表数据新增]</p>
	 * @param userModel 用户表数据
	 * @return String 添加成功的id
	 */
	public int save(UserModel userModel);
	
	/**
	 * <p>Discription:[用户表数据编辑]</p>
	 * @param userModel 用户表数据
	 * @return 成功条数
	 */
	public int edit(UserModel userModel);
	
	/**
	 * <p>Discription:[用户表数据删除]</p>
	 * @param id 用户表数据id
	 * @return 成功条数
	 */
	public int removeUserById(Long id);
	
	/**
	 * <p>Discription:[用户表数据批量删除]</p>
	 * @param ids 用户表数据id的集合
	 * @return 成功条数
	 */
	public int removeUserByIds(String ids);
	
}
