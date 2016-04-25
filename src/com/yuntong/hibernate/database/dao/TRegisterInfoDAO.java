package com.yuntong.hibernate.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.yuntong.hibernate.database.HibernateSessionFactory;
import com.yuntong.hibernate.database.po.TRegisterInfo;
import com.yuntong.hibernate.database.po.TRegisterState;

/**
 * Data access object (DAO) for domain model class TRegisterInfo.
 * @see com.yuntong.hibernate.database.dao.TRegisterInfo
 * @author MyEclipse - Hibernate Tools
 */
public class TRegisterInfoDAO extends HibernateDaoSupport {

    private static final Log log = LogFactory.getLog(TRegisterInfoDAO.class);

	//property constants
	public static final String REGISTER_GLIDE_ID = "registerGlideId";
	public static final String REGISTER_CONVEYANCE_ID = "registerConveyanceId";
	public static final String REGISTER_LINE = "registerLine";
	public static final String REGISTER_PAYER_NAME = "registerPayerName";
	public static final String REGISTER_REMARK = "registerRemark";

	protected void initDao() {
		//do nothing
	}
	//结算方式比例(shouqi)
	public List findBili(){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	String hql="select count(r) from TRegisterInfo r where r.TFreightStyle.freightId=1";    	
    	List list=session.createQuery(hql).list();    	    	    	    	
		return list;
	}
//	结算方式比例(tifu)
	public List findBili2(){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	String hql="select count(r) from TRegisterInfo r where r.TFreightStyle.freightId=2";    	
    	List list=session.createQuery(hql).list();    	    	    	    	
		return list;
	}
	//分组查询运输线路
	public List findXianlu(){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	String hql="select count(r),r.registerLine from TRegisterInfo r group by r.registerLine order by count(r) desc";
    	List list=session.createQuery(hql).list();
		return list;
	}
	//根据货票编号删除对应货票
	public void deleteRegisterByID(int rid){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction tx= session.beginTransaction();
    	String hql="delete TRegisterInfo where registerId="+rid+"";
    	log.info("语句=="+hql);    	
    	try{
    	Query query=session.createQuery(hql);
    	query.executeUpdate();
    	log.info("删除货票成功=================");
    	}catch(Exception e){
    		e.printStackTrace();
    		log.info("删除货票失败=================");
    		tx.rollback();
    	}
    	tx.commit();
	}
	//根据页面大小得到总页数
	public int getPageNum(int pageSize,int clientID,int factroyID,int freightID,Date insertDate){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Criteria c=session.createCriteria(TRegisterInfo.class);
//    	判断查询条件
    	Long clientIDLong= Long.parseLong(clientID+"");
    	if(clientID!=0){
    		c.add(Expression.eq("TClientInfo.clientId", clientIDLong));
    	}
    	if(factroyID!=0){
    		c.add(Expression.eq("TFactoryInfo.factoryId", factroyID));
    	}
    	
    	if(freightID!=0){
    		
    		c.add(Expression.eq("TFreightStyle.freightId", freightID));
    		
    	}
    	if(insertDate!=null){
    		c.add(Expression.ge("registerDate", insertDate));
    	}
    	List list=new ArrayList();
    	
    	list=c.list();
    	;
    	int count=list.size();
    	return (int) Math.ceil((double) count / pageSize);
	}
	//分页得到货票信息(页面大小，当前页数,货票状态)
	public List findSplitRegister(int pageSize,int curPage,int clientID,int factroyID,int freightID,Date insertDate){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Criteria c=session.createCriteria(TRegisterInfo.class);
    	//为估价状态
    	c.add(Expression.eq("TRegisterState.rstateId", 1));
    	//判断查询条件
    	Long clientIDLong= Long.parseLong(clientID+"");
    	if(clientID!=0){
    		c.add(Expression.eq("TClientInfo.clientId", clientIDLong));
    	}
    	if(factroyID!=0){
    		c.add(Expression.eq("TFactoryInfo.factoryId", factroyID));
    	}
    	if(freightID!=0){
    		c.add(Expression.eq("TFreightStyle.freightId", freightID));
    	}
    	if(insertDate!=null){
    		c.add(Expression.ge("registerDate", insertDate));
    	}
    	//根据当前页数和页面大小，得到从第几条记录开始查询
    	int count=pageSize*(curPage-1);
    	c.setFirstResult(count);
    	//设置页面大小
    	c.setMaxResults(pageSize);
		return c.list();
	}
	//根据货票编号或运输编号进行精确查询
	public List findRegisterByIDAndRunID(long inputID,int inputType){
		SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();    	    	    	
    	Criteria criteria=session.createCriteria(TRegisterInfo.class);
    	if(inputType==1){
    	criteria.add(Expression.eq("registerGlideId", inputID));
    	}else{
    		criteria.add(Expression.eq("registerConveyanceId", inputID+""));
    	}
    	
    	return criteria.list();
	}
	//计算货票流水
    public List findDayNum(){
    	List list=getHibernateTemplate().find("from TRegisterInfo");
    	return list;
    }
    //根据业务编号得到货票信息
    public TRegisterInfo findRegisterInfoByGlideID(long glideID){    	
    	SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();    	    	    	
    	Criteria criteria=session.createCriteria(TRegisterInfo.class);
    	criteria.add(Expression.eq("registerGlideId", glideID));
    	
    	return (TRegisterInfo)(criteria.list().get(0));
    }
    //根据运输编号得到货票信息
    public TRegisterInfo findRegisterInfoByConveyanceID(String conveyanceID){
    	SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();    	    	    	
    	Criteria criteria=session.createCriteria(TRegisterInfo.class);
    	criteria.add(Expression.eq("registerConveyanceId", conveyanceID));    	
    	return (TRegisterInfo)(criteria.list().get(0));
    }
    
