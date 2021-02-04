package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.jdbc.model.ApparatusModel;

/**
 * Description: [入库信息表服务]
 */
public interface ApparatusService {

	/**
	 * <p>Discription:[入库信息表数据分页查询]</p>
	 * @param pager 入库信息表数据分页条件
	 * @param apparatusModel 入库信息表数据查询条件
	 * @param queryFields 入库信息表数据查询字段集合
	 * @return List<ApparatusModel>分页数据
	 *
	 */
	 public	List<ApparatusModel> queryPageApparatus(Page page, ApparatusModel apparatusModel, String queryFields);
	 
	 /**
	 * <p>Discription:[入库信息表数据不分页查询]</p>
	 * @param pager 入库信息表数据分页条件
	 * @param apparatusModel 入库信息表数据查询条件
	 * @param queryFields 入库信息表数据查询字段集合
	 * @return List<ApparatusModel>分页数据
	 *
	 */
	 public	List<ApparatusModel> queryListApparatus(ApparatusModel apparatusModel, String queryFields);
	
	/**
	 * <p>Discription:[入库信息表数据查询总条数]</p>
	 * @param apparatusModel 入库信息表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountApparatus(ApparatusModel apparatusModel);
	
	/**
	 * <p>Discription:[根据id查询入库信息表数据]</p>
	 * @param id 入库信息表数据id
	 * @return ApparatusModel 单条数据
	 */
	public ApparatusModel queryApparatusById(Long id);

	/**
	 * <p>Discription:[入库信息表数据新增]</p>
	 * @param apparatusModel 入库信息表数据
	 * @return String 添加成功的id
	 */
	public int save(ApparatusModel apparatusModel);
	
	/**
	 * <p>Discription:[入库信息表数据编辑]</p>
	 * @param apparatusModel 入库信息表数据
	 * @return 成功条数
	 */
	public int edit(ApparatusModel apparatusModel);
	
	/**
	 * <p>Discription:[入库信息表数据删除]</p>
	 * @param id 入库信息表数据id
	 * @return 成功条数
	 */
	public int removeApparatusById(Long id);
	
	/**
	 * <p>Discription:[入库信息表数据批量删除]</p>
	 * @param ids 入库信息表数据id的集合
	 * @return 成功条数
	 */
	public int removeApparatusByIds(String ids);
	
}
