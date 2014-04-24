package cn.com.free.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.com.free.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath:springMVC-servlet.xml"})
public class UserControllerTest {
	@Autowired  
    private ApplicationContext ctx;  
  
    @Autowired  
    private UserController userController;//你要测试的Controller  
  
    private MockMvc mockMvc;
    
    @Before  
    public void setup() {  
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();  
    }
    
	@Test
	public void testIndex() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders  
                .post("/user/index")  
                .accept(MediaType.APPLICATION_JSON)
                .param("username", "aaaa")
                .param("limit", "10"));  
        MvcResult mr = ra.andReturn();  
        System.out.println(mr.getModelAndView().getViewName()); 
//        String result = mr.getResponse().getContentAsString();  
//        System.out.println(result); 
	}

}
