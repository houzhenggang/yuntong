package com.yuntong.hibernate.database.dao;

import java.util.List;
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

import com.yuntong.hibernate.database.HibernateSessionFactory;
import com.yuntong.hibernate.database.po.TTruckInfo;
import com.yuntong.hibernate.database.po.TTruckStyle;

/**
 * Data access object (DAO) for domain model class TTruckInfo.
 * @see com.yuntong.hibernate.database.dao.TTruckInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TTruckInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TTruckInfoDAO.class);

	//property constants
	public static final String TRUCK_NUM = "truckNum";
	public static final String TRUCK_ENGINE_NUM = "truckEngineNum";
	public static final String TRUCK_RUN_NUM = "truckRunNum";
	public static final String TRUCK_INSURANCE_NUM = "truckInsuranceNum";
	public static final String TRUCK_COLOR = "truckColor";
	public static final String TRUCK_PHOTO = "truckPhoto";
	public static final String TRUCK_FIXED = "truckFixed";
	public static final String TRUCK_IS_LEISRUE="isLeisure";
	protected void initDao() {
		//do nothing
	}
	//车辆添加google
	public List findTopTen(String carid){
		System.out.println("daodaodaodaodaodaodao");
		System.out.println(carid);
		String hql="";
					
		hql="from TTruckInfo info where info.truckNum like "+carid+"% ";		
		Query query=getSession().createQuery(hql);
		 return query.list();
	}
    //根据车辆编号修改车辆状态为空闲
	public void updataCarState(int carid){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction tx= session.beginTransaction();
    	TTruckInfo info=(TTruckInfo) session.get(TTruckInfo.class, carid);    	
    	info.setIsLeisure(0);
    	session.save(info);
    	tx.commit();
	}
    public void save(TTruckInfo transientInstance) {
        log.debug("saving TTruckInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TTruckInfo persistentInstance) {
        log.debug("deleting TTruckInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TTruckInfo findById( java.lang.Integer id) {
        log.debug("getting TTruckInfo instance with id: " + id);
        try {
            TTruckInfo instance = (TTruckInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TTruckInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TTruckInfo instance) {
        log.debug("finding TTruckInfo instance by example");
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
      log.debug("finding TTruckInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TTruckInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTruckNum(Object truckNum) {
		return findByProperty(TRUCK_NUM, truckNum);
	}
	
	public List findByTruckEngineNum(Object truckEngineNum) {
		return findByProperty(TRUCK_ENGINE_NUM, truckEngineNum);
	}
	
	public List findByTruckRunNum(Object truckRunNum) {
		return findByProperty(TRUCK_RUN_NUM, truckRunNum);
	}
	
	public List findByTruckInsuranceNum(Object truckInsuranceNum) {
		return findByProperty(TRUCK_INSURANCE_NUM, truckInsuranceNum);
	}
	
	public List findByTruckColor(Object truckColor) {
		return findByProperty(TRUCK_COLOR, truckColor);
	}
	
	public List findByTruckPhoto(Object truckPhoto) {
		return findByProperty(TRUCK_PHOTO, truckPhoto);
	}
	
	public List findByTruckFixed(Object truckFixed) {
		return findByProperty(TRUCK_FIXED, truckFixed);
	}
	public List findByTruckIsLeisure(Object isLeisure){
		return findByProperty(TRUCK_IS_LEISRUE, isLeisure);
	}
	
	public List findTruckInfoAndTruckStyleByTruckNum(Object truckNum){
		Criteria criteria= getSession().createCriteria(TTruckInfo.class);
		criteria.add(Expression.eq("truckNum", truckNum));
		List list= criteria.list();
		return list;
	}
	public List getTruckNum(int pageSize,int curPage){
		Criteria criteria=getSession().createCriteria(TTruckInfo.class);
//		Session session=HibernateSessionFactory.getSession();
//		Criteria criteria=session.createCriteria(TTruckInfo.class);
		int page=pageSize*(curPage-1); 
		criteria.setFirstResult(page);//游标位置
		criteria.setMaxResults(pageSize);//页面大小
		return criteria.list();
	}
	public int getTotalPage(){
		String hql="select count(*) from TTruckInfo info";
		Query query=getSession().createQuery(hql);
		return (Integer)query.list().get(0);
	}
	public static void main(String[] args) {
		TTruckInfoDAO d=new TTruckInfoDAO();
		
	}
    public TTruckInfo merge(TTruckInfo detachedInstance) {
        log.debug("merging TTruckInfo instance");
        try {
            TTruckInfo result = (TTruckInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TTruckInfo instance) {
        log.debug("attaching dirty TTruckInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TTruckInfo instance) {
        log.debug("attaching clean TTruckInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TTruckInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TTruckInfoDAO) ctx.getBean("TTruckInfoDAO");
	}
	
	public void update(Object object){
		getHibernateTemplate().update(object);
	}
}