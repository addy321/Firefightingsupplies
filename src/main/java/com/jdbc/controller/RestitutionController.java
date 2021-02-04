
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
import com.jdbc.model.Page;
import com.jdbc.model.ReceiveModel;
import com.jdbc.model.RestitutionModel;
import com.jdbc.service.ReceiveService;
import com.jdbc.service.RestitutionService;
import com.jdbc.service.UserService;

@Controller
@RequestMapping("/restitution")
public class RestitutionController extends BaseApiController {

    @Resource
    private RestitutionService restitutionService;
    
    @Resource
    private ReceiveService receiveService;
    
    @Resource
	private UserService userService;

    @RequestMapping("/list")
    public String getlist(Page page, RestitutionModel restitutionModel, Map<String, Object> map) {
        List<RestitutionModel> restitutionList = restitutionService.queryPageRestitution(page, restitutionModel, null);
        map.put("restitutionList", restitutionList);
        map.put("page", page);
        map.put("menuclass", "restitution");
        
        List<ReceiveModel> receiveModels = receiveService.queryListReceive(null, null);
        map.put("selectreceive", receiveModels);
        
        map.put("restitutionModel", restitutionModel);
        return "Restitution";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getRestitutionModel(Long id) {
        if (id == null) {
            return error();
        }
        RestitutionModel restitution = restitutionService.queryRestitutionById(id);
        return success(restitution);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = restitutionService.removeRestitutionById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody RestitutionModel restitution) {
        if (restitution == null) {
            return error();
        }
        int res = 0;
        if (restitution.getId() == null || restitution.getId() == 0) {
        	restitution.setCreateTime(new Date());
            res = restitutionService.save(restitution);
        } else {
            res = restitutionService.edit(restitution);
        }
        return res > 0 ? success() : error();
    }
}

            