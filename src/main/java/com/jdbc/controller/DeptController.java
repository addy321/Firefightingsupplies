
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
import com.jdbc.model.DeptModel;
import com.jdbc.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController extends BaseApiController {

    @Resource
    private DeptService deptService;

    @RequestMapping("/list")
    public String getlist(Page page, DeptModel deptModel, Map<String, Object> map) {
        List<DeptModel> deptList = deptService.queryPageDept(page, deptModel, null);
        System.err.println(deptList);
        map.put("deptList", deptList);
        map.put("page", page);
        map.put("menuclass", "dept");
        return "Dept";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getDeptModel(Long id) {
        if (id == null) {
            return error();
        }
        DeptModel dept = deptService.queryDeptById(id);
        return success(dept);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = deptService.removeDeptById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody DeptModel dept) {
        if (dept == null) {
            return error();
        }
        int res = 0;
        if (dept.getId() == null || dept.getId() == 0) {
        	dept.setCreateTime(new Date());
            res = deptService.save(dept);
        } else {
            res = deptService.edit(dept);
        }
        return res > 0 ? success() : error();
    }
}

            