    //修改货票状态
    public void updateRegisterState(int rid,int updateState){
    	SessionFactory sessionFactory=  getHibernateTemplate().getSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction tx= session.beginTransaction();
    	TRegisterState state=new TRegisterState();
    	state.setRstateId(updateState);
    	TRegisterInfo info=(TRegisterInfo) session.get(TRegisterInfo.class, new Integer(rid));
    	info.setTRegisterState(state);
    	session.save(info);
    	tx.commit();
    }
    public void save(TRegisterInfo transientInstance) {
        log.debug("saving TRegisterInfo instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TRegisterInfo persistentInstance) {
        log.debug("deleting TRegisterInfo instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TRegisterInfo findById( java.lang.Integer id) {
        log.debug("getting TRegisterInfo instance with id: " + id);
        try {
            TRegisterInfo instance = (TRegisterInfo) getHibernateTemplate()
                    .get("com.yuntong.hibernate.database.po.TRegisterInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TRegisterInfo instance) {
        log.debug("finding TRegisterInfo instance by example");
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
      log.debug("finding TRegisterInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TRegisterInfo as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRegisterGlideId(Object registerGlideId) {
		return findByProperty(REGISTER_GLIDE_ID, registerGlideId);
	}
	
	public List findByRegisterConveyanceId(Object registerConveyanceId) {
		return findByProperty(REGISTER_CONVEYANCE_ID, registerConveyanceId);
	}
	
	public List findByRegisterLine(Object registerLine) {
		return findByProperty(REGISTER_LINE, registerLine);
	}
	
	public List findByRegisterPayerName(Object registerPayerName) {
		return findByProperty(REGISTER_PAYER_NAME, registerPayerName);
	}
	
	public List findByRegisterRemark(Object registerRemark) {
		return findByProperty(REGISTER_REMARK, registerRemark);
	}
	
    public TRegisterInfo merge(TRegisterInfo detachedInstance) {
        log.debug("merging TRegisterInfo instance");
        try {
            TRegisterInfo result = (TRegisterInfo) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TRegisterInfo instance) {
        log.debug("attaching dirty TRegisterInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TRegisterInfo instance) {
        log.debug("attaching clean TRegisterInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
//  根据货票编号或运输编号进行精确查询
	public List findByID(String ID,long value){
		log.debug("attaching clean TAgioInfo instance");
		try {
			String sql = "from  TRegisterInfo where "+ID+" = '"+value+"' and (RegisterState=5 or RegisterState=6)";
			List list = getHibernateTemplate().find(sql);
			return list;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	//退货登记google
	public List findByIdTopTen(long id){
		log.debug("attaching clean TAgioInfo instance");
		try {
			String sql = "from  TRegisterInfo where registerGlideId like '"+id+"%' and (RegisterState=5 or RegisterState=6)";
			List list = getHibernateTemplate().find(sql);
			return list;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		
	}

	public static TRegisterInfoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TRegisterInfoDAO) ctx.getBean("TRegisterInfoDAO");
	}
	
	/**
	 * 按流水号得到货票信息
	 * @param registerGlideId
	 * @return
	 */
	public List findRegisterInfoByRigeterGlideId(Object registerGlideId){
		Criteria criteria=getSession().createCriteria(TRegisterInfo.class);
		criteria.add(Expression.eq("registerGlideId", registerGlideId));
		List list=criteria.list();
		return list;
	}
	public List getRegisterInfoByYear(String year){ 
	    String hql="from TRegisterInfo info where info.registerDate like  '%"+year+"%'";
	    
	    Query query=getSession().createQuery(hql);
	    return query.list();
	}
	
	public List getRegisterInfoListByID(String id,int type){
		String hql="";
		if(type==1){//省际
			hql="from TRegisterInfo info where info.registerGlideId like  '"+id+"%' and info.TRegisterState in(3,4) order by info.registerGlideId desc";
		}
		if(type==2){//市场
			hql="from TRegisterInfo info where info.registerGlideId like  '"+id+"%' and info.TRegisterState in(5,6) order by info.registerGlideId desc";
		}
		 Query query=getSession().createQuery(hql);
		 return query.list();
	}
	//到货确认google效果
	public List findTopTen(String id,String ty){
		String hql="";
		//货票编号		
		long lid=Long.parseLong(id);
		hql="from TRegisterInfo info where info.registerGlideId like  '"+lid+"%' and info.TRegisterState in(3,4) order by info.registerGlideId desc";		
		Query query=getSession().createQuery(hql);
		 return query.list();
	}
//	孙货登记google效果
	public List findTopTen(String id){
		String hql="";
		//货票编号		
		long lid=Long.parseLong(id);
		hql="from TRegisterInfo info where info.registerGlideId like  '"+lid+"%' and info.TRegisterState in(5,6) order by info.registerGlideId desc";		
		Query query=getSession().createQuery(hql);
		 return query.list();
	}
//	费用估算google效果
	public List findgsTopTen(int id){
		String hql="";
		//货票编号				
		hql="from TRegisterInfo info where info.registerId like  '"+id+"%'";		
		Query query=getSession().createQuery(hql);
		 return query.list();
	}
	public void changeRegisterState(Object obj){
		getHibernateTemplate().update(obj);
	}
}