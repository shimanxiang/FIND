package common.daobase.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import common.daobase.BaseDAO;
import common.entity.PageBean;
import find.entity.User;

public class BaseDAOImpl<T extends java.io.Serializable> extends HibernateDaoSupport implements BaseDAO<T>{

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void remove(T t) {
		this.getHibernateTemplate().delete(t);
	}
	public T findById(Integer id, String binaryName) {
		
		try {
			T instance = (T) getHibernateTemplate().get(binaryName, id);
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List findByProperty(String propertyName, Object value,
			String binaryName) {
		try {
			String queryString = "from " + binaryName
					+ " as model where model." + propertyName + "= ?";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
	@Override
	public List fuzzyQuery(String propertyName, Object value, String binaryName) {
		try {
			//String queryString = "from binaryName s where s.levelname like '%"+value+"%'"; 
			
			String queryString = "from " + binaryName
					+ " as model where model." + propertyName + " like '%"+value+"%'";
			
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			//queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public PageBean<T> selectByPage(final String hql, int pageSize, int currentPage,final Object value) {
		int allRow = 0;
		try {
			String counthql = "select count(*)  "+hql;
	        Query query =  getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(counthql);
	        query.setParameter(0, value);
	        allRow = ((Long) query.iterate().next()).intValue();
		} catch (Exception e) {
			allRow = super.getHibernateTemplate().find(hql).size();
		}
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, currentPage);

		final int length = pageSize;
		final int page = PageBean.countCurrentPage(currentPage);
		List list = super.getHibernateTemplate().executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult(offset);
						query.setMaxResults(length);
						query.setParameter(0, value);
						List list = query.list();
						return list;
					}
				});
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(page);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	@Override
	public List sort(String hql,Object value) {
		try {
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(hql);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
