package cn.com.free.test;

import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cn.com.free.action.UserAction;
import cn.com.free.base.BaseAction;

import com.opensymphony.xwork2.ActionProxy;

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
}
