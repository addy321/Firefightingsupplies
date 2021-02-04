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
import com.jdbc.model.DeptModel;
import com.jdbc.model.Page;
import com.jdbc.model.RoleModel;
import com.jdbc.model.UserModel;
import com.jdbc.service.DeptService;
import com.jdbc.service.RoleService;
import com.jdbc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseApiController {

	@Resource
	private UserService userService;
	@Resource
    private RoleService roleService;
	@Resource
    private DeptService deptService;
	// 跳转用户管理
	@RequestMapping("/list")
	public String getlist(Page page, UserModel userModel, Map<String, Object> map) {
		List<UserModel> userList = userService.queryPageUser(page, userModel, null);
		map.put("userList", userList);
		map.put("page", page);
		map.put("menuclass", "user");
		
		List<RoleModel> selectrole = roleService.queryListRole(null, null);	
	    map.put("selectrole", selectrole);
	    
	    List<DeptModel> selectdept = deptService.queryListDept(null, null);
	    map.put("selectdept", selectdept);
	    
	    map.put("userModel", userModel);
		return "User";
	}

	@GetMapping("/getTheData")
	@ResponseBody
	public AjaxResult getUserModel(Long id) {
		if (id == null) {
			return error();
		}
		UserModel user = userService.queryUserById(id);
		return success(user);
	}

	// 跳转用户管理
	@GetMapping("/delData")
	@ResponseBody
	public AjaxResult delData(Long id) {
		if (id == null) {
			return error();
		}
		int res = userService.removeUserById(id);
		return res > 0 ? success() : error();
	}

	// 跳转用户管理
	@PostMapping("/saveData")
	@ResponseBody
	public AjaxResult SaveData(@RequestBody UserModel user) {
		if (user == null) {
			return error();
		}
		int res = 0;
		System.err.println(user);
		if (user.getId() == null || user.getId() == 0) {
			res = userService.save(user);
		} else {
			res = userService.edit(user);
		}
		return res > 0 ? success() : error();
	}
}
