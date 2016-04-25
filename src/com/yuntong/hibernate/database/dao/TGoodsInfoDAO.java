package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TGoodsInfo;

/**
 * Data access object (DAO) for domain model class TGoodsInfo.
 * @see com.yuntong.hibernate.database.dao.TGoodsInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TGoodsInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TGoodsInfoDAO.class);

	//property constants
	public static final String GOODS_NAME = "goodsName";
	public static final String GOODS_HEFT = "goodsHeft";
	public static final String GOODS_BULK = "goodsBulk";
	public static final String GOODS_NUMBER = "goodsNumber";
	public static final String GOODS_NUMBER_UNIT = "goodsNumberUnit";
	public static final String GOODS_VALUE = "goodsValue";
	public static final String GOODS_FREIGHT = "goodsFreight";
	public static final String GOODS_INSURANCE_VALUE = "goodsInsuranceValue";
	public static final String GOODS_REMARK_INFO = "goodsRemarkInfo";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TGoodsInfo transientInstance) {
        log.debug("saving TGoodsInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TGoodsInfo persistentInstance) {
        log.debug("deleting TGoodsInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TGoodsInfo findById( java.lang.Integer id) {
        log.debug("getting TGoodsInfo instance with id: " + id);
        try {
            TGoodsInfo instance = (TGoodsInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TGoodsInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TGoodsInfo instance) {
        log.debug("finding TGoodsInfo instance by example");
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
      log.debug("finding TGoodsInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TGoodsInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}
	
	public List findByGoodsHeft(Object goodsHeft) {
		return findByProperty(GOODS_HEFT, goodsHeft);
	}
	
	public List findByGoodsBulk(Object goodsBulk) {
		return findByProperty(GOODS_BULK, goodsBulk);
	}
	
	public List findByGoodsNumber(Object goodsNumber) {
		return findByProperty(GOODS_NUMBER, goodsNumber);
	}
	
	public List findByGoodsNumberUnit(Object goodsNumberUnit) {
		return findByProperty(GOODS_NUMBER_UNIT, goodsNumberUnit);
	}
	
	public List findByGoodsValue(Object goodsValue) {
		return findByProperty(GOODS_VALUE, goodsValue);
	}
	
	public List findByGoodsFreight(Object goodsFreight) {
		return findByProperty(GOODS_FREIGHT, goodsFreight);
	}
	
	public List findByGoodsInsuranceValue(Object goodsInsuranceValue) {
		return findByProperty(GOODS_INSURANCE_VALUE, goodsInsuranceValue);
	}
	
	public List findByGoodsRemarkInfo(Object goodsRemarkInfo) {
		return findByProperty(GOODS_REMARK_INFO, goodsRemarkInfo);
	}
	
    public TGoodsInfo merge(TGoodsInfo detachedInstance) {
        log.debug("merging TGoodsInfo instance");
        try {
            TGoodsInfo result = (TGoodsInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TGoodsInfo instance) {
        log.debug("attaching dirty TGoodsInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TGoodsInfo instance) {
        log.debug("attaching clean TGoodsInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TGoodsInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TGoodsInfoDAO) ctx.getBean("TGoodsInfoDAO");
	}
}