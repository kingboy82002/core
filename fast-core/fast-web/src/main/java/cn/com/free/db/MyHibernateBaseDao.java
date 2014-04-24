package cn.com.free.db;

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
	
	public interface Callback {
        Object doIt(Session session);
    }
	
	public <T> Object execute(Callback callback) {
		Session session = openHibernateSession();
        try {
            return callback.doIt(session);
        } finally {
        	closeHibernateSession(session);
        }
    }
}

