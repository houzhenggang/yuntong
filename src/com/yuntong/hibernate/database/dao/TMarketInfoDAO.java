package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TMarketInfo;

/**
 * Data access object (DAO) for domain model class TMarketInfo.
 * @see com.yuntong.hibernate.database.dao.TMarketInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TMarketInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TMarketInfoDAO.class);

	//property constants
	public static final String MARKET_NAME = "marketName";
	public static final String MARKET_ADDRESS = "marketAddress";
	public static final String MARKEY_POST_ID = "markeyPostId";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TMarketInfo transientInstance) {
        log.debug("saving TMarketInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TMarketInfo persistentInstance) {
        log.debug("deleting TMarketInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TMarketInfo findById( java.lang.Integer id) {
        log.debug("getting TMarketInfo instance with id: " + id);
        try {
            TMarketInfo instance = (TMarketInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TMarketInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
//  根据地区编号查找市场信息
    public List findByAreaID(int areaID){
    	String queryString="from TMarketInfo info where info.TAreaInfo.areaInfoId="+areaID+"";
    	return getHibernateTemplate().find(queryString);
    }
    
    public List findByExample(TMarketInfo instance) {
        log.debug("finding TMarketInfo instance by example");
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
      log.debug("finding TMarketInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TMarketInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMarketName(Object marketName) {
		return findByProperty(MARKET_NAME, marketName);
	}
	
	public List findByMarketAddress(Object marketAddress) {
		return findByProperty(MARKET_ADDRESS, marketAddress);
	}
	
	public List findByMarkeyPostId(Object markeyPostId) {
		return findByProperty(MARKEY_POST_ID, markeyPostId);
	}
	
    public TMarketInfo merge(TMarketInfo detachedInstance) {
        log.debug("merging TMarketInfo instance");
        try {
            TMarketInfo result = (TMarketInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TMarketInfo instance) {
        log.debug("attaching dirty TMarketInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TMarketInfo instance) {
        log.debug("attaching clean TMarketInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TMarketInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TMarketInfoDAO) ctx.getBean("TMarketInfoDAO");
	}
	
	  /**
     * 得到所有市场信息
     * @param marketName
     * @return
     */
    public List findMarketInfo(){
    	return getHibernateTemplate().loadAll(TMarketInfo.class);
    } 
}