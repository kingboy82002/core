package cn.com.free.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class CommonDao extends MyHibernateBaseDao{
	
	@Transactional
	public void add(final Object obj){
		this.execute(new DBCallback(){
			@Override
			public Object doTransactional(Session session) {
				session.save(obj);
				return null;
			}
		});
	}
	
	@Transactional
	public void delete(final Object obj){
		this.execute(new DBCallback(){
			@Override
			public Object doTransactional(Session session) {
				session.delete(obj);
				return null;
			}
		});
	}
	
	@Transactional
	public void update(final Object obj){
		this.execute(new DBCallback(){
			@Override
			public Object doTransactional(Session session) {
				session.update(obj);
				return null;
			}
		});
	}
	
	public <T> Object findById(final long id,final Class<T>  clazz){
		@SuppressWarnings("rawtypes")
		List list = (List) this.execute(new DBCallback(){
			@Override
			public Object doTransactional(Session session) {
				Criteria criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq("id", id));
				return criteria.list();
			}
		});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}	
	
	public <T> Object getList(final Class<T>  clazz){
		@SuppressWarnings("rawtypes")
		List list = (List) this.execute(new DBCallback(){
			@Override
			public Object doTransactional(Session session) {
				Criteria criteria = session.createCriteria(clazz);
				return criteria.list();
			}
		});
		return list;
	}
}
