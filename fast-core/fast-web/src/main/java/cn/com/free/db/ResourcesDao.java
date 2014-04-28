package cn.com.free.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import cn.com.free.model.Resources;

public class ResourcesDao extends MyHibernateBaseDao{

	@SuppressWarnings("unchecked")
	public List<Resources> findAll(){
		return (List<Resources>) this.execute(new Callback(){
			@Override
			public Object doIt(final Session session) {
				Criteria criteria = session.createCriteria(Resources.class);
				return criteria.list();
			}
		});
	}
}
