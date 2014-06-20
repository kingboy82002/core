package cn.com.free.controller;
/**
 * 公共用
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	@Autowired(required=false)
	private  HttpServletRequest request;

	@RequestMapping("/index")
	public String index(String name){
		System.out.println("我是首页2");
		request.setAttribute("msg", "这是首页2");
		return "../index";
	}
}
