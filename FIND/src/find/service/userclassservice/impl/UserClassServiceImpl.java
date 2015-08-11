package find.service.userclassservice.impl;

import java.util.ArrayList;
import java.util.List;

import find.dao.userclass.UserClassDAO;
import find.entity.Classroom;
import find.entity.User;
import find.entity.UserClassroom;
import find.responseentity.BaseClassInfoMsg;
import find.responseentity.BaseUserInfoMsg;
import find.service.userclassservice.UserClassService;

public class UserClassServiceImpl  implements UserClassService{
	
	private UserClassDAO userclassDAO;
	@Override
	public void add(UserClassroom t) {
		this.userclassDAO.add(t);
	}

	@Override
	public void update(UserClassroom t) {
		
	}

	@Override
	public void remove(UserClassroom t) {
		
	}
	
	public UserClassDAO getUserclassDAO() {
		return userclassDAO;
	}

	public void setUserclassDAO(UserClassDAO userclassDAO) {
		this.userclassDAO = userclassDAO;
	}

	@Override
	public List<BaseClassInfoMsg> QueryUserFollowClass(User user) {
		try {
			List<UserClassroom> list=this.userclassDAO.findByProperty(this.userclassDAO.USER, user, this.userclassDAO.binaryName);
			List<BaseClassInfoMsg> list2=null;
			for(UserClassroom userClassroom:list){
				
				System.out.println(userClassroom.getUserclassroom_id());
				BaseClassInfoMsg baseClassInfoMsg=new BaseClassInfoMsg();
				baseClassInfoMsg.setClass_head_pic_link(userClassroom.getClassroom().getClass_head_pic_link());
				baseClassInfoMsg.setClass_introduction(userClassroom.getClassroom().getClass_introduction());
				baseClassInfoMsg.setClass_name(userClassroom.getClassroom().getClass_name());
				list2.add(baseClassInfoMsg);
			}
			return list2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<BaseUserInfoMsg> QueryClassFollowUser(Classroom classroom) {
		try {
			List<UserClassroom> list=this.userclassDAO.findByProperty(this.userclassDAO.CLASSROOM, classroom, this.userclassDAO.binaryName);
			List<BaseUserInfoMsg> list2=new ArrayList<BaseUserInfoMsg>();
			for(UserClassroom userClassroom:list){
				BaseUserInfoMsg baseUserInfoMsg=new BaseUserInfoMsg();
				baseUserInfoMsg.setUser_class_name(userClassroom.getUser().getClassroom().getClass_name());
				baseUserInfoMsg.setUser_corporation_name(userClassroom.getUser().getCorporation().getCorporation_name());
				baseUserInfoMsg.setUser_mail(userClassroom.getUser().getUser_mail());
				baseUserInfoMsg.setUser_nickname(userClassroom.getUser().getUser_nickname());
				baseUserInfoMsg.setUser_type(userClassroom.getUser().getUser_type());
				list2.add(baseUserInfoMsg);
			}
			return list2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
