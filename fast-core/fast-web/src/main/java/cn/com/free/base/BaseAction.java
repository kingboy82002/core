package cn.com.free.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(BaseAction.class);
	private HttpServletRequest request = ServletActionContext.getRequest();  
	private HttpServletResponse response = ServletActionContext.getResponse();
//	private MockHttpServletRequest request = new MockHttpServletRequest();//测试用
//	private MockHttpServletResponse response = new MockHttpServletResponse();//测试用
	private String method = "";
	
	public void setAttribute(String name,Object o){
		request.setAttribute(name, o);
	}
	
	public Object getAttribute(String name){
		return request.getAttribute(name);
	}
	
	public String getParameter(String name) {
		return request.getParameter(name);
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 判断是否ajax请求
	 * @return
	 */
	public boolean isAjax(){
		return request.getHeader("x-requested-with").equals("XMLHttpRequest");
	}
	
	/**
	 * 输出response内容
	 * @param content
	 */
	public void outputResponse(String content){
    	try {
    		response.setCharacterEncoding("utf-8");
    		response.setContentType("text/html; charset=utf-8");
    		PrintWriter pw = response.getWriter();
    		pw.print(content);
    		pw.flush();
    		pw.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}		
	}
	
	
}
