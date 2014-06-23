/**
 * 
 */
package cn.com.free.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.com.free.cache.CacheStorer;
import cn.com.free.controller.UserController;

/**
 * @author intel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath:springMVC-servlet.xml"})
public class CommonTest {
	
	@Value("${driverClassName}")
	private String driverClassName; 
	
	@Autowired  
    private UserController userController;//你要测试的Controller  
	
	
    private MockMvc mockMvc;
    
    @Autowired
    private CacheStorer defaultStorer;
    
    
    @Before  
    public void setup() {  
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();  
    }
	
	@Test
	public void test() throws Exception{
		System.out.println(userController);
//		System.out.println(driverClassName);
//		System.out.println("=================================================");
//		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders  
//                .post("/user/index")  
//                .accept(MediaType.APPLICATION_JSON)
//                .param("name", "aaaa"));  
//        MvcResult mr = ra.andReturn();  
//        System.out.println(mr.getModelAndView().getViewName()); 
//        System.out.println("=================================================");
//        System.out.println("测试ehcache");
//        defaultStorer.storeCache("hao", "de");
//        System.out.println(defaultStorer.getCache("hao"));
	}
}
