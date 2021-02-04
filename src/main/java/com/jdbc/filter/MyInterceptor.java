package com.jdbc.filter;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.model.AjaxResult;
import com.jdbc.model.PurviewModel;
import com.jdbc.model.UserModel;
import com.jdbc.service.PurviewService;
import com.jdbc.service.UserService;

/**
 * 自定义拦截器1
 *
 */
public class MyInterceptor implements HandlerInterceptor {

	@Resource
	private PurviewService purviewService;
	
	@Resource
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String loginuser = (String) request.getSession().getAttribute("loginName");
		if (loginuser == null) {
			response.sendRedirect("/");
			return false;
		}

		String servletPath = request.getServletPath();
		if(servletPath.equals("/login") || servletPath.equals("/quit")) {
			return true;
		}
		System.err.println(servletPath);
		if (loginuser.equals("admin")) { 
			request.setAttribute("isadmin", true);
			return true;
		}
		UserModel userModel = new UserModel();
		userModel.setLoginName(loginuser);
		List<UserModel> users =  userService.queryListUser(userModel, null);
		
		if(users == null || users.size()!=1) {
			response.sendRedirect("/");
			return false;
		}
		
		UserModel user = users.get(0);
		PurviewModel purviewModel = new PurviewModel();
		purviewModel.setRoleid(user.getRoleId());
		
		List<PurviewModel> paList = purviewService.queryListPurview(purviewModel, null);
		if(!servletPath.contains("list")) {
			return true;
		}
		for (int i = 0; i < paList.size(); i++) {
			if (paList.get(i).getAskurl().contains(servletPath)) {
				System.err.println("权限列表："+paList);
				request.setAttribute("menus", paList);
				return true;
			}
		}
		
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		AjaxResult result = new AjaxResult(false, 1, "权限不足", null);
		out.println(result.toString());
		out.flush();
		out.close();
		
		
		System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
		return false;// 只有返回true才会继续向下执行，返回false取消当前请求
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.err.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}
}
