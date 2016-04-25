package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TDriverInfo;
import com.yuntong.hibernate.database.po.TTruckInfo;

/**
 * Data access object (DAO) for domain model class TDriverInfo.
 * @see com.yuntong.hibernate.database.dao.TDriverInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TDriverInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TDriverInfoDAO.class);

	//property constants
	public static final String DRIVER_NAME = "driverName";
	public static final String DRIVER_AGE = "driverAge";
	public static final String DRIVER_SEX = "driverSex";
	public static final String DRIVER_PHOTO = "driverPhoto";
	public static final String DRIVER_DRIVER_CARD_ID = "driverDriverCardId";
	public static final String DRIVER_CARD_ID = "driverCardId";
	public static final String DRIVER_PHONE_NUM = "driverPhoneNum";
	public static final String DRIVER_REMARK_INFO = "driverRemarkInfo";
	private static final String DRIVER_IS_LEISRUE = "isLeisure";

	protected void initDao() {
		//do nothing
	}
	//修改司机状态为空闲
	public void updateDriverState(int did){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction tx= session.beginTransaction();
    	TDriverInfo info=(TDriverInfo) session.get(TDriverInfo.class, did);    	
    	info.setIsLeisure(0);
    	session.save(info);
    	tx.commit();
	}
    
    public void save(TDriverInfo transientInstance) {
        log.debug("saving TDriverInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TDriverInfo persistentInstance) {
        log.debug("deleting TDriverInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TDriverInfo findById( java.lang.Integer id) {
        log.debug("getting TDriverInfo instance with id: " + id);
        try {
            TDriverInfo instance = (TDriverInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TDriverInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TDriverInfo instance) {
        log.debug("finding TDriverInfo instance by example");
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
      log.debug("finding TDriverInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TDriverInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDriverName(Object driverName) {
		return findByProperty(DRIVER_NAME, driverName);
	}
	
	public List findByDriverAge(Object driverAge) {
		return findByProperty(DRIVER_AGE, driverAge);
	}
	
	public List findByDriverSex(Object driverSex) {
		return findByProperty(DRIVER_SEX, driverSex);
	}
	
	public List findByDriverPhoto(Object driverPhoto) {
		return findByProperty(DRIVER_PHOTO, driverPhoto);
	}
	
	public List findByDriverDriverCardId(Object driverDriverCardId) {
		return findByProperty(DRIVER_DRIVER_CARD_ID, driverDriverCardId);
	}
	
	public List findByDriverCardId(Object driverCardId) {
		return findByProperty(DRIVER_CARD_ID, driverCardId);
	}
	
	public List findByDriverPhoneNum(Object driverPhoneNum) {
		return findByProperty(DRIVER_PHONE_NUM, driverPhoneNum);
	}
	
	public List findByDriverRemarkInfo(Object driverRemarkInfo) {
		
		return findByProperty(DRIVER_REMARK_INFO, driverRemarkInfo);
	}
	public List findByDriverIsLeisure(Object isLeisure){
		return findByProperty(DRIVER_IS_LEISRUE,isLeisure);
	}
    public TDriverInfo merge(TDriverInfo detachedInstance) {
        log.debug("merging TDriverInfo instance");
        try {
            TDriverInfo result = (TDriverInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TDriverInfo instance) {
        log.debug("attaching dirty TDriverInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TDriverInfo instance) {
        log.debug("attaching clean TDriverInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TDriverInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TDriverInfoDAO) ctx.getBean("TDriverInfoDAO");
	}
	public List getDriverInfoByName(String name){
		Criteria criteria=getSession().createCriteria(TDriverInfo.class);
		return criteria.add(Expression.eq("driverName",name)).list();
	}
	public int getTotalPage(){
		String hql="select count(*) from TDriverInfo info";
		Query query=getSession().createQuery(hql);
		return (Integer)query.list().get(0);
	}
	public List getAllDriverInfo(int pageSize, int curPage){
		Criteria criteria=getSession().createCriteria(TDriverInfo.class);
		int page=pageSize*(curPage-1);
		criteria.setFirstResult(page);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	public void update(Object object){
		getHibernateTemplate().update(object);
		
	}
}