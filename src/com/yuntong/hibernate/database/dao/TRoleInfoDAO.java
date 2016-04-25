package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TFactoryInfo;
import com.yuntong.hibernate.database.po.TRoleInfo;

/**
 * Data access object (DAO) for domain model class TRoleInfo.
 * @see com.yuntong.hibernate.database.dao.TRoleInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TRoleInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TRoleInfoDAO.class);

	//property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_USER_MANAGER = "roleUserManager";
	public static final String ROLE_GOODS_MANAGER = "roleGoodsManager";
	public static final String ROLE_TICKET_MANAGER = "roleTicketManager";
	public static final String ROLE_SQUARE_MANAGER = "roleSquareManager";
	public static final String ROLE_MARKET_MANAGER = "roleMarketManager";
	public static final String ROLE_TRAFFIC_MANAGER = "roleTrafficManager";
	public static final String ROLE_PARAMETER_MANAGER = "roleParameterManager";
	public static final String ROLE_DATA_MANAGER = "roleDataManager";
	public static final String ROLE_REPORT_MANAGER = "roleReportManager";

	protected void initDao() {
		//do nothing
	}
	//得到权限比例
	
	//修改权限
	public void updataRoleInfo(int SHGL,int PWGL,int PSGL,int CWGL,int SCGL,int TJCX,int JBZL,int roleId){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction tr=session.beginTransaction();
    	TRoleInfo ri=(TRoleInfo) session.get(TRoleInfo.class, roleId);
    	ri.setRoleSHGL(SHGL);
    	ri.setRolePWGL(PWGL);
    	ri.setRolePSGL(PSGL);
    	ri.setRoleCWGL(CWGL);
    	ri.setRoleSCGL(SCGL);
    	ri.setRoleTJCX(TJCX);
    	ri.setRoleJBZL(JBZL);
    	tr.commit();
	}
	//得到所有权限信息
	public List findAllRoleInfo(){
		List list=getHibernateTemplate().loadAll(TRoleInfo.class);
   	 	log.info("===================================得到所有权限信息==================================");
   	 	return list;		
	}
    
    public void save(TRoleInfo transientInstance) {
        log.debug("saving TRoleInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TRoleInfo persistentInstance) {
        log.debug("deleting TRoleInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TRoleInfo findById( java.lang.Integer id) {
        log.debug("getting TRoleInfo instance with id: " + id);
        try {
            TRoleInfo instance = (TRoleInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TRoleInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TRoleInfo instance) {
        log.debug("finding TRoleInfo instance by example");
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
      log.debug("finding TRoleInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TRoleInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}
	
	public List findByRoleUserManager(Object roleUserManager) {
		return findByProperty(ROLE_USER_MANAGER, roleUserManager);
	}
	
	public List findByRoleGoodsManager(Object roleGoodsManager) {
		return findByProperty(ROLE_GOODS_MANAGER, roleGoodsManager);
	}
	
	public List findByRoleTicketManager(Object roleTicketManager) {
		return findByProperty(ROLE_TICKET_MANAGER, roleTicketManager);
	}
	
	public List findByRoleSquareManager(Object roleSquareManager) {
		return findByProperty(ROLE_SQUARE_MANAGER, roleSquareManager);
	}
	
	public List findByRoleMarketManager(Object roleMarketManager) {
		return findByProperty(ROLE_MARKET_MANAGER, roleMarketManager);
	}
	
	public List findByRoleTrafficManager(Object roleTrafficManager) {
		return findByProperty(ROLE_TRAFFIC_MANAGER, roleTrafficManager);
	}
	
	public List findByRoleParameterManager(Object roleParameterManager) {
		return findByProperty(ROLE_PARAMETER_MANAGER, roleParameterManager);
	}
	
	public List findByRoleDataManager(Object roleDataManager) {
		return findByProperty(ROLE_DATA_MANAGER, roleDataManager);
	}
	
	public List findByRoleReportManager(Object roleReportManager) {
		return findByProperty(ROLE_REPORT_MANAGER, roleReportManager);
	}
	
    public TRoleInfo merge(TRoleInfo detachedInstance) {
        log.debug("merging TRoleInfo instance");
        try {
            TRoleInfo result = (TRoleInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TRoleInfo instance) {
        log.debug("attaching dirty TRoleInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TRoleInfo instance) {
        log.debug("attaching clean TRoleInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TRoleInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TRoleInfoDAO) ctx.getBean("TRoleInfoDAO");
	}
}