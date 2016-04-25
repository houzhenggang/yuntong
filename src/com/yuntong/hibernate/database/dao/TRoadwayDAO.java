package com.yuntong.hibernate.database.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TRoadway;

/**
 * Data access object (DAO) for domain model class TRoadway.
 * @see com.yuntong.hibernate.database.dao.TRoadway
 * @author MyEclipse - Hibernate Tools
 */
public class TRoadwayDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TRoadwayDAO.class);

	//property constants

	protected void initDao() {
		//do nothing
	}
    //填加车次信息
    public void save(TRoadway transientInstance) {
        log.debug("saving TRoadway instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TRoadway persistentInstance) {
        log.debug("deleting TRoadway instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TRoadway findById( java.lang.Integer id) {
        log.debug("getting TRoadway instance with id: " + id);
        try {
            TRoadway instance = (TRoadway) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TRoadway", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TRoadway instance) {
        log.debug("finding TRoadway instance by example");
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
      log.debug("finding TRoadway instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TRoadway as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    public TRoadway merge(TRoadway detachedInstance) {
        log.debug("merging TRoadway instance");
        try {
            TRoadway result = (TRoadway) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TRoadway instance) {
        log.debug("attaching dirty TRoadway instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TRoadway instance) {
        log.debug("attaching clean TRoadway instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TRoadwayDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TRoadwayDAO) ctx.getBean("TRoadwayDAO");
	}
}