package com.yuntong.hibernate.database.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TTrafficLog;

/**
 * Data access object (DAO) for domain model class TTrafficLog.
 * @see com.yuntong.hibernate.database.dao.TTrafficLog
 * @author MyEclipse - Hibernate Tools
 */
public class TTrafficLogDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TTrafficLogDAO.class);

	//property constants

	protected void initDao() {
		//do nothing
	}
    
    public void save(TTrafficLog transientInstance) {
        log.debug("saving TTrafficLog instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TTrafficLog persistentInstance) {
        log.debug("deleting TTrafficLog instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TTrafficLog findById( java.lang.Integer id) {
        log.debug("getting TTrafficLog instance with id: " + id);
        try {
            TTrafficLog instance = (TTrafficLog) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TTrafficLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TTrafficLog instance) {
        log.debug("finding TTrafficLog instance by example");
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
      log.debug("finding TTrafficLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TTrafficLog as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public TTrafficLog merge(TTrafficLog detachedInstance) {
        log.debug("merging TTrafficLog instance");
        try {
            TTrafficLog result = (TTrafficLog) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TTrafficLog instance) {
        log.debug("attaching dirty TTrafficLog instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TTrafficLog instance) {
        log.debug("attaching clean TTrafficLog instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TTrafficLogDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TTrafficLogDAO) ctx.getBean("TTrafficLogDAO");
	}
}