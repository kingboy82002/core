package cn.com.free.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyHibernateBaseDao{
	@Autowired  
    private SessionFactory sessionfactory;
	
	private Session openHibernateSession(){
		return sessionfactory.openSession();
	}
	
	private void closeHibernateSession(Session session){
		if(session!=null)
			session.close();
	}
	
	public interface DBCallback {
		<T> Object doTransactional(Session session);
    }
	
	public <T> Object execute(DBCallback callback) {
		Session session = openHibernateSession();
        try {
            return callback.doTransactional(session);
        } finally {
        	closeHibernateSession(session);
        }
    }
}

