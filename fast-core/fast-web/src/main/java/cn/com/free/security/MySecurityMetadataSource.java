package cn.com.free.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import cn.com.free.db.dao.ResourcesDao;
import cn.com.free.model.Resources;
  
//1 加载资源与权限的对应关系    

/** 
* 该过滤器的主要作用就是通过spring著名的IoC生成securityMetadataSource。  
* securityMetadataSource相当于本包中自定义的MyInvocationSecurityMetadataSourceService。  
* 该MyInvocationSecurityMetadataSourceService的作用提从数据库提取权限和资源，装配到HashMap中，  
* 供Spring Security使用，用于权限校验。  
* @author sparta 11/3/29  
*/  
public class MySecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	//由spring调用  
    public MySecurityMetadataSource(ResourcesDao resourcesDao) {  
        this.resourcesDao = resourcesDao;  
        loadResourceDefine();  
    }  
  
    private ResourcesDao resourcesDao;  
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
  
    public ResourcesDao getResourcesDao() {  
        return resourcesDao;  
    }  
  
    public void setResourcesDao(ResourcesDao resourcesDao) {  
        this.resourcesDao = resourcesDao;  
    }  
  
    public Collection<ConfigAttribute> getAllConfigAttributes() {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public boolean supports(Class<?> clazz) {  
        // TODO Auto-generated method stub  
        return true;  
    }  
    //加载所有资源与权限的关系  
    private void loadResourceDefine() {  
        if(resourceMap == null) {  
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
            List<Resources> resources = this.resourcesDao.findAll();  
            for (Resources resource : resources) {  
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();  
                                //以权限名封装为Spring的security Object  
                ConfigAttribute configAttribute = new SecurityConfig(resource.getName());  
                configAttributes.add(configAttribute);  
                resourceMap.put(resource.getUrl(), configAttributes);  
            }  
        }  
          
        Set<Entry<String, Collection<ConfigAttribute>>> resourceSet = resourceMap.entrySet();  
        Iterator<Entry<String, Collection<ConfigAttribute>>> iterator = resourceSet.iterator();  
          
    }  
    //返回所请求资源所需要的权限  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {  
          
        String requestUrl = ((FilterInvocation) object).getRequestUrl();  
        System.out.println("requestUrl is " + requestUrl);  
        if(resourceMap == null) {  
            loadResourceDefine();  
        }  
        System.out.println(resourceMap.get(requestUrl));
        return resourceMap.get(requestUrl);  
    }  
}
