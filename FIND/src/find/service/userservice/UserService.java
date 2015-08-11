package find.service.userservice;

import java.util.List;

import common.entity.PageBean;
import common.servicebase.BaseService;
import find.entity.User;
import find.responseentity.BaseUserInfoMsg;
import find.responseentity.UserAndStatusMsg;

public interface UserService extends BaseService<User>{	 
	 public boolean exits(String user_mail);
	 public UserAndStatusMsg login(String user_mail,String user_password);
	 public User FindByMail(String user_mail);
	 public PageBean<User> GetUserList(int currentPage,String user_mail);
	 //public List<User> findFollowCourse(String userNumber,userFollowCourseMsg userFollowCourseMsg);
	 public BaseUserInfoMsg queryBaseUserInfo(String user_mail);
	 
}
