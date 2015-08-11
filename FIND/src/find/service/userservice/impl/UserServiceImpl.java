package find.service.userservice.impl;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.components.If;
import common.entity.PageBean;
import common.util.ConstantField;
import common.util.Status;
import find.dao.classroom.ClassroomDAO;
import find.dao.userdao.UserDAO;
import find.entity.Classroom;
import find.entity.Corporation;
import find.entity.User;
import find.responseentity.BaseUserInfoMsg;
import find.responseentity.UserAndStatusMsg;
import find.service.userservice.UserService;

public class UserServiceImpl implements UserService{
	
	private static final String defaultTerm = "2015-1";
	
	private UserDAO userDAO;
	private ClassroomDAO classroomDAO;
	
    public ClassroomDAO getClassroomDAO() {
		return classroomDAO;
	}

	public void setClassroomDAO(ClassroomDAO classroomDAO) {
		this.classroomDAO = classroomDAO;
	}

	public static String getDefaultterm() {
		return defaultTerm;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	//判断用户是否存在
	public boolean exits(String user_mail) {
		
		List<User> list = this.getUserDAO().findByProperty(UserDAO.USER_MAIL, user_mail, UserDAO.binaryName);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	//用户登录
	public UserAndStatusMsg login(String user_mail, String user_password) {
		
		UserAndStatusMsg uas=new UserAndStatusMsg();
		
		List<User> list = this.getUserDAO().findByProperty(UserDAO.USER_MAIL, user_mail, UserDAO.binaryName);
		try {
			if (list != null && list.size() > 0) {
				
				User user=list.get(0);
				if(user.getUser_psw().equals(user_password)){
					uas.setStatus(Status.SUCCESS);
					uas.setU(user);
				}else {
					uas.setStatus(Status.USER_PASSWD_WRONG);
				}
			}else
				uas.setStatus(Status.USER_ACCOUNT_NOT_EXIST);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return uas;
	}
	
	//根据邮箱查找用户
	@Override
	public User FindByMail(String user_mail) {
		List<User> list = this.getUserDAO().findByProperty(UserDAO.USER_MAIL, user_mail, UserDAO.binaryName);
		try {
			if (list != null && list.size() > 0) {
				User user=list.get(0);
				return user;
			} else{
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//添加用户
	@Override
	public void add(User t) {
		this.userDAO.add(t);
	}
	//更新用户
	@Override
	public void update(User t) {
		this.userDAO.update(t); 
	}
	//删除用户
	@Override
	public void remove(User t) {
		this.userDAO.remove(t); 
	}
	//获得所有用户
	@Override
	public PageBean<User> GetUserList(int currentPage, String user_mail) {
		
		PageBean<User> pageBean=this.userDAO.GetUserList(currentPage, user_mail);
		return pageBean;
	}
	//返回用户的基本信息
	@Override
	public BaseUserInfoMsg queryBaseUserInfo(String user_mail) {
	    User user=this.FindByMail(user_mail);
        try {
			if(user!=null){
				BaseUserInfoMsg baseUserInfo=new BaseUserInfoMsg();
				Classroom classroom=user.getClassroom();
				Corporation corporation=user.getCorporation();
				baseUserInfo.setUser_class_name(classroom.getClass_name());
				baseUserInfo.setUser_corporation_name(corporation.getCorporation_name());
				baseUserInfo.setUser_mail(user_mail);
				baseUserInfo.setUser_nickname(user.getUser_nickname());
				baseUserInfo.setUser_type(user.getUser_type());
				return baseUserInfo;
			}
		} catch (Exception e) {	
		}
		return null;
	}
}
