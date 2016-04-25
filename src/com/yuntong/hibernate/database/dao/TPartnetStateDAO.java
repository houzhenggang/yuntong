package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TPartnetState;

/**
 * Data access object (DAO) for domain model class TPartnetState.
 * @see com.yuntong.hibernate.database.dao.TPartnetState
 * @author MyEclipse - Hibernate Tools
 */
public class TPartnetStateDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TPartnetStateDAO.class);

	//property constants
	public static final String PARTNET_STATE_NAME = "partnetStateName";
	public static final String PARTNET_STATE_REMARK_INFO = "partnetStateRemarkInfo";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TPartnetState transientInstance) {
        log.debug("saving TPartnetState instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TPartnetState persistentInstance) {
        log.debug("deleting TPartnetState instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TPartnetState findById( java.lang.Integer id) {
        log.debug("getting TPartnetState instance with id: " + id);
        try {
            TPartnetState instance = (TPartnetState) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TPartnetState", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TPartnetState instance) {
        log.debug("finding TPartnetState instance by example");
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
      log.debug("finding TPartnetState instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TPartnetState as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPartnetStateName(Object partnetStateName) {
		return findByProperty(PARTNET_STATE_NAME, partnetStateName);
	}
	
	public List findByPartnetStateRemarkInfo(Object partnetStateRemarkInfo) {
		return findByProperty(PARTNET_STATE_REMARK_INFO, partnetStateRemarkInfo);
	}
	
    public TPartnetState merge(TPartnetState detachedInstance) {
        log.debug("merging TPartnetState instance");
        try {
            TPartnetState result = (TPartnetState) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TPartnetState instance) {
        log.debug("attaching dirty TPartnetState instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TPartnetState instance) {
        log.debug("attaching clean TPartnetState instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TPartnetStateDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TPartnetStateDAO) ctx.getBean("TPartnetStateDAO");
	}
}