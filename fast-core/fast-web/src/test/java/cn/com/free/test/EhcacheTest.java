package cn.com.free.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.free.db.CommonDao;
import cn.com.free.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class EhcacheTest {
    @Autowired
    protected ApplicationContext ctx;
    
    @Autowired  
    private CommonDao commonDao;
    
	@Before  
    public void init() {  
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(  
//                "applicationContext.xml");  
//        EhCacheCacheManager ehCacheManager = (EhCacheCacheManager) ctx  
//                .getBean("cacheManager");  
//        cacheManager = ehCacheManager.getCacheManager();  
//        cache = cacheManager.getCache("userCache");  
    }
	
	@Test
	public void test(){
		EhCacheCacheManager ehCacheManager = (EhCacheCacheManager)ctx.getBean("cacheManager");
		CacheManager manager = (CacheManager) ehCacheManager.getCacheManager();
		Cache cache = manager.getCache("userCache");
		System.out.println(cache);
		Element element = new Element("key1", "value1"); 
		cache.put(element);
		Element element1 = cache.get("key1"); 
		System.out.println(element1.getObjectValue());
		
		System.out.println("============================================");
		User user = (User)commonDao.findById(12, User.class);
		Element element3 = new Element("aaaa", user); 
		cache.put(element3);
		
		
		Element element2 = cache.get("aaaa");
		if(element2!=null){
			System.out.println(element2.getObjectValue());
		}
	}
}
