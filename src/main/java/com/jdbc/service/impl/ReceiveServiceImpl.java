package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.ReceiveDao;
import com.jdbc.model.ReceiveModel;
import com.jdbc.service.ReceiveService;

/** 
 * Description: [领用表服务实现]
 */
@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {
	
	/**
	 * <p>Discription:[领用表dao]</p>
	 */	
	@Resource
	private ReceiveDao receiveDao;
	
	/**
	 * <p>Discription:[领用表数据分页查询]</p>
	 * @param page 领用表数据分页条件
	 * @param receiveModel 领用表数据查询条件
	 * @param queryFields 领用表数据查询字段
	 * @return List<ReceiveModel>分页数据
	 *
	 */
	public List<ReceiveModel> queryPageReceive(Page page,ReceiveModel receiveModel,
			String queryFields){
			
		List<ReceiveModel> listReceive = new ArrayList<ReceiveModel>();
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
				listReceive = this.receiveDao.queryPageReceive(page,receiveModel,lis);
			}
			long total = queryCountReceive(receiveModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listReceive;
	}

	/**
	 * <p>Discription:[领用表数据不分页查询]</p>
	 * @param receiveModel 领用表数据查询条件
	 * @param queryFields 领用表数据查询字段
	 * @return List<ReceiveModel>数据
	 *
	 */
	public List<ReceiveModel> queryListReceive(ReceiveModel receiveModel,String queryFields){
		List<ReceiveModel> listReceive = new ArrayList<ReceiveModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listReceive = this.receiveDao.queryListReceive(receiveModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listReceive;
	}

	/**
	 * <p>Discription:[领用表数据查询总条数]</p>
	 * @param receiveModel 领用表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountReceive(ReceiveModel receiveModel){
		
		Long count = (long)0;
		try{
			count = this.receiveDao.queryCountReceive(receiveModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询领用表数据]</p>
	 * @param id 领用表数据id
	 * @return ReceiveModel 单条数据
	 */
	public ReceiveModel queryReceiveById(Long id){
		
		ReceiveModel model = new ReceiveModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.receiveDao.queryReceiveById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[领用表数据新增]</p>
	 * @param receiveModel 领用表数据
	 * @return String 添加成功的id
	 */
	public int save(ReceiveModel receiveModel){
		int count = 0;
		try{
			if(Objects.isNull(receiveModel)){
				return 0;
			}else{
				count = this.receiveDao.addReceive(receiveModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[领用表数据编辑]</p>
	 * @param receiveModel 领用表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(ReceiveModel receiveModel){
		Integer count = 0;
		try{
			if(Objects.isNull(receiveModel) || Objects.isNull(receiveModel.getId())){
				return 0;
			}else{
				count = this.receiveDao.updateReceive(receiveModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[领用表数据删除]</p>
	 * @param id 领用表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeReceiveById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.receiveDao.removeReceiveById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[领用表数据批量删除]</p>
	 * @param ids 领用表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeReceiveByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.receiveDao.removeReceiveByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
