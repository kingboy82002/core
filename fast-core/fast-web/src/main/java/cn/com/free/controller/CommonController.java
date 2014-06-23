package cn.com.free.controller;
/**
 * 公共用
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.free.model.Users;

@Controller
public class CommonController extends  BaseController{
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("我是登录页面");
		return "../login";
	}
	
	@ResponseBody
	@RequestMapping(value="/loginCheck")
	public String loginCheck(String name,String password){
		System.out.println("登录成功");
		if(!name.equals("yzq"))
			return "用户名或密码错误";
		Users user = new Users();
		user.setUsername(name);
		request.getSession().setAttribute(name, user);
		return "success";
	}

	@RequestMapping("/index")
	public ModelAndView index(String name){
		System.out.println("我是首页2");
		Users user = (Users)request.getSession().getAttribute("yzq");
//		if(user==null){
//			return getModelAndView("login.do");
//		}
//		request.setAttribute("msg", "这是首页2");
//		return "../index";
		return getModelAndView("index.html");
	}
	
}
