package cn.com.free.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.free.model.Users;

public class UsersDao extends MyHibernateBaseDao {

	public Users findByName(final String username){
		@SuppressWarnings("rawtypes")
		List list = (List) this.execute(new Callback(){
			@Override
			public Object doIt(Session session) {
				Criteria criteria = session.createCriteria(Users.class);
				criteria.add(Restrictions.eq("username", username));
				return criteria.list();
			}
		});
		if(list.size()>0){
			return (Users)list.get(0);
		}
		return null;
	}
}
