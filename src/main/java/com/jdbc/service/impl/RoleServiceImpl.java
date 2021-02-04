package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.RoleDao;
import com.jdbc.model.RoleModel;
import com.jdbc.service.RoleService;

/** 
 * Description: [角色表服务实现]
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	/**
	 * <p>Discription:[角色表dao]</p>
	 */	
	@Resource
	private RoleDao roleDao;
	
	/**
	 * <p>Discription:[角色表数据分页查询]</p>
	 * @param page 角色表数据分页条件
	 * @param roleModel 角色表数据查询条件
	 * @param queryFields 角色表数据查询字段
	 * @return List<RoleModel>分页数据
	 *
	 */
	public List<RoleModel> queryPageRole(Page page,RoleModel roleModel,
			String queryFields){
			
		List<RoleModel> listRole = new ArrayList<RoleModel>();
		try{
			//判断参数是否为空
			if(Objects.isNull(page)){
				return null;
			}else{
				List<String> lis = new ArrayList<String>();
				if(Objects.isNull(queryFields)){
					lis = null;
				}else{
					lis = Arrays.asList(queryFields.split(","));
				}
				listRole = this.roleDao.queryPageRole(page,roleModel,lis);
			}
			long total = queryCountRole(roleModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listRole;
	}

	/**
	 * <p>Discription:[角色表数据不分页查询]</p>
	 * @param roleModel 角色表数据查询条件
	 * @param queryFields 角色表数据查询字段
	 * @return List<RoleModel>数据
	 *
	 */
	public List<RoleModel> queryListRole(RoleModel roleModel,String queryFields){
		List<RoleModel> listRole = new ArrayList<RoleModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listRole = this.roleDao.queryListRole(roleModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listRole;
	}

	/**
	 * <p>Discription:[角色表数据查询总条数]</p>
	 * @param roleModel 角色表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountRole(RoleModel roleModel){
		
		Long count = (long)0;
		try{
			count = this.roleDao.queryCountRole(roleModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询角色表数据]</p>
	 * @param id 角色表数据id
	 * @return RoleModel 单条数据
	 */
	public RoleModel queryRoleById(Long id){
		
		RoleModel model = new RoleModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.roleDao.queryRoleById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[角色表数据新增]</p>
	 * @param roleModel 角色表数据
	 * @return String 添加成功的id
	 */
	public int save(RoleModel roleModel){
		int count = 0;
		try{
			if(Objects.isNull(roleModel)){
				return 0;
			}else{
				count = this.roleDao.addRole(roleModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[角色表数据编辑]</p>
	 * @param roleModel 角色表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(RoleModel roleModel){
		Integer count = 0;
		try{
			if(Objects.isNull(roleModel) || Objects.isNull(roleModel.getId())){
				return 0;
			}else{
				count = this.roleDao.updateRole(roleModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[角色表数据删除]</p>
	 * @param id 角色表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeRoleById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.roleDao.removeRoleById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[角色表数据批量删除]</p>
	 * @param ids 角色表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeRoleByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.roleDao.removeRoleByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
