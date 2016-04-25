package com.yuntong.hibernate.database.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TAgioInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;

/**
 * Data access object (DAO) for domain model class TAgioInfo.
 * @see com.yuntong.hibernate.database.dao.TAgioInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TAgioInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TAgioInfoDAO.class);

	//property constants
	public static final String AGIO_MONEY = "agioMoney";
	public static final String AGIO_INFO = "agioInfo";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TAgioInfo transientInstance) {
        log.debug("saving TAgioInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    //查找所有
    public List findAllAgio(){
    	List list=getHibernateTemplate().find("from TAgioInfo");
    	
    	return list;
    }
    
	public void delete(TAgioInfo persistentInstance) {
        log.debug("deleting TAgioInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TAgioInfo findById( java.lang.Integer id) {
        log.debug("getting TAgioInfo instance with id: " + id);
        try {
            TAgioInfo instance = (TAgioInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TAgioInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TAgioInfo instance) {
        log.debug("finding TAgioInfo instance by example");
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
      log.debug("finding TAgioInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TAgioInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAgioMoney(Object agioMoney) {
		return findByProperty(AGIO_MONEY, agioMoney);
	}
	
	public List findByAgioInfo(Object agioInfo) {
		return findByProperty(AGIO_INFO, agioInfo);
	}
	
    public TAgioInfo merge(TAgioInfo detachedInstance) {
        log.debug("merging TAgioInfo instance");
        try {
            TAgioInfo result = (TAgioInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TAgioInfo instance) {
        log.debug("attaching dirty TAgioInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TAgioInfo instance) {
        log.debug("attaching clean TAgioInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    //自己写的方法开始
	public List getAllInfo() {
		log.debug("attaching clean TAgioInfo instance");
		try {
			String sql = "from TAgioInfo";
			List list = getHibernateTemplate().find(sql);
			
			return list;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}

	}

	public List selectInfo(String type, String value) {
		log.debug("attaching clean TAgioInfo instance");
		try {
			String sql = "from TAgioInfo where " + type + " like '%" + value + "%'";
			List list = getHibernateTemplate().find(sql);
			
			return list;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}

	}
	public List gettypeId(){
		String sql="from TAgioType";
		List list= getHibernateTemplate().find(sql);
		return list;
	}

    public List getRegisterId(){
    	List list=getHibernateTemplate().find("from TRegisterInfo");
    	return list;
    }
 
    
    public List findTopTen(int fid){
		   SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	        Session session=sessionfactory.openSession();
	        TRegisterInfo info=new TRegisterInfo();
	        info.setRegisterId(fid);
	        Query query=session.createQuery("from TAgioInfo info  where info.TRegisterInfo like  '"+fid+"%'");
	        List list=query.list();
	        session.close();
		   return list;
	   }
    //自己写的方法结束

	public static TAgioInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TAgioInfoDAO) ctx.getBean("TAgioInfoDAO");
	}
}