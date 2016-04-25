package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TDepartment;

/**
 * Data access object (DAO) for domain model class TDepartment.
 * @see com.yuntong.hibernate.database.dao.TDepartment
 * @author MyEclipse - Hibernate Tools
 */
public class TDepartmentDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TDepartmentDAO.class);

	//property constants
	public static final String DEPARTMANT_NAME = "departmantName";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TDepartment transientInstance) {
        log.debug("saving TDepartment instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TDepartment persistentInstance) {
        log.debug("deleting TDepartment instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TDepartment findById( java.lang.Integer id) {
        log.debug("getting TDepartment instance with id: " + id);
        try {
            TDepartment instance = (TDepartment) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TDepartment", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TDepartment instance) {
        log.debug("finding TDepartment instance by example");
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
      log.debug("finding TDepartment instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TDepartment as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDepartmantName(Object departmantName) {
		return findByProperty(DEPARTMANT_NAME, departmantName);
	}
	
    public TDepartment merge(TDepartment detachedInstance) {
        log.debug("merging TDepartment instance");
        try {
            TDepartment result = (TDepartment) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TDepartment instance) {
        log.debug("attaching dirty TDepartment instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TDepartment instance) {
        log.debug("attaching clean TDepartment instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TDepartmentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TDepartmentDAO) ctx.getBean("TDepartmentDAO");
	}
}