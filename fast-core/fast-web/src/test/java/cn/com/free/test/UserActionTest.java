package cn.com.free.test;

import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.free.action.UserAction;
import cn.com.free.db.CommonDao;
import cn.com.free.model.User;
import cn.com.free.util.SpringContextUtil;

import com.opensymphony.xwork2.ActionProxy;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserActionTest extends StrutsSpringTestCase{
	@Ignore
	public void testGetActionMapping() throws Exception {
		ActionMapping mapping = getActionMapping("/userAction");
		assertNotNull(mapping);
		assertEquals("/", mapping.getNamespace());
		assertEquals("userAction", mapping.getName());
	}	 
	
	@Test
	public void testLogin() throws Exception {
		request.setParameter("method", "login");
		ActionProxy proxy = getActionProxy("/userAction");
		assertNotNull(proxy);

		UserAction action = (UserAction) proxy.getAction();
		assertNotNull(action);

		String result = proxy.execute();
		System.out.println(result);
//		assertEquals("success", result);
//		assertEquals("FD", action.getParam());
	}		
	
	@Test
	public void testGetActionProxy() throws Exception {
		request.setParameter("method", "reg");
		ActionProxy proxy = getActionProxy("/userAction");
		assertNotNull(proxy);

		UserAction action = (UserAction) proxy.getAction();
		assertNotNull(action);

		String result = proxy.execute();
		System.out.println(result);
//		assertEquals("success", result);
//		assertEquals("FD", action.getParam());
	}	

	@Test
	public void testCheckpwd() throws Exception {
		request.setParameter("method", "checkpwd");
		ActionProxy proxy = getActionProxy("/userAction");
		assertNotNull(proxy);

		UserAction action = (UserAction) proxy.getAction();
		assertNotNull(action);
		
		String result = proxy.execute();
		System.out.println(result);

//		PrintWriter pw = response.getWriter();
//		pw.write("hello world!杭州");
//		pw.flush();
//		pw.close();
//		System.out.println("hello world!杭州");
//		assertEquals("success", result);
//		assertEquals("FD", action.getParam());
	}	
	
	@Test
	public void testAddUser(){
		try {
			Object obj = SpringContextUtil.getBean("commonDao");
			System.out.println(obj);
			CommonDao commonDao = (CommonDao)obj;
			System.out.println(commonDao.getList(User.class));
//			User user = new User();
//			user.setUsername("yzq");
//			user.setPassword("123");
//			commonDao.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
