package com.yuntong.hibernate.database.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TAffiche;

/**
 * Data access object (DAO) for domain model class TAffiche.
 * @see com.yuntong.hibernate.database.dao.TAffiche
 * @author MyEclipse - Hibernate Tools
 */
public class TAfficheDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TAfficheDAO.class);

	//property constants
	public static final String AFFICHE_TITLE = "afficheTitle";
	public static final String AFFICHE_INFO = "afficheInfo";

	protected void initDao() {
		//do nothing
	}
	//得到最新信息
	public TAffiche findTopDate(){
		String hql="from TAffiche as t order by t.afficheDateTime desc";
		List list=getHibernateTemplate().find(hql);
		TAffiche temp=((TAffiche)(list.get(0)));
		return temp;
	}
    
    public void save(TAffiche transientInstance) {
        log.debug("saving TAffiche instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TAffiche persistentInstance) {
        log.debug("deleting TAffiche instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TAffiche findById( java.lang.Integer id) {
        log.debug("getting TAffiche instance with id: " + id);
        try {
            TAffiche instance = (TAffiche) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TAffiche", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TAffiche instance) {
        log.debug("finding TAffiche instance by example");
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
      log.debug("finding TAffiche instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TAffiche as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAfficheTitle(Object afficheTitle) {
		return findByProperty(AFFICHE_TITLE, afficheTitle);
	}
	
	public List findByAfficheInfo(Object afficheInfo) {
		return findByProperty(AFFICHE_INFO, afficheInfo);
	}
	
    public TAffiche merge(TAffiche detachedInstance) {
        log.debug("merging TAffiche instance");
        try {
            TAffiche result = (TAffiche) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TAffiche instance) {
        log.debug("attaching dirty TAffiche instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TAffiche instance) {
        log.debug("attaching clean TAffiche instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TAfficheDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TAfficheDAO) ctx.getBean("TAfficheDAO");
	}
}