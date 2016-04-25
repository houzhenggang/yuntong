package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TAreaInfo;

/**
 * Data access object (DAO) for domain model class TAreaInfo.
 * @see com.yuntong.hibernate.database.dao.TAreaInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TAreaInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TAreaInfoDAO.class);

	//property constants
	public static final String AREA_PROVINCE = "areaProvince";
	public static final String AREA_CITY = "areaCity";
	public static final String AREA_FILIALE_TYPE = "areaFilialeType";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TAreaInfo transientInstance) {
        log.debug("saving TAreaInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    public List findAllAreaInfo(){
    	return getHibernateTemplate().loadAll(TAreaInfo.class);
    }
	public void delete(TAreaInfo persistentInstance) {
        log.debug("deleting TAreaInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TAreaInfo findById( java.lang.Integer id) {
        log.debug("getting TAreaInfo instance with id: " + id);
        try {
            TAreaInfo instance = (TAreaInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TAreaInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TAreaInfo instance) {
        log.debug("finding TAreaInfo instance by example");
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
      log.debug("finding TAreaInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TAreaInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAreaProvince(Object areaProvince) {
		return findByProperty(AREA_PROVINCE, areaProvince);
	}
	
	public List findByAreaCity(Object areaCity) {
		return findByProperty(AREA_CITY, areaCity);
	}
	
	public List findByAreaFilialeType(Object areaFilialeType) {
		return findByProperty(AREA_FILIALE_TYPE, areaFilialeType);
	}
	
    public TAreaInfo merge(TAreaInfo detachedInstance) {
        log.debug("merging TAreaInfo instance");
        try {
            TAreaInfo result = (TAreaInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TAreaInfo instance) {
        log.debug("attaching dirty TAreaInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TAreaInfo instance) {
        log.debug("attaching clean TAreaInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TAreaInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TAreaInfoDAO) ctx.getBean("TAreaInfoDAO");
	}
}