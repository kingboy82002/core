package cn.com.free.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.free.db.dao.CommonDao;
import cn.com.free.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class EhcacheTest {
    @Autowired
    protected ApplicationContext ctx;
    
    @Autowired  
    private CommonDao commonDao;
    
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
		Users user = (Users)commonDao.findById(12, Users.class);
		Element element3 = new Element("aaaa", user); 
		cache.put(element3);
		
		
		Element element2 = cache.get("aaaa");
		if(element2!=null){
			System.out.println(element2.getObjectValue());
		}
	}
}
