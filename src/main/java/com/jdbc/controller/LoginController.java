package com.jdbc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.jdbc.model.PurviewModel;
import com.jdbc.model.UserModel;
import com.jdbc.service.PurviewService;
import com.jdbc.service.UserService;

@Controller
public class LoginController {

	@Resource
	private UserService userService;
	
	@Resource
	private PurviewService purviewService;

	// 跳转首页登录
	@GetMapping("/")
	public String index() {
		return "login";
	}

	// 进行登录
	@PostMapping("/login")
	public String login(String userName, String password, HttpServletRequest request, HttpServletResponse response,
			Map<String, Object> map) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");

		UserModel user = new UserModel();
		user.setLoginName(userName);
		user.setPassword(password);
		List<UserModel> userDataModel = userService.queryListUser(user, null);
		if (userDataModel != null && userDataModel.size() == 1) {
			UserModel userData = userDataModel.get(0);
			if (userData.getLoginName().equals(userName)) {
				// 创建session对象
				HttpSession session = request.getSession();
				// 把用户数据保存在session域对象中
				session.setAttribute("loginName", userName);
				
				PurviewModel purviewModel = new PurviewModel();
				purviewModel.setRoleid(userData.getRoleId());
				List<PurviewModel> paList = purviewService.queryListPurview(purviewModel, null);
				System.err.println("权限列表>>>>>>>>>>>>"+paList);
				request.setAttribute("menus", paList);
				if(userData.getLoginName().equals("admin"))
					request.setAttribute("isadmin", true);
				return "index";

			}
		}
		map.put("error", "用户名或密码错误");
		return "login";
	}
	
	// 跳转首页登录
	@GetMapping("/quit")
	public String Logquit(HttpSession session, SessionStatus sessionStatus) {
		session.invalidate();
	    sessionStatus.setComplete();
		return "redirect:/";
	}
}
