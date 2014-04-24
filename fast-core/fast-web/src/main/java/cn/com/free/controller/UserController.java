package cn.com.free.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.com.free.db.CommonDao;
import cn.com.free.model.User;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@Autowired
	private CommonDao commonDao;
	
	@RequestMapping(value = "index")
    public String index(@RequestParam(value="username")String username, HttpServletRequest request) {
		System.out.println(username);
		request.setAttribute("msg", "我成功啦");
		User user = new User();
		user.setUsername(username);
		user.setPassword("123");
		commonDao.add(user);
		if(username.equals("aaaa")){
//			return new ModelAndView(new RedirectView("success.jsp"));
		}
        return "/user/success";
    }
	
	@RequestMapping(value = "{blogId}")
    public String index2(@PathVariable int blogId) {
		System.out.println(blogId);
        return "index";
    }

	@RequestMapping("/test/login")  // 请求url地址映射，类似Struts的action-mapping
    public String testLogin(@RequestParam(value="username")String username, String password, HttpServletRequest request) {
        // @RequestParam是指请求url地址映射中必须含有的参数(除非属性required=false)
        // @RequestParam可简写为：@RequestParam("username")

        if (!"admin".equals(username) || !"admin".equals(password)) {
            return "loginError"; // 跳转页面路径（默认为转发），该路径不需要包含spring-servlet配置文件中配置的前缀和后缀
        }
        return "loginSuccess";
    }
	
	@RequestMapping("/test/login2.do")
    public ModelAndView testLogin2(String username, String password, int age){
        // request和response不必非要出现在方法中，如果用不上的话可以去掉
        // 参数的名称是与页面控件的name相匹配，参数类型会自动被转换
        
        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return new ModelAndView("loginError"); // 手动实例化ModelAndView完成跳转页面（转发），效果等同于上面的方法返回字符串
        }
        return new ModelAndView(new RedirectView("../index.jsp"));  // 采用重定向方式跳转页面
        // 重定向还有一种简单写法
        // return new ModelAndView("redirect:../index.jsp");
    }
	
	@RequestMapping("/test/login3.do")
    public ModelAndView testLogin3(User user) {
        // 同样支持参数为表单对象，类似于Struts的ActionForm，User不需要任何配置，直接写即可
        String username = user.getUsername();
        String password = user.getPassword();
        if (!"admin".equals(username) || !"admin".equals(password)) {
            return new ModelAndView("loginError");
        }
        return new ModelAndView("loginSuccess");
    }
	
	@RequestMapping(value="/comment/{blogId}", method=RequestMethod.POST)
	public void comment(@PathVariable int blogId, HttpSession session, HttpServletResponse response) throws IOException {
	    
	}
	
	// @ResponseBody ajax响应，处理Ajax请求也很方便
	@RequestMapping(value="/whitelist/{whiteListId}/del")
	@ResponseBody
	public String delete(@PathVariable Integer whiteListId) {
		return "success";
	}
}
