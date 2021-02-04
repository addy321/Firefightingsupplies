package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdbc.model.DeptModel;

/**
 * Description: [部门表服务]
 */
@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
public interface DeptService {

	/**
	 * <p>Discription:[部门表数据分页查询]</p>
	 * @param pager 部门表数据分页条件
	 * @param deptModel 部门表数据查询条件
	 * @param queryFields 部门表数据查询字段集合
	 * @return List<DeptModel>分页数据
	 *
	 */
	 public	List<DeptModel> queryPageDept(Page page, DeptModel deptModel, String queryFields);
	 
	 /**
	 * <p>Discription:[部门表数据不分页查询]</p>
	 * @param pager 部门表数据分页条件
	 * @param deptModel 部门表数据查询条件
	 * @param queryFields 部门表数据查询字段集合
	 * @return List<DeptModel>分页数据
	 *
	 */
	 public	List<DeptModel> queryListDept(DeptModel deptModel, String queryFields);
	
	/**
	 * <p>Discription:[部门表数据查询总条数]</p>
	 * @param deptModel 部门表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountDept(DeptModel deptModel);
	
	/**
	 * <p>Discription:[根据id查询部门表数据]</p>
	 * @param id 部门表数据id
	 * @return DeptModel 单条数据
	 */
	public DeptModel queryDeptById(Long id);

	/**
	 * <p>Discription:[部门表数据新增]</p>
	 * @param deptModel 部门表数据
	 * @return String 添加成功的id
	 */
	public int save(DeptModel deptModel);
	
	/**
	 * <p>Discription:[部门表数据编辑]</p>
	 * @param deptModel 部门表数据
	 * @return 成功条数
	 */
	public int edit(DeptModel deptModel);
	
	/**
	 * <p>Discription:[部门表数据删除]</p>
	 * @param id 部门表数据id
	 * @return 成功条数
	 */
	public int removeDeptById(Long id);
	
	/**
	 * <p>Discription:[部门表数据批量删除]</p>
	 * @param ids 部门表数据id的集合
	 * @return 成功条数
	 */
	public int removeDeptByIds(String ids);
	
}
