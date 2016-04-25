package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TFilialeInfo;

/**
 * Data access object (DAO) for domain model class TFilialeInfo.
 * @see com.yuntong.hibernate.database.dao.TFilialeInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TFilialeInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TFilialeInfoDAO.class);

	//property constants
	public static final String FILIALE_NAME = "filialeName";
	public static final String FILIALE_LINKMAN = "filialeLinkman";
	public static final String FILIALE_PHONE = "filialePhone";
	public static final String FILIALE_ADDRESS = "filialeAddress";
	public static final String FILIALE_EMAIL = "filialeEmail";

	protected void initDao() {
		//do nothing
	}
	 //得到所有分公司信息
    public List findAllFilialeInfo(){
    List list=getHibernateTemplate().loadAll(TFilialeInfo.class);
   	log.debug("得到所有分公司信息");
   	 return list;
    }
    public void save(TFilialeInfo transientInstance) {
        log.debug("saving TFilialeInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TFilialeInfo persistentInstance) {
        log.debug("deleting TFilialeInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TFilialeInfo findById( java.lang.Integer id) {
        log.debug("getting TFilialeInfo instance with id: " + id);
        try {
            TFilialeInfo instance = (TFilialeInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TFilialeInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TFilialeInfo instance) {
        log.debug("finding TFilialeInfo instance by example");
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
      log.debug("finding TFilialeInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TFilialeInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFilialeName(Object filialeName) {
		return findByProperty(FILIALE_NAME, filialeName);
	}
	
	public List findByFilialeLinkman(Object filialeLinkman) {
		return findByProperty(FILIALE_LINKMAN, filialeLinkman);
	}
	
	public List findByFilialePhone(Object filialePhone) {
		return findByProperty(FILIALE_PHONE, filialePhone);
	}
	
	public List findByFilialeAddress(Object filialeAddress) {
		return findByProperty(FILIALE_ADDRESS, filialeAddress);
	}
	
	public List findByFilialeEmail(Object filialeEmail) {
		return findByProperty(FILIALE_EMAIL, filialeEmail);
	}
	
    public TFilialeInfo merge(TFilialeInfo detachedInstance) {
        log.debug("merging TFilialeInfo instance");
        try {
            TFilialeInfo result = (TFilialeInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TFilialeInfo instance) {
        log.debug("attaching dirty TFilialeInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TFilialeInfo instance) {
        log.debug("attaching clean TFilialeInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TFilialeInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TFilialeInfoDAO) ctx.getBean("TFilialeInfoDAO");
	}
	public List getFilialeInfoNameAndID(){
		return getHibernateTemplate().loadAll(TFilialeInfo.class);
	}
}