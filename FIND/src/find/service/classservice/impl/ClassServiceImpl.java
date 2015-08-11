package find.service.classservice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import common.entity.PageBean;
import common.util.Status;
import find.dao.classroom.ClassroomDAO;
import find.dao.userdao.UserDAO;
import find.entity.Classroom;
import find.entity.Corporation;
import find.entity.Photo;
import find.entity.User;
import find.responseentity.BaseClassInfoMsg;
import find.responseentity.BaseUserInfoMsg;
import find.responseentity.ClassAndStatusMsg;
import find.responseentity.UserAndStatusMsg;
import find.service.classservice.ClassService;

public class ClassServiceImpl implements ClassService {
	
	private ClassroomDAO classroomDAO;
	
	public ClassroomDAO getClassroomDAO() {
		return classroomDAO;
	}

	public void setClassroomDAO(ClassroomDAO classroomDAO) {
		this.classroomDAO = classroomDAO;
	}
	//班级是否存在
	@Override
	public boolean exits(String class_name) {
		@SuppressWarnings("unchecked")
		List<Classroom> list = this.getClassroomDAO().findByProperty(
				classroomDAO.CLASS_NAME, class_name, classroomDAO.binaryName);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	//根据班级名称返回班级
	@Override
	public Classroom FindByClassname(String class_name) {
		List<Classroom> list = this.getClassroomDAO().findByProperty(
				classroomDAO.CLASS_NAME, class_name, classroomDAO.binaryName);
		if (list != null && list.size() > 0) {
			Classroom classroom=list.get(0);
			return classroom;
		} else {
			return null;
		}
	}
	
	//根据班级名称返回班级
	@Override
	public ClassAndStatusMsg FindByclassname(String class_name) {
		
		ClassAndStatusMsg classandstatus =new ClassAndStatusMsg();
		List<Classroom> list = this.getClassroomDAO().findByProperty(
				classroomDAO.CLASS_NAME, class_name, classroomDAO.binaryName);
		if (list != null && list.size() > 0) {
			Classroom classroom=list.get(0);
			classandstatus.setClass_id(classroom.getClass_id());
			classandstatus.setClass_name(classroom.getClass_name());
			classandstatus.setClass_introduction(classroom.getClass_introduction());
			classandstatus.setClass_class_head_pic_link(classroom.getClass_head_pic_link());
			classandstatus.setStatus(Status.SUCCESS);
			return classandstatus;
		} else {
			classandstatus.setStatus(Status.CLASS_ACCONUT_NOT_EXIST);
			return classandstatus;
		}
	}
	
	//根据ID查询
	@Override
	public List QueryByClassid(int class_id) {
		
		return null;
	}
	//模糊查询
	@Override
	public List FuzzyQuery(String class_name) {
		try {
			List<Classroom> list = this.getClassroomDAO().fuzzyQuery(
					classroomDAO.CLASS_NAME, class_name, classroomDAO.binaryName);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	//查询班级基本信息
	@Override
	public BaseClassInfoMsg queryBaseClassInfo(String class_name) {
		try {
			Classroom classroom=this.FindByClassname(class_name);
			if(classroom!=null){
				BaseClassInfoMsg baseClassInfo=new BaseClassInfoMsg();
				baseClassInfo.setClass_head_pic_link(classroom.getClass_head_pic_link());
				baseClassInfo.setClass_introduction(classroom.getClass_introduction());
				baseClassInfo.setClass_name(class_name);
				return baseClassInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询班级成员
	@Override
	public ArrayList<BaseUserInfoMsg> queryClassUser(String class_name) {
		try {
			Classroom classroom=this.FindByClassname(class_name);
			if (classroom!=null) {
				Set<User> list= classroom.getClass_user();
				ArrayList<BaseUserInfoMsg> list2=new ArrayList<BaseUserInfoMsg>();
				Iterator it = list.iterator();  
				while(it.hasNext()){
					User user=(User) it.next();
					BaseUserInfoMsg baseUserInfoMsg=new BaseUserInfoMsg();
					baseUserInfoMsg.setUser_class_name(class_name);
					baseUserInfoMsg.setUser_mail(user.getUser_mail());
					baseUserInfoMsg.setUser_nickname(user.getUser_nickname());
					baseUserInfoMsg.setUser_type(user.getUser_type());
					baseUserInfoMsg.setUser_corporation_name(user.getCorporation().getCorporation_name());
					list2.add(baseUserInfoMsg);
				}
				return list2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void add(Classroom t) {
		// TODO Auto-generated method stub
		this.classroomDAO.add(t);
	}

	@Override
	public void update(Classroom t) {
		// TODO Auto-generated method stub
		this.classroomDAO.update(t);
	}

	@Override
	public void remove(Classroom t) {
		// TODO Auto-generated method stub
		this.classroomDAO.remove(t);
	}

	
	
	
}
