package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.UserDao;
import com.jdbc.model.UserModel;
import com.jdbc.service.UserService;

/** 
 * Description: [用户表服务实现]
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * <p>Discription:[用户表dao]</p>
	 */	
	@Resource
	private UserDao userDao;
	
	/**
	 * <p>Discription:[用户表数据分页查询]</p>
	 * @param page 用户表数据分页条件
	 * @param userModel 用户表数据查询条件
	 * @param queryFields 用户表数据查询字段
	 * @return List<UserModel>分页数据
	 *
	 */
	public List<UserModel> queryPageUser(Page page,UserModel userModel,
			String queryFields){
			
		List<UserModel> listUser = new ArrayList<UserModel>();
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
				listUser = this.userDao.queryPageUser(page,userModel,lis);
			}
			long total = queryCountUser(userModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listUser;
	}

	/**
	 * <p>Discription:[用户表数据不分页查询]</p>
	 * @param userModel 用户表数据查询条件
	 * @param queryFields 用户表数据查询字段
	 * @return List<UserModel>数据
	 *
	 */
	public List<UserModel> queryListUser(UserModel userModel,String queryFields){
		List<UserModel> listUser = new ArrayList<UserModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listUser = this.userDao.queryListUser(userModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listUser;
	}

	/**
	 * <p>Discription:[用户表数据查询总条数]</p>
	 * @param userModel 用户表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountUser(UserModel userModel){
		
		Long count = (long)0;
		try{
			count = this.userDao.queryCountUser(userModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询用户表数据]</p>
	 * @param id 用户表数据id
	 * @return UserModel 单条数据
	 */
	public UserModel queryUserById(Long id){
		
		UserModel model = new UserModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.userDao.queryUserById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[用户表数据新增]</p>
	 * @param userModel 用户表数据
	 * @return String 添加成功的id
	 */
	public int save(UserModel userModel){
		int count = 0;
		try{
			if(Objects.isNull(userModel)){
				return 0;
			}else{
				count = this.userDao.addUser(userModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[用户表数据编辑]</p>
	 * @param userModel 用户表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(UserModel userModel){
		Integer count = 0;
		try{
			if(Objects.isNull(userModel) || Objects.isNull(userModel.getId())){
				return 0;
			}else{
				count = this.userDao.updateUser(userModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[用户表数据删除]</p>
	 * @param id 用户表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeUserById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.userDao.removeUserById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[用户表数据批量删除]</p>
	 * @param ids 用户表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeUserByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.userDao.removeUserByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
