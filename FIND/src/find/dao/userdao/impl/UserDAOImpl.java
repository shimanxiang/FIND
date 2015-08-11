package find.dao.userdao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import common.daobase.impl.BaseDAOImpl;
import common.entity.PageBean;
import find.dao.userdao.UserDAO;
import find.entity.User;
import find.responseentity.BaseUserInfoMsg;

public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	@Override
	public PageBean<User> GetUserList(int currentPage, String user_mail) {
		String hql="from " + binaryName+ " as model where model." + "user_mail" + "= ?";
		PageBean<User> pageBean=new PageBean<User>();
		pageBean=this.selectByPage(hql,5,currentPage,user_mail);
		return pageBean;
	}
}
