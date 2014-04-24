package cn.com.free.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public class CommonDao extends MyHibernateBaseDao{
	
	@Transactional
	public void add(final Object obj){
		this.execute(new Callback(){
			@Override
			public Object doIt(Session session) {
				session.save(obj);
				return null;
			}
		});
	}
	
	@Transactional
	public void delete(final Object obj){
		this.execute(new Callback(){
			@Override
			public Object doIt(Session session) {
				session.delete(obj);
				return null;
			}
		});
	}
	
	public <T> Object getList(final Class<T>  clazz){
		@SuppressWarnings("rawtypes")
		List list = (List) this.execute(new Callback(){
			@Override
			public Object doIt(Session session) {
				Criteria criteria = session.createCriteria(clazz);
				return criteria.list();
			}
		});
		return list;
	}
}
