package com.ds.web.rs.persistence.utils;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;


/**
 * @author Sarvesh.Dubey@hotmail.com
 *
 */
@Component
public class HibernateUtils {

	@Autowired
	private ApplicationContext context;

	private HibernateTemplate hibernateTemplate;


	/**
	 * Returns the current session
	 * @return current session from session factory
	 */
	public Session getSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	/**
	 * Opens a new session from session factory
	 * @return new session
	 */
	public Session getNewSession() {
		return getHibernateTemplate().getSessionFactory().openSession();
	}


	/**
	 * Returns current session in read only mode.
	 * @return a read only session
	 */
	/*public Session getReadOnlySession() {
		Session readOnlySession = getSession();
		readOnlySession.setFlushMode(FlushMode.MANUAL);
		readOnlySession.setDefaultReadOnly(true);
		return readOnlySession;
	}*/

	/**
	 * Get Hibernate template. <br>
	 * Do <b>NOT</b> try to eagerly initialise hibernateTemplate or try to autowire it.<br>
	 * {@link AuditInterceptor} depends on hibernateTemplate which causes circular dependency 
	 * @return hibernate template
	 * @see AuditInterceptor
	 */
	public HibernateTemplate getHibernateTemplate() {
		if(null == this.hibernateTemplate)
			this.hibernateTemplate = context.getBean("hibernateTemplate", HibernateTemplate.class);
		return this.hibernateTemplate;
	}

	/**
	 * Commits the transaction of underlying session
	 * @param session to commit
	 */
	public void commit(Session session) {
		session.getTransaction().commit();
	}

	/**
	 * Rolls back the transaction of underlying session
	 * @param session to rollback
	 */
	public void rollback(Session session) {
		session.getTransaction().rollback();
	}
	
	/**
	 * Closes the underlying session
	 * @param session to close
	 */
	public void close(Session session) {
		session.close();
	}

}
