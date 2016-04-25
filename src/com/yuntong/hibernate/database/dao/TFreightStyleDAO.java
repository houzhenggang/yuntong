package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TFreightStyle;

/**
 * Data access object (DAO) for domain model class TFreightStyle.
 * @see com.yuntong.hibernate.database.dao.TFreightStyle
 * @author MyEclipse - Hibernate Tools
 */
public class TFreightStyleDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TFreightStyleDAO.class);

	//property constants
	public static final String FREIGHT_NAME = "freightName";
	public static final String FREIGHT_REMARK = "freightRemark";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TFreightStyle transientInstance) {
        log.debug("saving TFreightStyle instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TFreightStyle persistentInstance) {
        log.debug("deleting TFreightStyle instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TFreightStyle findById( java.lang.Integer id) {
        log.debug("getting TFreightStyle instance with id: " + id);
        try {
            TFreightStyle instance = (TFreightStyle) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TFreightStyle", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
//	findall
    public List findAllFreightInfo(){
    	return getHibernateTemplate().loadAll(TFreightStyle.class);
    }
    
    public List findByExample(TFreightStyle instance) {
        log.debug("finding TFreightStyle instance by example");
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
      log.debug("finding TFreightStyle instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TFreightStyle as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFreightName(Object freightName) {
		return findByProperty(FREIGHT_NAME, freightName);
	}
	
	public List findByFreightRemark(Object freightRemark) {
		return findByProperty(FREIGHT_REMARK, freightRemark);
	}
	
    public TFreightStyle merge(TFreightStyle detachedInstance) {
        log.debug("merging TFreightStyle instance");
        try {
            TFreightStyle result = (TFreightStyle) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TFreightStyle instance) {
        log.debug("attaching dirty TFreightStyle instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TFreightStyle instance) {
        log.debug("attaching clean TFreightStyle instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TFreightStyleDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TFreightStyleDAO) ctx.getBean("TFreightStyleDAO");
	}
}