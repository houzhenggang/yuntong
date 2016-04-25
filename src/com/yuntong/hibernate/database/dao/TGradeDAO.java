package com.yuntong.hibernate.database.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TGrade;

/**
 * Data access object (DAO) for domain model class TGrade.
 * @see com.yuntong.hibernate.database.dao.TGrade
 * @author MyEclipse - Hibernate Tools
 */
public class TGradeDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TGradeDAO.class);

	//property constants
	public static final String GRADE_NAME = "gradeName";
	public static final String GRADE_CONSUMPTION = "gradeConsumption";
	public static final String GRADE_RATE = "gradeRate";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TGrade transientInstance) {
        log.debug("saving TGrade instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TGrade persistentInstance) {
        log.debug("deleting TGrade instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TGrade findById( java.lang.Integer id) {
        log.debug("getting TGrade instance with id: " + id);
        try {
            TGrade instance = (TGrade) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TGrade", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TGrade instance) {
        log.debug("finding TGrade instance by example");
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
      log.debug("finding TGrade instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TGrade as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByGradeName(Object gradeName) {
		return findByProperty(GRADE_NAME, gradeName);
	}
	
	public List findByGradeConsumption(Object gradeConsumption) {
		return findByProperty(GRADE_CONSUMPTION, gradeConsumption);
	}
	
	public List findByGradeRate(Object gradeRate) {
		return findByProperty(GRADE_RATE, gradeRate);
	}
	
    public TGrade merge(TGrade detachedInstance) {
        log.debug("merging TGrade instance");
        try {
            TGrade result = (TGrade) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TGrade instance) {
        log.debug("attaching dirty TGrade instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TGrade instance) {
        log.debug("attaching clean TGrade instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TGradeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TGradeDAO) ctx.getBean("TGradeDAO");
	}
}