package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.PurviewModel;

/**
 * Description: [权限表服务]
 */
public interface PurviewService {

	/**
	 * <p>Discription:[权限表数据分页查询]</p>
	 * @param pager 权限表数据分页条件
	 * @param purviewModel 权限表数据查询条件
	 * @param queryFields 权限表数据查询字段集合
	 * @return List<PurviewModel>分页数据
	 *
	 */
	 public	List<PurviewModel> queryPagePurview(Page page, PurviewModel purviewModel, String queryFields);
	 
	 /**
	 * <p>Discription:[权限表数据不分页查询]</p>
	 * @param pager 权限表数据分页条件
	 * @param purviewModel 权限表数据查询条件
	 * @param queryFields 权限表数据查询字段集合
	 * @return List<PurviewModel>分页数据
	 *
	 */
	 public	List<PurviewModel> queryListPurview(PurviewModel purviewModel, String queryFields);
	
	/**
	 * <p>Discription:[权限表数据查询总条数]</p>
	 * @param purviewModel 权限表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountPurview(PurviewModel purviewModel);
	
	/**
	 * <p>Discription:[根据id查询权限表数据]</p>
	 * @param id 权限表数据id
	 * @return PurviewModel 单条数据
	 */
	public PurviewModel queryPurviewById(Long id);

	/**
	 * <p>Discription:[权限表数据新增]</p>
	 * @param purviewModel 权限表数据
	 * @return String 添加成功的id
	 */
	public int save(PurviewModel purviewModel);
	
	/**
	 * <p>Discription:[权限表数据编辑]</p>
	 * @param purviewModel 权限表数据
	 * @return 成功条数
	 */
	public int edit(PurviewModel purviewModel);
	
	/**
	 * <p>Discription:[权限表数据删除]</p>
	 * @param id 权限表数据id
	 * @return 成功条数
	 */
	public int removePurviewById(Long id);
	
	/**
	 * <p>Discription:[权限表数据批量删除]</p>
	 * @param ids 权限表数据id的集合
	 * @return 成功条数
	 */
	public int removePurviewByIds(String ids);
	
}
