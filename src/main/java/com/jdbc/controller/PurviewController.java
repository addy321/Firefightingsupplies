
package com.jdbc.controller;

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
import com.jdbc.model.PurviewModel;
import com.jdbc.model.RoleModel;
import com.jdbc.service.PurviewService;
import com.jdbc.service.RoleService;

@Controller
@RequestMapping("/purview")
public class PurviewController extends BaseApiController {

    @Resource
    private PurviewService purviewService;
    
    @Resource
    private RoleService roleService;

    @RequestMapping("/list")
    public String getlist(Page page, PurviewModel purviewModel, Map<String, Object> map) {
        List<PurviewModel> purviewList = purviewService.queryPagePurview(page, purviewModel, null);
        map.put("purviewList", purviewList);
        map.put("page", page);
        
        List<RoleModel> selectrole = roleService.queryListRole(null, null);	
	    map.put("selectrole", selectrole);
	    
	    map.put("menuclass", "purview");
	    
        return "Purview";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getPurviewModel(Long id) {
        if (id == null) {
            return error();
        }
        PurviewModel purview = purviewService.queryPurviewById(id);
        return success(purview);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = purviewService.removePurviewById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody PurviewModel purview) {
        if (purview == null) {
            return error();
        }
        int res = 0;
        if (purview.getId() == null || purview.getId() == 0) {
            res = purviewService.save(purview);
        } else {
            res = purviewService.edit(purview);
        }
        return res > 0 ? success() : error();
    }
}

            