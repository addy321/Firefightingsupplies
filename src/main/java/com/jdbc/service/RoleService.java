package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.RoleModel;

/**
 * Description: [角色表服务]
 */
public interface RoleService {

	/**
	 * <p>Discription:[角色表数据分页查询]</p>
	 * @param pager 角色表数据分页条件
	 * @param roleModel 角色表数据查询条件
	 * @param queryFields 角色表数据查询字段集合
	 * @return List<RoleModel>分页数据
	 *
	 */
	 public	List<RoleModel> queryPageRole(Page page, RoleModel roleModel, String queryFields);
	 
	 /**
	 * <p>Discription:[角色表数据不分页查询]</p>
	 * @param pager 角色表数据分页条件
	 * @param roleModel 角色表数据查询条件
	 * @param queryFields 角色表数据查询字段集合
	 * @return List<RoleModel>分页数据
	 *
	 */
	 public	List<RoleModel> queryListRole(RoleModel roleModel, String queryFields);
	
	/**
	 * <p>Discription:[角色表数据查询总条数]</p>
	 * @param roleModel 角色表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountRole(RoleModel roleModel);
	
	/**
	 * <p>Discription:[根据id查询角色表数据]</p>
	 * @param id 角色表数据id
	 * @return RoleModel 单条数据
	 */
	public RoleModel queryRoleById(Long id);

	/**
	 * <p>Discription:[角色表数据新增]</p>
	 * @param roleModel 角色表数据
	 * @return String 添加成功的id
	 */
	public int save(RoleModel roleModel);
	
	/**
	 * <p>Discription:[角色表数据编辑]</p>
	 * @param roleModel 角色表数据
	 * @return 成功条数
	 */
	public int edit(RoleModel roleModel);
	
	/**
	 * <p>Discription:[角色表数据删除]</p>
	 * @param id 角色表数据id
	 * @return 成功条数
	 */
	public int removeRoleById(Long id);
	
	/**
	 * <p>Discription:[角色表数据批量删除]</p>
	 * @param ids 角色表数据id的集合
	 * @return 成功条数
	 */
	public int removeRoleByIds(String ids);
	
}
