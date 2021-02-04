package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.DeptDao;
import com.jdbc.model.DeptModel;
import com.jdbc.service.DeptService;

/** 
 * Description: [部门表服务实现]
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	/**
	 * <p>Discription:[部门表dao]</p>
	 */	
	@Resource
	private DeptDao deptDao;
	
	/**
	 * <p>Discription:[部门表数据分页查询]</p>
	 * @param page 部门表数据分页条件
	 * @param deptModel 部门表数据查询条件
	 * @param queryFields 部门表数据查询字段
	 * @return List<DeptModel>分页数据
	 *
	 */
	public List<DeptModel> queryPageDept(Page page,DeptModel deptModel,
			String queryFields){
			
		List<DeptModel> listDept = new ArrayList<DeptModel>();
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
				listDept = this.deptDao.queryPageDept(page,deptModel,lis);
			}
			long total = queryCountDept(deptModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listDept;
	}

	/**
	 * <p>Discription:[部门表数据不分页查询]</p>
	 * @param deptModel 部门表数据查询条件
	 * @param queryFields 部门表数据查询字段
	 * @return List<DeptModel>数据
	 *
	 */
	public List<DeptModel> queryListDept(DeptModel deptModel,String queryFields){
		List<DeptModel> listDept = new ArrayList<DeptModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listDept = this.deptDao.queryListDept(deptModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listDept;
	}

	/**
	 * <p>Discription:[部门表数据查询总条数]</p>
	 * @param deptModel 部门表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountDept(DeptModel deptModel){
		
		Long count = (long)0;
		try{
			count = this.deptDao.queryCountDept(deptModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询部门表数据]</p>
	 * @param id 部门表数据id
	 * @return DeptModel 单条数据
	 */
	public DeptModel queryDeptById(Long id){
		
		DeptModel model = new DeptModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.deptDao.queryDeptById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[部门表数据新增]</p>
	 * @param deptModel 部门表数据
	 * @return String 添加成功的id
	 */
	public int save(DeptModel deptModel){
		int count = 0;
		try{
			if(Objects.isNull(deptModel)){
				return 0;
			}else{
				count = this.deptDao.addDept(deptModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[部门表数据编辑]</p>
	 * @param deptModel 部门表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(DeptModel deptModel){
		Integer count = 0;
		try{
			if(Objects.isNull(deptModel) || Objects.isNull(deptModel.getId())){
				return 0;
			}else{
				count = this.deptDao.updateDept(deptModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[部门表数据删除]</p>
	 * @param id 部门表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeDeptById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.deptDao.removeDeptById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[部门表数据批量删除]</p>
	 * @param ids 部门表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeDeptByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.deptDao.removeDeptByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
