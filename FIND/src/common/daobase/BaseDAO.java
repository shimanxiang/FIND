package common.daobase;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

import common.entity.PageBean;

import find.entity.User;
/**
 * @param <T>
 */
public interface BaseDAO<T extends java.io.Serializable>{
	public void add(T t);
	public void update(T t);
	public void remove(T t);
	public T findById(java.lang.Integer id, String binaryName);
	
	public List findByProperty(String propertyName, Object value,
			String binaryName);
	
	//模糊查询
	public List fuzzyQuery(String propertyName, Object value,
			String binaryName);
	
	public List sort(String hql,Object value);
	//分页查询
	PageBean <T> selectByPage(final String hql, int pageSize, int currentPage,Object value);
}
