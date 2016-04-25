package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TPaymentOfGoodsStyle;

/**
 * Data access object (DAO) for domain model class TPaymentOfGoodsStyle.
 * @see com.yuntong.hibernate.database.dao.TPaymentOfGoodsStyle
 * @author MyEclipse - Hibernate Tools
 */
public class TPaymentOfGoodsStyleDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TPaymentOfGoodsStyleDAO.class);

	//property constants
	public static final String PAYMENT_NAME = "paymentName";
	public static final String PAYMENT_REMARK = "paymentRemark";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TPaymentOfGoodsStyle transientInstance) {
        log.debug("saving TPaymentOfGoodsStyle instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    //findall
    public List findAllPaymentInfo(){
    	return getHibernateTemplate().loadAll(TPaymentOfGoodsStyle.class);
    }
	public void delete(TPaymentOfGoodsStyle persistentInstance) {
        log.debug("deleting TPaymentOfGoodsStyle instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TPaymentOfGoodsStyle findById( java.lang.Integer id) {
        log.debug("getting TPaymentOfGoodsStyle instance with id: " + id);
        try {
            TPaymentOfGoodsStyle instance = (TPaymentOfGoodsStyle) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TPaymentOfGoodsStyle", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TPaymentOfGoodsStyle instance) {
        log.debug("finding TPaymentOfGoodsStyle instance by example");
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
      log.debug("finding TPaymentOfGoodsStyle instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TPaymentOfGoodsStyle as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPaymentName(Object paymentName) {
		return findByProperty(PAYMENT_NAME, paymentName);
	}
	
	public List findByPaymentRemark(Object paymentRemark) {
		return findByProperty(PAYMENT_REMARK, paymentRemark);
	}
	
    public TPaymentOfGoodsStyle merge(TPaymentOfGoodsStyle detachedInstance) {
        log.debug("merging TPaymentOfGoodsStyle instance");
        try {
            TPaymentOfGoodsStyle result = (TPaymentOfGoodsStyle) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TPaymentOfGoodsStyle instance) {
        log.debug("attaching dirty TPaymentOfGoodsStyle instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TPaymentOfGoodsStyle instance) {
        log.debug("attaching clean TPaymentOfGoodsStyle instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TPaymentOfGoodsStyleDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TPaymentOfGoodsStyleDAO) ctx.getBean("TPaymentOfGoodsStyleDAO");
	}
}