package com.yuntong.hibernate.database.dao;

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

import com.yuntong.hibernate.database.po.TRegisterState;

/**
 * Data access object (DAO) for domain model class TRegisterState.
 * @see com.yuntong.hibernate.database.dao.TRegisterState
 * @author MyEclipse - Hibernate Tools
 */
public class TRegisterStateDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TRegisterStateDAO.class);

	//property constants
	public static final String RSTATE_NAME = "rstateName";
	public static final String RSTATE_REMARK = "rstateRemark";

	protected void initDao() {
		//do nothing
	}
	 public List getstateName(){
	    	SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	    Session session=sessionfactory.openSession();
	    Query query=session.createQuery("from TRegisterState"); 
	    List list=query.list();
	    
	    	return list;
	    	
	    }
    public void save(TRegisterState transientInstance) {
        log.debug("saving TRegisterState instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TRegisterState persistentInstance) {
        log.debug("deleting TRegisterState instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TRegisterState findById( java.lang.Integer id) {
        log.debug("getting TRegisterState instance with id: " + id);
        try {
            TRegisterState instance = (TRegisterState) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TRegisterState", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TRegisterState instance) {
        log.debug("finding TRegisterState instance by example");
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
      log.debug("finding TRegisterState instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TRegisterState as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRstateName(Object rstateName) {
		return findByProperty(RSTATE_NAME, rstateName);
	}
	
	public List findByRstateRemark(Object rstateRemark) {
		return findByProperty(RSTATE_REMARK, rstateRemark);
	}
	
    public TRegisterState merge(TRegisterState detachedInstance) {
        log.debug("merging TRegisterState instance");
        try {
            TRegisterState result = (TRegisterState) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TRegisterState instance) {
        log.debug("attaching dirty TRegisterState instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TRegisterState instance) {
        log.debug("attaching clean TRegisterState instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TRegisterStateDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TRegisterStateDAO) ctx.getBean("TRegisterStateDAO");
	}
}