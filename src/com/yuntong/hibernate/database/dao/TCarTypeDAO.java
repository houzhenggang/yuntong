package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TCarType;

/**
 * Data access object (DAO) for domain model class TCarType.
 * @see com.yuntong.hibernate.database.dao.TCarType
 * @author MyEclipse - Hibernate Tools
 */
public class TCarTypeDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TCarTypeDAO.class);

	//property constants
	public static final String CAR_TYPE_NAME = "carTypeName";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TCarType transientInstance) {
        log.debug("saving TCarType instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TCarType persistentInstance) {
        log.debug("deleting TCarType instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TCarType findById( java.lang.Integer id) {
        log.debug("getting TCarType instance with id: " + id);
        try {
            TCarType instance = (TCarType) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TCarType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TCarType instance) {
        log.debug("finding TCarType instance by example");
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
      log.debug("finding TCarType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TCarType as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCarTypeName(Object carTypeName) {
		return findByProperty(CAR_TYPE_NAME, carTypeName);
	}
	
    public TCarType merge(TCarType detachedInstance) {
        log.debug("merging TCarType instance");
        try {
            TCarType result = (TCarType) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TCarType instance) {
        log.debug("attaching dirty TCarType instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TCarType instance) {
        log.debug("attaching clean TCarType instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TCarTypeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TCarTypeDAO) ctx.getBean("TCarTypeDAO");
	}
}