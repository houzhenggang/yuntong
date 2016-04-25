package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TTruckStyle;

/**
 * Data access object (DAO) for domain model class TTruckStyle.
 * @see com.yuntong.hibernate.database.dao.TTruckStyle
 * @author MyEclipse - Hibernate Tools
 */
public class TTruckStyleDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TTruckStyleDAO.class);

	//property constants
	public static final String TRUCK_STYLE_NAME = "truckStyleName";
	public static final String TRUCK_STYLE_TONNAGE = "truckStyleTonnage";
	public static final String TRUCK_STYLE_CUBAGE = "truckStyleCubage";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TTruckStyle transientInstance) {
        log.debug("saving TTruckStyle instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TTruckStyle persistentInstance) {
        log.debug("deleting TTruckStyle instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TTruckStyle findById( java.lang.Integer id) {
        log.debug("getting TTruckStyle instance with id: " + id);
        try {
            TTruckStyle instance = (TTruckStyle) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TTruckStyle", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TTruckStyle instance) {
        log.debug("finding TTruckStyle instance by example");
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
      log.debug("finding TTruckStyle instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TTruckStyle as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTruckStyleName(Object truckStyleName) {
		return findByProperty(TRUCK_STYLE_NAME, truckStyleName);
	}
	
	public List findByTruckStyleTonnage(Object truckStyleTonnage) {
		return findByProperty(TRUCK_STYLE_TONNAGE, truckStyleTonnage);
	}
	
	public List findByTruckStyleCubage(Object truckStyleCubage) {
		return findByProperty(TRUCK_STYLE_CUBAGE, truckStyleCubage);
	}
	
    public TTruckStyle merge(TTruckStyle detachedInstance) {
        log.debug("merging TTruckStyle instance");
        try {
            TTruckStyle result = (TTruckStyle) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TTruckStyle instance) {
        log.debug("attaching dirty TTruckStyle instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TTruckStyle instance) {
        log.debug("attaching clean TTruckStyle instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TTruckStyleDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TTruckStyleDAO) ctx.getBean("TTruckStyleDAO");
	}
	

	public List getAllTruckStyle(){
		return getHibernateTemplate().loadAll(TTruckStyle.class);
	}
}