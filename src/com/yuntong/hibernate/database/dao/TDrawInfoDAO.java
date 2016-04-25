package com.yuntong.hibernate.database.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.yuntong.hibernate.database.po.TDrawInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;

/**
 * Data access object (DAO) for domain model class TDrawInfo.
 * @see com.yuntong.hibernate.database.dao.TDrawInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TDrawInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TDrawInfoDAO.class);

	//property constants
	public static final String DRAW_ROADWAY_ID = "drawRoadwayId";

	protected void initDao() {
		//do nothing
	}

    public void save(TDrawInfo transientInstance) {
        log.debug("saving TDrawInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TDrawInfo persistentInstance) {
        log.debug("deleting TDrawInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
	//根据货票编号得到领票信息
	public TDrawInfo findDrawInfoByRegisterID(int rid){
		log.info("根据货票编号得到领票信息: " + rid);
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();    	    	    	    		
    	Criteria cr=session.createCriteria(TDrawInfo.class);
    	TDrawInfo dinfo=new TDrawInfo();
    	for (int i = 0; i < cr.list().size(); i++) {    		
			if(((TDrawInfo)(cr.list().get(i))).getTRegisterInfo().getRegisterId()==rid){
				dinfo=(TDrawInfo) (cr.list().get(i));
			}
		}
    	log.info("===================得到领票信息=========================");    	
		return dinfo;
	}
    
    public TDrawInfo findById( java.lang.Integer id) {
        log.debug("getting TDrawInfo instance with id: " + id);
        try {
            TDrawInfo instance = (TDrawInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.dao.TDrawInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TDrawInfo instance) {
        log.debug("finding TDrawInfo instance by example");
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
      log.debug("finding TDrawInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TDrawInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDrawRoadwayId(Object drawRoadwayId) {
		return findByProperty(DRAW_ROADWAY_ID, drawRoadwayId);
	}
	
    public TDrawInfo merge(TDrawInfo detachedInstance) {
        log.debug("merging TDrawInfo instance");
        try {
            TDrawInfo result = (TDrawInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TDrawInfo instance) {
        log.debug("attaching dirty TDrawInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TDrawInfo instance) {
        log.debug("attaching clean TDrawInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TDrawInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TDrawInfoDAO) ctx.getBean("TDrawInfoDAO");
	}
}