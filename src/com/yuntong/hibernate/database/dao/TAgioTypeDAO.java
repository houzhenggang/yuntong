package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TAgioType;

/**
 * Data access object (DAO) for domain model class TAgioType.
 * @see com.yuntong.hibernate.database.dao.TAgioType
 * @author MyEclipse - Hibernate Tools
 */
public class TAgioTypeDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TAgioTypeDAO.class);

	//property constants
	public static final String ATYPE_NAME = "atypeName";
	public static final String ATYPE_INFO = "atypeInfo";

	protected void initDao() {
		//do nothing
	}
    
	//≤È’“À˘”–
	public List findAllAgioType(){
    	List list=getHibernateTemplate().find("from TAgioType");
    	
    	return list;
    }
	
    public void save(TAgioType transientInstance) {
        log.debug("saving TAgioType instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TAgioType persistentInstance) {
        log.debug("deleting TAgioType instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TAgioType findById( java.lang.Integer id) {
        log.debug("getting TAgioType instance with id: " + id);
        try {
            TAgioType instance = (TAgioType) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TAgioType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TAgioType instance) {
        log.debug("finding TAgioType instance by example");
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
      log.debug("finding TAgioType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TAgioType as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAtypeName(Object atypeName) {
		return findByProperty(ATYPE_NAME, atypeName);
	}
	
	public List findByAtypeInfo(Object atypeInfo) {
		return findByProperty(ATYPE_INFO, atypeInfo);
	}
	
    public TAgioType merge(TAgioType detachedInstance) {
        log.debug("merging TAgioType instance");
        try {
            TAgioType result = (TAgioType) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TAgioType instance) {
        log.debug("attaching dirty TAgioType instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TAgioType instance) {
        log.debug("attaching clean TAgioType instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TAgioTypeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TAgioTypeDAO) ctx.getBean("TAgioTypeDAO");
	}
}