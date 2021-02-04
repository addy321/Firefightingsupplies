package com.jdbc.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jdbc.model.Page;
import com.jdbc.dao.VendorDao;
import com.jdbc.model.VendorModel;
import com.jdbc.service.VendorService;

/** 
 * Description: [供应商表服务实现]
 */
@Service("vendorService")
public class VendorServiceImpl implements VendorService {
	
	/**
	 * <p>Discription:[供应商表dao]</p>
	 */	
	@Resource
	private VendorDao vendorDao;
	
	/**
	 * <p>Discription:[供应商表数据分页查询]</p>
	 * @param page 供应商表数据分页条件
	 * @param vendorModel 供应商表数据查询条件
	 * @param queryFields 供应商表数据查询字段
	 * @return List<VendorModel>分页数据
	 *
	 */
	public List<VendorModel> queryPageVendor(Page page,VendorModel vendorModel,
			String queryFields){
			
		List<VendorModel> listVendor = new ArrayList<VendorModel>();
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
				listVendor = this.vendorDao.queryPageVendor(page,vendorModel,lis);
			}
			long total = queryCountVendor(vendorModel);
			page.setTotal((int)total);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listVendor;
	}

	/**
	 * <p>Discription:[供应商表数据不分页查询]</p>
	 * @param vendorModel 供应商表数据查询条件
	 * @param queryFields 供应商表数据查询字段
	 * @return List<VendorModel>数据
	 *
	 */
	public List<VendorModel> queryListVendor(VendorModel vendorModel,String queryFields){
		List<VendorModel> listVendor = new ArrayList<VendorModel>();
		try{
			List<String> lis = new ArrayList<String>();
			if(Objects.isNull(queryFields)){
				lis = null;
			}else{
				lis = Arrays.asList(queryFields.split(","));
			}
			listVendor = this.vendorDao.queryListVendor(vendorModel,lis);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return listVendor;
	}

	/**
	 * <p>Discription:[供应商表数据查询总条数]</p>
	 * @param vendorModel 供应商表数据查询条件
	 * @return 查询条数
	 */
	public Long queryCountVendor(VendorModel vendorModel){
		
		Long count = (long)0;
		try{
			count = this.vendorDao.queryCountVendor(vendorModel);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[根据id查询供应商表数据]</p>
	 * @param id 供应商表数据id
	 * @return VendorModel 单条数据
	 */
	public VendorModel queryVendorById(Long id){
		
		VendorModel model = new VendorModel();
		try{
			if(Objects.isNull(id)){
				return null;
			}else{
				model = this.vendorDao.queryVendorById(id,null);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	/**
	 * <p>Discription:[供应商表数据新增]</p>
	 * @param vendorModel 供应商表数据
	 * @return String 添加成功的id
	 */
	public int save(VendorModel vendorModel){
		int count = 0;
		try{
			if(Objects.isNull(vendorModel)){
				return 0;
			}else{
				count = this.vendorDao.addVendor(vendorModel);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[供应商表数据编辑]</p>
	 * @param vendorModel 供应商表数据
	 * @return 成功条数 	
	 *
	 */
	public int edit(VendorModel vendorModel){
		Integer count = 0;
		try{
			if(Objects.isNull(vendorModel) || Objects.isNull(vendorModel.getId())){
				return 0;
			}else{
				count = this.vendorDao.updateVendor(vendorModel);
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[供应商表数据删除]</p>
	 * @param id 供应商表数据id
	 * @return 成功条数 	
	 *
	 */
	public int removeVendorById(Long id){
		Integer count = 0;
		try{
			if(Objects.isNull(id)){
				return 0;
			}else{
				count = this.vendorDao.removeVendorById(id);
			}		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

	/**
	 * <p>Discription:[供应商表数据批量删除]</p>
	 * @param ids 供应商表数据id的集合
	 * @return 成功条数
	 *
	 */
	public int removeVendorByIds(String ids){
		Integer count = 0;
		try{
			if(Objects.isNull(ids)){
				return 0;
			}else{
				List<String> lis = Arrays.asList(ids.split(","));
				count = this.vendorDao.removeVendorByIds(lis);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return count;
	}

}
