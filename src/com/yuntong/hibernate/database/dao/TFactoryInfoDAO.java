package com.yuntong.hibernate.database.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
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

import com.yuntong.hibernate.database.po.TClientInfo;
import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TUserInfo;

/**
 * Data access object (DAO) for domain model class TFactoryInfo.
 * @see com.yuntong.hibernate.database.dao.TFactoryInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TFactoryInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TFactoryInfoDAO.class);

	//property constants
	public static final String FACTORY_NAME = "factoryName";
	public static final String FACTORY_LINKMAN = "factoryLinkman";
	public static final String FACTORY_ADDRESS = "factoryAddress";
	public static final String FACTORY_PHONE = "factoryPhone";
	public static final String FACTORY_FAX = "factoryFax";
	public static final String FACTORY_POST_ID = "factoryPostId";
	public static final String FACTORY_EMAIL = "factoryEmail";
	public static final String FACTORY_CONSUMPTION = "factoryConsumption";
	public static final String FACTORY_REMARK = "factoryRemark";

	protected void initDao() {
		//do nothing
	}
	   public List FindAll(){
	    	SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	        Session session=sessionfactory.openSession();
	        Query query=session.createQuery("from TFactoryInfo"); 
	        List list=query.list();
	    	
			return list;
	    	
	    	
	    	
	    }
	   //查出前十
	   public List findTopTen(int fid){
		   SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	        Session session=sessionfactory.openSession();	        
	        Query query=session.createQuery("from TFactoryInfo info where info.factoryId like  '"+fid+"%'");
	        List list=query.list();
		   return list;
	   }
	   //各个等级会员比例
	   public List findConsumption(){
		   SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	        Session session=sessionfactory.openSession();
	        Query query;
	        List temps=new ArrayList();
	        int temp=0;
	        for (int i = 1; i < 6; i++) {
	        	query=session.createQuery("from TFactoryInfo f where f.TGrade.gradeId="+i+"");
	        	temp=query.list().size();
	        	temps.add(temp);
			}	        	    	
			return temps;
	   }
//	按消费排行查询
	   public List findInfoOrderByMoney(){
		   SessionFactory sessionfactory= getHibernateTemplate().getSessionFactory();
	        Session session=sessionfactory.openSession();
	        Query query=session.createQuery("from TFactoryInfo f order by f.factoryConsumption desc"); 
	        List list=query.list();
	    	
			return list;
	   }
//	得到所有厂商信息
    public List findAllFactoryInfo(){    	 	
    	 List list=getHibernateTemplate().loadAll(TFactoryInfo.class);
    	 log.debug("得到所有厂商信息");
    	 return list;
    }
    public void save(TFactoryInfo transientInstance) {
        log.debug("saving TFactoryInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TFactoryInfo persistentInstance) {
        log.debug("deleting TFactoryInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TFactoryInfo findById( java.lang.Integer id) {
        log.debug("getting TFactoryInfo instance with id: " + id);
        try {
            TFactoryInfo instance = (TFactoryInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TFactoryInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    public List findMaxID(){
    	List list=getHibernateTemplate().find("select max(factoryId) from TFactoryInfo");
    	return list;
    }
    
    public List findByExample(TFactoryInfo instance) {
        log.debug("finding TFactoryInfo instance by example");
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
      log.debug("finding TFactoryInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TFactoryInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFactoryName(Object factoryName) {
		return findByProperty(FACTORY_NAME, factoryName);
	}
	
	public List findByFactoryLinkman(Object factoryLinkman) {
		return findByProperty(FACTORY_LINKMAN, factoryLinkman);
	}
	
	public List findByFactoryAddress(Object factoryAddress) {
		return findByProperty(FACTORY_ADDRESS, factoryAddress);
	}
	
	public List findByFactoryPhone(Object factoryPhone) {
		return findByProperty(FACTORY_PHONE, factoryPhone);
	}
	
	public List findByFactoryFax(Object factoryFax) {
		return findByProperty(FACTORY_FAX, factoryFax);
	}
	
	public List findByFactoryPostId(Object factoryPostId) {
		return findByProperty(FACTORY_POST_ID, factoryPostId);
	}
	
	public List findByFactoryEmail(Object factoryEmail) {
		return findByProperty(FACTORY_EMAIL, factoryEmail);
	}
	
	public List findByFactoryConsumption(Object factoryConsumption) {
		return findByProperty(FACTORY_CONSUMPTION, factoryConsumption);
	}
	
	public List findByFactoryRemark(Object factoryRemark) {
		return findByProperty(FACTORY_REMARK, factoryRemark);
	}
	
    public TFactoryInfo merge(TFactoryInfo detachedInstance) {
        log.debug("merging TFactoryInfo instance");
        try {
            TFactoryInfo result = (TFactoryInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TFactoryInfo instance) {
        log.debug("attaching dirty TFactoryInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TFactoryInfo instance) {
        log.debug("attaching clean TFactoryInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TFactoryInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TFactoryInfoDAO) ctx.getBean("TFactoryInfoDAO");
	}
}