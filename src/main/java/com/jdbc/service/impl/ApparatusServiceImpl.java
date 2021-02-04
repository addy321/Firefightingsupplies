package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.ApparatusDao;
import com.jdbc.model.ApparatusModel;
import com.jdbc.service.ApparatusService;

/** 
 * Description: [入库信息表服务实现]
 */
@Service("apparatusService")
public class ApparatusServiceImpl implements ApparatusService {
	
	/**
	 * <p>Discription:[入库信息表dao]</p>
	 */	
	@Resource
	private ApparatusDao apparatusDao;
	
	/**
	 * <p>Discription:[入库信息表数据分页查询]</p>
	 * @param page 入库信息表数据分页条件
	 * @param apparatusModel 入库信息表数据查询条件
	 * @param queryFields 入库信息表数据查询字段
	 * @return List<ApparatusModel>分页数据
	 *
	 */
	public List<ApparatusModel> queryPageApparatus(Page page,ApparatusModel apparatusModel,
			String queryFields){
			
		List<ApparatusModel> listApparatus = new ArrayList<ApparatusModel>();
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
				listApparatus = this.apparatusDao.queryPageApparatus(page,apparatusModel,lis);
			}
			long total = queryCountApparatus(apparatusModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listApparatus;
	}

	/**
	 * <p>Discription:[入库信息表数据不分页查询]</p>
	 * @param apparatusModel 入库信息表数据查询条件
	 * @param queryFields 入库信息表数据查询字段
	 * @return List<ApparatusModel>数据
	 *
	 */
	public List<ApparatusModel> queryListApparatus(ApparatusModel apparatusModel,String queryFields){
		List<ApparatusModel> listApparatus = new ArrayList<ApparatusModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listApparatus = this.apparatusDao.queryListApparatus(apparatusModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listApparatus;
	}

	/**
	 * <p>Discription:[入库信息表数据查询总条数]</p>
	 * @param apparatusModel 入库信息表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountApparatus(ApparatusModel apparatusModel){
		
		Long count = (long)0;
		try{
			count = this.apparatusDao.queryCountApparatus(apparatusModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询入库信息表数据]</p>
	 * @param id 入库信息表数据id
	 * @return ApparatusModel 单条数据
	 */
	public ApparatusModel queryApparatusById(Long id){
		
		ApparatusModel model = new ApparatusModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.apparatusDao.queryApparatusById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[入库信息表数据新增]</p>
	 * @param apparatusModel 入库信息表数据
	 * @return String 添加成功的id
	 */
	public int save(ApparatusModel apparatusModel){
		int count = 0;
		try{
			if(Objects.isNull(apparatusModel)){
				return 0;
			}else{
				count = this.apparatusDao.addApparatus(apparatusModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[入库信息表数据编辑]</p>
	 * @param apparatusModel 入库信息表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(ApparatusModel apparatusModel){
		Integer count = 0;
		try{
			if(Objects.isNull(apparatusModel) || Objects.isNull(apparatusModel.getId())){
				return 0;
			}else{
				count = this.apparatusDao.updateApparatus(apparatusModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[入库信息表数据删除]</p>
	 * @param id 入库信息表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeApparatusById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.apparatusDao.removeApparatusById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[入库信息表数据批量删除]</p>
	 * @param ids 入库信息表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeApparatusByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.apparatusDao.removeApparatusByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
