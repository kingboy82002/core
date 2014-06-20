package cn.com.free.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.com.free.model.Resources;

//@Repository 
public class ResourcesDao extends MyHibernateBaseDao{

	@SuppressWarnings("unchecked")
	public List<Resources> findAll(){
		return (List<Resources>) this.execute(new DBCallback(){
			@Override
			public Object doTransactional(final Session session) {
				Criteria criteria = session.createCriteria(Resources.class);
				return criteria.list();
			}
		});
	}
}
