package com.yuntong.hibernate.database.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TClientInfo;

/**
 * Data access object (DAO) for domain model class TClientInfo.
 * @see com.yuntong.hibernate.database.dao.TClientInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TClientInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TClientInfoDAO.class);

	//property constants
	public static final String CLIENT_COMPANY = "clientCompany";
	public static final String CLIENT_NAME = "clientName";
	public static final String CLIENT_PHONE = "clientPhone";
	public static final String CLIENT_EMAIL = "clientEmail";
	public static final String CLIENT_POST_ID = "clientPostId";
	public static final String CLIENT_ADDRESS = "clientAddress";

	protected void initDao() {
		//do nothing
	}
	//得到所有客户信息
    public List findAllClientInfo(){
    	 	
    	 List list=getHibernateTemplate().loadAll(TClientInfo.class);
    	 log.debug("得到所有客户信息");
    	 return list;
    }
//  查出前十
	public List findTopTen(int cid){
		   SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	        Session session=sessionfactory.openSession();	        
	        Query query=session.createQuery("from TClientInfo info where info.clientId like  '"+cid+"%'");
	        List list=query.list();
		   return list;
	}
    public void save(TClientInfo transientInstance) {
        log.debug("saving TClientInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TClientInfo persistentInstance) {
        log.debug("deleting TClientInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TClientInfo findById( java.lang.Long id) {
        log.debug("getting TClientInfo instance with id: " + id);
        try {
            TClientInfo instance = (TClientInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TClientInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    public List findMaxID(){
    	List list=getHibernateTemplate().find("select max(clientId) from TClientInfo");	
    	return list;
    }
    
    public List findByExample(TClientInfo instance) {
        log.debug("finding TClientInfo instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding TClientInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TClientInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByClientCompany(Object clientCompany) {
		return findByProperty(CLIENT_COMPANY, clientCompany);
	}
	
	public List findByClientName(Object clientName) {
		return findByProperty(CLIENT_NAME, clientName);
	}
	
	public List findByClientPhone(Object clientPhone) {
		return findByProperty(CLIENT_PHONE, clientPhone);
	}
	
	public List findByClientEmail(Object clientEmail) {
		return findByProperty(CLIENT_EMAIL, clientEmail);
	}
	
	public List findByClientPostId(Object clientPostId) {
		return findByProperty(CLIENT_POST_ID, clientPostId);
	}
	
	public List findByClientAddress(Object clientAddress) {
		return findByProperty(CLIENT_ADDRESS, clientAddress);
	}
	
    public TClientInfo merge(TClientInfo detachedInstance) {
        log.debug("merging TClientInfo instance");
        try {
            TClientInfo result = (TClientInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TClientInfo instance) {
        log.debug("attaching dirty TClientInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TClientInfo instance) {
        log.debug("attaching clean TClientInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TClientInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TClientInfoDAO) ctx.getBean("TClientInfoDAO");
	}
}