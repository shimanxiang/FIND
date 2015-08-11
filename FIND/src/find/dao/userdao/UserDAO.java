package find.dao.userdao;

import java.util.List;

import common.daobase.BaseDAO;
import common.entity.PageBean;
import find.entity.User;
import find.responseentity.BaseUserInfoMsg;

public interface UserDAO extends BaseDAO <User> {
	
	public static final String binaryName = User.class.getName();
	public static final String USER_MAIL = "user_mail";
	public static final String USER_NAME = "user_name";
	public static final String USER_PASSWORD = "user_password";
	public PageBean<User> GetUserList(int currentPage,String user_mail);
}
