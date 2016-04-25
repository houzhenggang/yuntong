package com.yuntong.hibernate.database.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TDisrepareInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRoadway;

/**
 * Data access object (DAO) for domain model class TDisrepareInfo.
 * @see com.yuntong.hibernate.database.dao.TDisrepareInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TDisrepareInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TDisrepareInfoDAO.class);

	//property constants
	public static final String DISREPARE_CAUSE = "disrepareCause";
	public static final String DISREPARE_MONEY = "disrepareMoney";
	public static final String DISREPARE_INDEMNITY = "disrepareIndemnity";
	public static final String DISREPARE_INDEMNITY_MAN = "disrepareIndemnityMan";

	protected void initDao() {
		//do nothing
	}
	
	
    //填加损货信息
    public void save(int rid,int roid,float money,String cause) {
    	TDisrepareInfo info=new TDisrepareInfo();    	
    	info.setDisrepareGoodsId(rid);
    	TRoadway tr=new TRoadway();
    	tr.setRoadwayId(roid);
    	info.setTRoadway(tr);
    	info.setDisrepareMoney(money);
    	info.setDisrepareCause(cause);
    	info.setDisrepareIndemnityMan("");
    	float temp=0;
    	info.setDisrepareIndemnity(temp);
        log.debug("saving TDisrepareInfo instance");
        try {
            getHibernateTemplate().save(info);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    //查找所用
    public List findByDisrepare(){
    	log.debug("finding TDisrepareInfo all message ");
    	try{
    		List results = getHibernateTemplate().loadAll(TDisrepareInfo.class);
            log.debug("find by example successful, result size: " + results.size());
            return results;
    	}catch(RuntimeException re){
    		log.error("find by property name failed", re);
            throw re;
    	}
    }
    
	public void delete(TDisrepareInfo persistentInstance) {
        log.debug("deleting TDisrepareInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TDisrepareInfo findById( java.lang.Integer id) {
        log.debug("getting TDisrepareInfo instance with id: " + id);
        try {
            TDisrepareInfo instance = (TDisrepareInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TDisrepareInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TDisrepareInfo instance) {
        log.debug("finding TDisrepareInfo instance by example");
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
      log.debug("finding TDisrepareInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TDisrepareInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDisrepareCause(Object disrepareCause) {
		return findByProperty(DISREPARE_CAUSE, disrepareCause);
	}
	
	public List findByDisrepareMoney(Object disrepareMoney) {
		return findByProperty(DISREPARE_MONEY, disrepareMoney);
	}
	
	public List findByDisrepareIndemnity(Object disrepareIndemnity) {
		return findByProperty(DISREPARE_INDEMNITY, disrepareIndemnity);
	}
	
	public List findByDisrepareIndemnityMan(Object disrepareIndemnityMan) {
		return findByProperty(DISREPARE_INDEMNITY_MAN, disrepareIndemnityMan);
	}
	
    public TDisrepareInfo merge(TDisrepareInfo detachedInstance) {
        log.debug("merging TDisrepareInfo instance");
        try {
            TDisrepareInfo result = (TDisrepareInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TDisrepareInfo instance) {
        log.debug("attaching dirty TDisrepareInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TDisrepareInfo instance) {
        log.debug("attaching clean TDisrepareInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TDisrepareInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TDisrepareInfoDAO) ctx.getBean("TDisrepareInfoDAO");
	}
}