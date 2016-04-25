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
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuntong.hibernate.database.po.TDepartment;
import com.yuntong.hibernate.database.po.TFilialeInfo;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRoleInfo;
import com.yuntong.hibernate.database.po.TUserInfo;

/**
 * Data access object (DAO) for domain model class TUserInfo.
 * 
 * @see com.yuntong.hibernate.database.dao.TUserInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TUserInfoDAO extends HibernateDaoSupport {

	private static final Log log = LogFactory.getLog(TUserInfoDAO.class);

	// property constants
	public static final String USER_USE_NAME = "userUseName";

	public static final String USER_NAME = "userName";

	public static final String USER_PASSWORD = "userPassword";

	public static final String USER_PHONE = "userPhone";

	public static final String USER_CARD_ID = "userCardId";

	public static final String USER_LOGIN_NUM = "userLoginNum";

	protected void initDao() {
		// do nothing
	}

	// 得到权限比例

	public List findUserRole() {
		SessionFactory sessionfactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionfactory.openSession();
		Query query;
		List temps = new ArrayList();
		int temp = 0;
		for (int i = 1000; i < 1008; i++) {
			query = session
					.createQuery("from TUserInfo u where u.TRoleInfo.roleId="
							+ i + "");
			temp = query.list().size();
			temps.add(temp);
		}
		return temps;
	}

	// 修改登陆密码
	public void updateUserPwd(int userId,String userPwd){
		SessionFactory sessionFactory = getHibernateTemplate()
		.getSessionFactory();
		Session session = sessionFactory.openSession();	
		Transaction tr = session.beginTransaction();
		TUserInfo user = (TUserInfo) session.get(TUserInfo.class, userId);
		user.setUserPassword(userPwd);
		session.save(user);
		tr.commit();
	}
	// 修改用户登陆次数上次登陆时间
	public void updataUserLoginTime(int userId) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		TUserInfo user = (TUserInfo) session.get(TUserInfo.class, userId);
		// 登陆次数加1
		user.setUserLoginNum(user.getUserLoginNum() + 1);
		// 最近登陆时间
		user.setUserLoginDate(new Date());
		session.save(user);
		tr.commit();
	}

	// 填加或修改用户
	public void addUserInfo(int userId, String userName, int filiale,
			int department, int userRole, String userTrueName,
			String userPhone, String userCardId, String userPwd2,
			int userLoginNum, Date userLoginDate, Date userDate) {
		TUserInfo info = new TUserInfo();
		log.info("userid:" + userId);
		if (userId != 0) {
			info.setUserId(userId);// 用户编号
			info.setUserLoginDate(userLoginDate);
			info.setUserDate(userDate);
			info.setUserLoginNum(userLoginNum);
		} else {
			info.setUserDate(new Date());
			info.setUserLoginDate(new Date());
			info.setUserLoginNum(0);
		}
		info.setUserUseName(userName);// 用户名
		TFilialeInfo fi = new TFilialeInfo();// 公司编号
		fi.setFilialeId(filiale);
		info.setTFilialeInfo(fi);
		TDepartment td = new TDepartment();// 部门编号
		td.setDepartmentId(department);
		info.setTDepartment(td);
		TRoleInfo tr = new TRoleInfo();// 权限
		tr.setRoleId(userRole);
		info.setTRoleInfo(tr);
		info.setUserName(userTrueName);// 真实姓名
		info.setUserPhone(userPhone);// 电话
		info.setUserCardId(userCardId);// 身份正
		info.setUserPassword(userPwd2);// 密码

		try {
			getHibernateTemplate().saveOrUpdate(info);
			log.debug("填加或修改用户成功-----------------");
		} catch (RuntimeException re) {
			log.error("填加或修改用户失败------------------", re);
			throw re;
		}
	}

	// 根据页面大小得到总页数(页面大小，公司编号，部门编号，日期前，日期后)
	public int getPageNum(int pageSize, int filiale, int department,
			Date date1, Date date2) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(TUserInfo.class);
		// 判断查询条件
		if (filiale != 0) {
			c.add(Expression.eq("TFilialeInfo.filialeId", filiale));
		}
		if (department != 0) {
			c.add(Expression.eq("TDepartment.departmentId", department));
		}

		if (date1 != null) {
			if (!date1.toString().equals(date2.toString())) {
				c.add(Expression.ge("userDate", date1));
			}
		}
		if (date2 != null) {
			if (!date1.toString().equals(date2.toString())) {
				c.add(Expression.le("userDate", date2));
			}
		}

		List list = new ArrayList();
		list = c.list();
		int count = list.size();
		return (int) Math.ceil((double) count / pageSize);
	}

	// 分页得到用户信息(页面大小，当前页数,公司编号，部门编号，日期前，日期后)
	public List findSplitRegister(int pageSize, int curPage, int filiale,
			int department, Date date1, Date date2) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(TUserInfo.class);
		// 判断查询条件
		if (filiale != 0) {
			c.add(Expression.eq("TFilialeInfo.filialeId", filiale));
		}
		if (department != 0) {
			c.add(Expression.eq("TDepartment.departmentId", department));
		}

		if (date1 != null) {
			if (!date1.toString().equals(date2.toString())) {
				c.add(Expression.ge("userDate", date1));
			}
		}
		if (date2 != null) {
			if (!date1.toString().equals(date2.toString())) {
				c.add(Expression.le("userDate", date2));
			}
		}

		// 根据当前页数和页面大小，得到从第几条记录开始查询
		int count = pageSize * (curPage - 1);
		c.setFirstResult(count);
		// 设置页面大小
		c.setMaxResults(pageSize);
		return c.list();
	}

	// 根据编号删除用户信息
	public void deleteUserByID(int userId) {
		SessionFactory sessionFactory = getHibernateTemplate()
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete TUserInfo where userId=" + userId + "";
		log.info("语句==" + hql);
		try {
			Query query = session.createQuery(hql);
			query.executeUpdate();
			log.info("删除用户成功=================");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除用户失败=================");
			tx.rollback();
		}
		tx.commit();
	}

	public void save(TUserInfo transientInstance) {
		log.debug("saving TUserInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUserInfo persistentInstance) {
		log.debug("deleting TUserInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUserInfo findById(java.lang.Integer id) {
		log.debug("getting TUserInfo instance with id: " + id);
		try {
			TUserInfo instance = (TUserInfo) getHibernateTemplate().get(
					"com.yuntong.hibernate.database.po.TUserInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUserInfo instance) {
		log.debug("finding TUserInfo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TUserInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUserInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserUseName(Object userUseName) {
		return findByProperty(USER_USE_NAME, userUseName);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	public List findByUserPhone(Object userPhone) {
		return findByProperty(USER_PHONE, userPhone);
	}

	public List findByUserCardId(Object userCardId) {
		return findByProperty(USER_CARD_ID, userCardId);
	}

	public List findByUserLoginNum(Object userLoginNum) {
		return findByProperty(USER_LOGIN_NUM, userLoginNum);
	}

	public TUserInfo merge(TUserInfo detachedInstance) {
		log.debug("merging TUserInfo instance");
		try {
			TUserInfo result = (TUserInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUserInfo instance) {
		log.debug("attaching dirty TUserInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUserInfo instance) {
		log.debug("attaching clean TUserInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUserInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TUserInfoDAO) ctx.getBean("TUserInfoDAO");
	}
}