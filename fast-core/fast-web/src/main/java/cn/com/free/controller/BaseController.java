package cn.com.free.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.com.free.cache.CacheStorer;

public class BaseController {
	@Autowired(required=false)
	protected HttpServletRequest request;
	
	@Autowired
    private CacheStorer defaultStorer;
	
	public ModelAndView getModelAndView(String viewname){
		return new ModelAndView(new RedirectView(viewname));
	}
}
