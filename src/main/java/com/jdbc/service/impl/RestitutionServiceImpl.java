package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.RestitutionDao;
import com.jdbc.model.RestitutionModel;
import com.jdbc.service.RestitutionService;

/** 
 * Description: [归还表服务实现]
 */
@Service("restitutionService")
public class RestitutionServiceImpl implements RestitutionService {
	
	/**
	 * <p>Discription:[归还表dao]</p>
	 */	
	@Resource
	private RestitutionDao restitutionDao;
	
	/**
	 * <p>Discription:[归还表数据分页查询]</p>
	 * @param page 归还表数据分页条件
	 * @param restitutionModel 归还表数据查询条件
	 * @param queryFields 归还表数据查询字段
	 * @return List<RestitutionModel>分页数据
	 *
	 */
	public List<RestitutionModel> queryPageRestitution(Page page,RestitutionModel restitutionModel,
			String queryFields){
			
		List<RestitutionModel> listRestitution = new ArrayList<RestitutionModel>();
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
				listRestitution = this.restitutionDao.queryPageRestitution(page,restitutionModel,lis);
			}
			long total = queryCountRestitution(restitutionModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listRestitution;
	}

	/**
	 * <p>Discription:[归还表数据不分页查询]</p>
	 * @param restitutionModel 归还表数据查询条件
	 * @param queryFields 归还表数据查询字段
	 * @return List<RestitutionModel>数据
	 *
	 */
	public List<RestitutionModel> queryListRestitution(RestitutionModel restitutionModel,String queryFields){
		List<RestitutionModel> listRestitution = new ArrayList<RestitutionModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listRestitution = this.restitutionDao.queryListRestitution(restitutionModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listRestitution;
	}

	/**
	 * <p>Discription:[归还表数据查询总条数]</p>
	 * @param restitutionModel 归还表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountRestitution(RestitutionModel restitutionModel){
		
		Long count = (long)0;
		try{
			count = this.restitutionDao.queryCountRestitution(restitutionModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询归还表数据]</p>
	 * @param id 归还表数据id
	 * @return RestitutionModel 单条数据
	 */
	public RestitutionModel queryRestitutionById(Long id){
		
		RestitutionModel model = new RestitutionModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.restitutionDao.queryRestitutionById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[归还表数据新增]</p>
	 * @param restitutionModel 归还表数据
	 * @return String 添加成功的id
	 */
	public int save(RestitutionModel restitutionModel){
		int count = 0;
		try{
			if(Objects.isNull(restitutionModel)){
				return 0;
			}else{
				count = this.restitutionDao.addRestitution(restitutionModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[归还表数据编辑]</p>
	 * @param restitutionModel 归还表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(RestitutionModel restitutionModel){
		Integer count = 0;
		try{
			if(Objects.isNull(restitutionModel) || Objects.isNull(restitutionModel.getId())){
				return 0;
			}else{
				count = this.restitutionDao.updateRestitution(restitutionModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[归还表数据删除]</p>
	 * @param id 归还表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeRestitutionById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.restitutionDao.removeRestitutionById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[归还表数据批量删除]</p>
	 * @param ids 归还表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeRestitutionByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.restitutionDao.removeRestitutionByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
