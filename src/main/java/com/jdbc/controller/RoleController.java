
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
import com.jdbc.model.RoleModel;
import com.jdbc.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseApiController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/list")
    public String getlist(Page page, RoleModel roleModel, Map<String, Object> map) {
        List<RoleModel> roleList = roleService.queryPageRole(page, roleModel, null);
        map.put("roleList", roleList);
        map.put("page", page);
        map.put("menuclass", "role");
        
        return "Role";
    }
    
 

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getRoleModel(Long id) {
        if (id == null) {
            return error();
        }
        RoleModel role = roleService.queryRoleById(id);
        return success(role);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = roleService.removeRoleById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody RoleModel role) {
        if (role == null) {
            return error();
        }
        int res = 0;
        if (role.getId() == null || role.getId() == 0) {
            res = roleService.save(role);
        } else {
            res = roleService.edit(role);
        }
        return res > 0 ? success() : error();
    }
}

            