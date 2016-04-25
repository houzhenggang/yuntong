package com.yuntong.hibernate.database.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TCue;

/**
 * Data access object (DAO) for domain model class TCue.
 * @see com.yuntong.hibernate.database.dao.TCue
 * @author MyEclipse - Hibernate Tools
 */
public class TCueDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TCueDAO.class);

	//property constants
	public static final String CUE_PLACE = "cuePlace";
	public static final String CUE_NAME = "cueName";
	public static final String CUE_INFO = "cueInfo";

	protected void initDao() {
		//do nothing
	}
	//得到所有提示信息
	public List findAllCue(){
		List list=getHibernateTemplate().loadAll(TCue.class);
		return list;
	}
    
    public void save(TCue transientInstance) {
        log.debug("saving TCue instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TCue persistentInstance) {
        log.debug("deleting TCue instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TCue findById( java.lang.Integer id) {
        log.debug("getting TCue instance with id: " + id);
        try {
            TCue instance = (TCue) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TCue", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TCue instance) {
        log.debug("finding TCue instance by example");
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
      log.debug("finding TCue instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TCue as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCuePlace(Object cuePlace) {
		return findByProperty(CUE_PLACE, cuePlace);
	}
	
	public List findByCueName(Object cueName) {
		return findByProperty(CUE_NAME, cueName);
	}
	
	public List findByCueInfo(Object cueInfo) {
		return findByProperty(CUE_INFO, cueInfo);
	}
	
    public TCue merge(TCue detachedInstance) {
        log.debug("merging TCue instance");
        try {
            TCue result = (TCue) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TCue instance) {
        log.debug("attaching dirty TCue instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TCue instance) {
        log.debug("attaching clean TCue instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TCueDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TCueDAO) ctx.getBean("TCueDAO");
	}
}