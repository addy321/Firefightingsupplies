package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.RestitutionModel;

/**
 * Description: [归还表服务]
 */
public interface RestitutionService {

	/**
	 * <p>Discription:[归还表数据分页查询]</p>
	 * @param pager 归还表数据分页条件
	 * @param restitutionModel 归还表数据查询条件
	 * @param queryFields 归还表数据查询字段集合
	 * @return List<RestitutionModel>分页数据
	 *
	 */
	 public	List<RestitutionModel> queryPageRestitution(Page page, RestitutionModel restitutionModel, String queryFields);
	 
	 /**
	 * <p>Discription:[归还表数据不分页查询]</p>
	 * @param pager 归还表数据分页条件
	 * @param restitutionModel 归还表数据查询条件
	 * @param queryFields 归还表数据查询字段集合
	 * @return List<RestitutionModel>分页数据
	 *
	 */
	 public	List<RestitutionModel> queryListRestitution(RestitutionModel restitutionModel, String queryFields);
	
	/**
	 * <p>Discription:[归还表数据查询总条数]</p>
	 * @param restitutionModel 归还表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountRestitution(RestitutionModel restitutionModel);
	
	/**
	 * <p>Discription:[根据id查询归还表数据]</p>
	 * @param id 归还表数据id
	 * @return RestitutionModel 单条数据
	 */
	public RestitutionModel queryRestitutionById(Long id);

	/**
	 * <p>Discription:[归还表数据新增]</p>
	 * @param restitutionModel 归还表数据
	 * @return String 添加成功的id
	 */
	public int save(RestitutionModel restitutionModel);
	
	/**
	 * <p>Discription:[归还表数据编辑]</p>
	 * @param restitutionModel 归还表数据
	 * @return 成功条数
	 */
	public int edit(RestitutionModel restitutionModel);
	
	/**
	 * <p>Discription:[归还表数据删除]</p>
	 * @param id 归还表数据id
	 * @return 成功条数
	 */
	public int removeRestitutionById(Long id);
	
	/**
	 * <p>Discription:[归还表数据批量删除]</p>
	 * @param ids 归还表数据id的集合
	 * @return 成功条数
	 */
	public int removeRestitutionByIds(String ids);
	
}
