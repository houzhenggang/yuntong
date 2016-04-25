package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TPartner;

/**
 * Data access object (DAO) for domain model class TPartner.
 * @see com.yuntong.hibernate.database.dao.TPartner
 * @author MyEclipse - Hibernate Tools
 */
public class TPartnerDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TPartnerDAO.class);

	//property constants
	public static final String PARTNER_TYPE = "partnerType";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TPartner transientInstance) {
        log.debug("saving TPartner instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TPartner persistentInstance) {
        log.debug("deleting TPartner instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TPartner findById( java.lang.Integer id) {
        log.debug("getting TPartner instance with id: " + id);
        try {
            TPartner instance = (TPartner) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TPartner", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TPartner instance) {
        log.debug("finding TPartner instance by example");
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
      log.debug("finding TPartner instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TPartner as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPartnerType(Object partnerType) {
		return findByProperty(PARTNER_TYPE, partnerType);
	}
	
    public TPartner merge(TPartner detachedInstance) {
        log.debug("merging TPartner instance");
        try {
            TPartner result = (TPartner) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TPartner instance) {
        log.debug("attaching dirty TPartner instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TPartner instance) {
        log.debug("attaching clean TPartner instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TPartnerDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TPartnerDAO) ctx.getBean("TPartnerDAO");
	}
}