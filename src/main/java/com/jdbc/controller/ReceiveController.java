
package com.jdbc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdbc.model.AjaxResult;
import com.jdbc.model.ApparatusModel;
import com.jdbc.model.Page;
import com.jdbc.model.ReceiveModel;
import com.jdbc.model.UserModel;
import com.jdbc.service.ApparatusService;
import com.jdbc.service.ReceiveService;
import com.jdbc.service.UserService;

@Controller
@RequestMapping("/receive")
public class ReceiveController extends BaseApiController {

    @Resource
    private ReceiveService receiveService;
    
    @Resource
	private UserService userService;

    @Resource
    private ApparatusService apparatusService;
    
    @RequestMapping("/list")
    public String getlist(Page page, ReceiveModel receiveModel, Map<String, Object> map) {
        List<ReceiveModel> receiveList = receiveService.queryPageReceive(page, receiveModel, null);
        map.put("receiveList", receiveList);
        map.put("page", page);
        map.put("menuclass", "receive");
        
        List<ApparatusModel> apparatusSelect = apparatusService.queryListApparatus(null, null);
        map.put("apparatusSelect", apparatusSelect);
        
        List<UserModel> userSelect =  userService.queryListUser(null, null);
        map.put("userSelect", userSelect);
        
        map.put("receiveModel", receiveModel);
        
        return "Receive";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getReceiveModel(Long id) {
        if (id == null) {
            return error();
        }
        ReceiveModel receive = receiveService.queryReceiveById(id);
        return success(receive);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = receiveService.removeReceiveById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody ReceiveModel receive) {
        if (receive == null) {
            return error();
        }
        int res = 0;
        if (receive.getId() == null || receive.getId() == 0) {
        	receive.setCreateTime(new Date());
            res = receiveService.save(receive);
        } else {
            res = receiveService.edit(receive);
        }
        return res > 0 ? success() : error();
    }
}

            