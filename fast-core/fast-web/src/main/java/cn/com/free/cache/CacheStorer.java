package cn.com.free.cache;

public interface CacheStorer {
	
	public void storeCache(String key,Object obj);
	
	public <T> Object getCache(String key);
}
