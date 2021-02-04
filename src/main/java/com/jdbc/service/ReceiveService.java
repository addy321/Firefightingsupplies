package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.ReceiveModel;

/**
 * Description: [领用表服务]
 */
public interface ReceiveService {

	/**
	 * <p>Discription:[领用表数据分页查询]</p>
	 * @param pager 领用表数据分页条件
	 * @param receiveModel 领用表数据查询条件
	 * @param queryFields 领用表数据查询字段集合
	 * @return List<ReceiveModel>分页数据
	 *
	 */
	 public	List<ReceiveModel> queryPageReceive(Page page, ReceiveModel receiveModel, String queryFields);
	 
	 /**
	 * <p>Discription:[领用表数据不分页查询]</p>
	 * @param pager 领用表数据分页条件
	 * @param receiveModel 领用表数据查询条件
	 * @param queryFields 领用表数据查询字段集合
	 * @return List<ReceiveModel>分页数据
	 *
	 */
	 public	List<ReceiveModel> queryListReceive(ReceiveModel receiveModel, String queryFields);
	
	/**
	 * <p>Discription:[领用表数据查询总条数]</p>
	 * @param receiveModel 领用表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountReceive(ReceiveModel receiveModel);
	
	/**
	 * <p>Discription:[根据id查询领用表数据]</p>
	 * @param id 领用表数据id
	 * @return ReceiveModel 单条数据
	 */
	public ReceiveModel queryReceiveById(Long id);

	/**
	 * <p>Discription:[领用表数据新增]</p>
	 * @param receiveModel 领用表数据
	 * @return String 添加成功的id
	 */
	public int save(ReceiveModel receiveModel);
	
	/**
	 * <p>Discription:[领用表数据编辑]</p>
	 * @param receiveModel 领用表数据
	 * @return 成功条数
	 */
	public int edit(ReceiveModel receiveModel);
	
	/**
	 * <p>Discription:[领用表数据删除]</p>
	 * @param id 领用表数据id
	 * @return 成功条数
	 */
	public int removeReceiveById(Long id);
	
	/**
	 * <p>Discription:[领用表数据批量删除]</p>
	 * @param ids 领用表数据id的集合
	 * @return 成功条数
	 */
	public int removeReceiveByIds(String ids);
	
}
