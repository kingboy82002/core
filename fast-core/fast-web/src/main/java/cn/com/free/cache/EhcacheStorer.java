package cn.com.free.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

@Component
public class EhcacheStorer implements CacheStorer{

	@Autowired
	private EhCacheCacheManager cacheManager;
	
	@Override
	public void storeCache(String key, Object obj) {
		CacheManager manager = (CacheManager) cacheManager.getCacheManager();
		Cache cache = manager.getCache("userCache");
		Element element = new Element(key, obj); 
		cache.put(element);
	}

	@Override
	public <T> Object getCache(String key) {
		CacheManager manager = (CacheManager) cacheManager.getCacheManager();
		Cache cache = manager.getCache("userCache");
		Element element = cache.get(key); 
		return element.getObjectValue();
	}
	
	
}
