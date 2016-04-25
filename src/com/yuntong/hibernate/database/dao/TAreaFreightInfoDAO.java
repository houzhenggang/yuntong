package com.yuntong.hibernate.database.dao;

import java.util.ArrayList;
import java.util.Date;
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

import com.yuntong.hibernate.database.po.TAreaFreightInfo;
import com.yuntong.hibernate.database.po.TAreaInfo;
import com.yuntong.hibernate.database.po.TUserInfo;


/**
 * Data access object (DAO) for domain model class TAreaFreightInfo.
 * @see com.yuntong.hibernate.database.dao.TAreaFreightInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TAreaFreightInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TAreaFreightInfoDAO.class);

	//property constants
	public static final String AFRERGHT_TIME = "afrerghtTime";
	public static final String AFRERGHT_HEFT = "afrerghtHeft";
	public static final String AFRERGHT_BULK = "afrerghtBulk";

	protected void initDao() {
		//do nothing
	}
	//添加记录并判断是否有重复记录
	public boolean addAFinfo(int iid,int stid,int enid,int pjtime,float zhong,float fang){
		//判断记录重复
		if(stid==enid){
			return false;
		}
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(TAreaFreightInfo.class);
		c.add(Expression.eq("TAreaInfoByAfrerghtBegin.areaInfoId", stid));
		c.add(Expression.eq("TAreaInfoByAfrerghtEnd.areaInfoId", enid));
		if(c.list().size()!=0&&iid==0){
			return false;
		}
		//插入或修改记录
		TAreaInfo info1=new TAreaInfo();
		info1.setAreaInfoId(stid);
		TAreaInfo info2=new TAreaInfo();
		info2.setAreaInfoId(enid);
		TAreaFreightInfo af=new TAreaFreightInfo();
		af.setTAreaInfoByAfrerghtBegin(info1);
		af.setTAreaInfoByAfrerghtEnd(info2);
		af.setAfrerghtTime(pjtime);
		af.setAfrerghtHeft(zhong);
		af.setAfrerghtBulk(fang);
		if(iid!=0){
			af.setAfrerghtId(iid);
		}
		getHibernateTemplate().saveOrUpdate(af);
		return true;
	}
	//根据页面大小得到总页数(页面大小，其始地编号，目的地编号)
	public int getPageNum(int pageSize, int strid, int endid) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(TAreaFreightInfo.class);
		// 判断查询条件
		if (strid != 0) {
			c.add(Expression.eq("TAreaInfoByAfrerghtBegin.areaInfoId", strid));
		}
		if (endid != 0) {
			c.add(Expression.eq("TAreaInfoByAfrerghtEnd.areaInfoId", endid));
		}		
		List list = new ArrayList();
		list = c.list();
		int count = list.size();
		return (int) Math.ceil((double) count / pageSize);
	}

	// 分页得到费用信息(页面大小，当前页数,其始地编号，目的地编号)
	public List findSplitRegister(int pageSize, int curPage, int strid,int endid) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(TAreaFreightInfo.class);
		//判断查询条件
		if (strid != 0) {
			c.add(Expression.eq("TAreaInfoByAfrerghtBegin.areaInfoId", strid));
		}
		if (endid != 0) {
			c.add(Expression.eq("TAreaInfoByAfrerghtEnd.areaInfoId", endid));
		}				
		// 根据当前页数和页面大小，得到从第几条记录开始查询
		int count = pageSize * (curPage - 1);
		c.setFirstResult(count);
		// 设置页面大小
		c.setMaxResults(pageSize);
		return c.list();
	}
    //得到所有的信息
	public List findAllInfo(){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Criteria c=session.createCriteria(TAreaFreightInfo.class);
    	List list=c.list();
		return list;
	}
	//根据编号删除信息
	public void deleteInfoByID(int afId) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete TAreaFreightInfo where afrerghtId=" + afId + "";
		log.info("语句==" + hql);
		try {
			Query query = session.createQuery(hql);
			query.executeUpdate();
			log.info("删除运费信息成功=================");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除运费信息失败=================");
			tx.rollback();
		}
		tx.commit();
	}
    public void save(TAreaFreightInfo transientInstance) {
        log.debug("saving TAreaFreightInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TAreaFreightInfo persistentInstance) {
        log.debug("deleting TAreaFreightInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TAreaFreightInfo findById( java.lang.Integer id) {
        log.debug("getting TAreaFreightInfo instance with id: " + id);
        try {
            TAreaFreightInfo instance = (TAreaFreightInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TAreaFreightInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TAreaFreightInfo instance) {
        log.debug("finding TAreaFreightInfo instance by example");
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
      log.debug("finding TAreaFreightInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TAreaFreightInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAfrerghtTime(Object afrerghtTime) {
		return findByProperty(AFRERGHT_TIME, afrerghtTime);
	}
	
	public List findByAfrerghtHeft(Object afrerghtHeft) {
		return findByProperty(AFRERGHT_HEFT, afrerghtHeft);
	}
	
	public List findByAfrerghtBulk(Object afrerghtBulk) {
		return findByProperty(AFRERGHT_BULK, afrerghtBulk);
	}
	
    public TAreaFreightInfo merge(TAreaFreightInfo detachedInstance) {
        log.debug("merging TAreaFreightInfo instance");
        try {
            TAreaFreightInfo result = (TAreaFreightInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TAreaFreightInfo instance) {
        log.debug("attaching dirty TAreaFreightInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TAreaFreightInfo instance) {
        log.debug("attaching clean TAreaFreightInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TAreaFreightInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TAreaFreightInfoDAO) ctx.getBean("TAreaFreightInfoDAO");
	}
}