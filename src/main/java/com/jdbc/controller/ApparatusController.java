
package com.jdbc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdbc.model.AjaxResult;
import com.jdbc.model.Page;
import com.jdbc.model.ReceiveModel;
import com.jdbc.model.UserModel;
import com.jdbc.model.UserReceiveModel;
import com.jdbc.model.VendorModel;
import com.jdbc.model.ApparatusModel;
import com.jdbc.service.ApparatusService;
import com.jdbc.service.PurviewService;
import com.jdbc.service.ReceiveService;
import com.jdbc.service.UserService;
import com.jdbc.service.VendorService;
import com.jdbc.tool.Util;

@Controller
@RequestMapping("/apparatus")
public class ApparatusController extends BaseApiController {

    @Resource
    private ApparatusService apparatusService;
    @Resource
    private VendorService vendorService;
    @Resource
    private ReceiveService receiveService;
    @Resource
    private UserService userService;
    @Resource
	private PurviewService purviewService;

    @RequestMapping("/list")
    public String getlist(Page page, ApparatusModel apparatusModel, Map<String, Object> map) {
        List<ApparatusModel> apparatusList = apparatusService.queryPageApparatus(page, apparatusModel, null);
        
        System.err.println(">>>>>>>>>>>>>>>>>>>"+apparatusList);
        map.put("apparatusList", apparatusList);
        map.put("page", page);
        map.put("menuclass", "apparatus");
        
        List<VendorModel> selectvendor = vendorService.queryListVendor(null, null);	
	    map.put("selectvendor", selectvendor);
	    
	    map.put("apparatusModel", apparatusModel);
        return "Apparatus";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getApparatusModel(Long id) {
        if (id == null) {
            return error();
        }
        ApparatusModel apparatus = apparatusService.queryApparatusById(id);
        return success(apparatus);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = apparatusService.removeApparatusById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody ApparatusModel apparatus) {
        if (apparatus == null) {
            return error();
        }
        int res = 0;
        if (apparatus.getId() == null || apparatus.getId() == 0) {
        	apparatus.setStorageTime(new Date());
        	apparatus.setUin((String)Util.uniqId());
        	System.err.println(apparatus);
            res = apparatusService.save(apparatus);
        } else {
            res = apparatusService.edit(apparatus);
        }
        return res > 0 ? success() : error();
    }
    
    // 领取物品
    @PostMapping("receive")
    @ResponseBody
    public AjaxResult userRreceive(@RequestBody UserReceiveModel model,HttpSession session) {
    	 
    	System.err.println(model);
        if (model==null || model.getApparatusId() == 0) {
            return error();
        }
        ApparatusModel apparatus = apparatusService.queryApparatusById((long) model.getApparatusId());
        
        if(apparatus.getState().equals("1")) {
        	return error("此用品不可领用，已被其他用户领取");
        }
        
        int res = 0;
        String userName = (String) session.getAttribute("loginName");
        if(userName == null) {
        	return error("登录超时");
        }
        
        UserModel user = new UserModel();
        user.setLoginName(userName);
        user = userService.queryListUser(user, null).get(0);
        
        ReceiveModel receiveModel = new ReceiveModel();
        receiveModel.setApparatusId((Integer)model.getApparatusId());
        receiveModel.setCreateTime(new Date());
        receiveModel.setReceiveTime(new Date());
        receiveModel.setRemark(user.getUserName()+"领用了"+apparatus.getApparatusName()+"-备注："+model.getRemarks());
        receiveModel.setReturnTime(model.getTime());
        receiveModel.setUserId(user.getId());
        
        res =  receiveService.save(receiveModel);
        
        apparatus.setState("1");
        apparatusService.edit(apparatus);
        
        return res > 0 ? success() : error();
    }
}

            