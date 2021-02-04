package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.PurviewDao;
import com.jdbc.model.PurviewModel;
import com.jdbc.service.PurviewService;

/** 
 * Description: [权限表服务实现]
 */
@Service("purviewService")
public class PurviewServiceImpl implements PurviewService {
	
	/**
	 * <p>Discription:[权限表dao]</p>
	 */	
	@Resource
	private PurviewDao purviewDao;
	
	/**
	 * <p>Discription:[权限表数据分页查询]</p>
	 * @param page 权限表数据分页条件
	 * @param purviewModel 权限表数据查询条件
	 * @param queryFields 权限表数据查询字段
	 * @return List<PurviewModel>分页数据
	 *
	 */
	public List<PurviewModel> queryPagePurview(Page page,PurviewModel purviewModel,
			String queryFields){
			
		List<PurviewModel> listPurview = new ArrayList<PurviewModel>();
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
				listPurview = this.purviewDao.queryPagePurview(page,purviewModel,lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listPurview;
	}

	/**
	 * <p>Discription:[权限表数据不分页查询]</p>
	 * @param purviewModel 权限表数据查询条件
	 * @param queryFields 权限表数据查询字段
	 * @return List<PurviewModel>数据
	 *
	 */
	public List<PurviewModel> queryListPurview(PurviewModel purviewModel,String queryFields){
		List<PurviewModel> listPurview = new ArrayList<PurviewModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listPurview = this.purviewDao.queryListPurview(purviewModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listPurview;
	}

	/**
	 * <p>Discription:[权限表数据查询总条数]</p>
	 * @param purviewModel 权限表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountPurview(PurviewModel purviewModel){
		
		Long count = (long)0;
		try{
			count = this.purviewDao.queryCountPurview(purviewModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询权限表数据]</p>
	 * @param id 权限表数据id
	 * @return PurviewModel 单条数据
	 */
	public PurviewModel queryPurviewById(Long id){
		
		PurviewModel model = new PurviewModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.purviewDao.queryPurviewById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[权限表数据新增]</p>
	 * @param purviewModel 权限表数据
	 * @return String 添加成功的id
	 */
	public int save(PurviewModel purviewModel){
		int count = 0;
		try{
			if(Objects.isNull(purviewModel)){
				return 0;
			}else{
				count = this.purviewDao.addPurview(purviewModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[权限表数据编辑]</p>
	 * @param purviewModel 权限表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(PurviewModel purviewModel){
		Integer count = 0;
		try{
			if(Objects.isNull(purviewModel) || Objects.isNull(purviewModel.getId())){
				return 0;
			}else{
				count = this.purviewDao.updatePurview(purviewModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[权限表数据删除]</p>
	 * @param id 权限表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removePurviewById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.purviewDao.removePurviewById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[权限表数据批量删除]</p>
	 * @param ids 权限表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removePurviewByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.purviewDao.removePurviewByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
