package find.action.classaction;

import org.codehaus.jackson.map.ser.JdkSerializers.ClassSerializer;

import common.util.ConstantField;
import common.util.Status;
import net.sf.json.JSONObject;
import find.entity.Classroom;
import find.entity.User;
import find.entity.UserClassroom;
import find.service.classservice.ClassService;
import find.service.userclassservice.UserClassService;
import find.service.userservice.UserService;
/*
 * 
 * �û�����༶
 */
import find.util.BaseAction;
/**
 * 加入，退出，关注，取消关注班级
 * @author MONEY
 *
 */
public class JoinClassAction extends BaseAction{
	
	private String class_name="2";
	private String user_mail="1";
	private UserService userservice;
	private ClassService classservice;
	private UserClassService userclassservice;
	
	//用户加入班级
	@Override
	public String execute() throws Exception {
		
		System.out.println("加入班级");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject joinclassjson=new JSONObject();
		if(user_mail==null||class_name==null){
			joinclassjson.put(ConstantField.STATUS, Status.PARAMETER_ERROR);
		}
		try {
			User u=this.userservice.FindByMail(user_mail);
			Classroom classroom=this.classservice.FindByClassname(class_name);
			u.setClassroom(classroom);
			this.userservice.update(u);
			joinclassjson.put(ConstantField.STATUS, Status.SUCCESS);
			System.err.println(joinclassjson);
			this.responseClient(joinclassjson);
		} catch (Exception e) {
			joinclassjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
			this.responseClient(joinclassjson);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//用户关注班级
	public String UserFollowClass() throws Exception {
		System.out.println("用户关注班级");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject userFollowClassjson=new JSONObject();
		if(user_mail==null||class_name==null){
			userFollowClassjson.put(ConstantField.STATUS, Status.PARAMETER_ERROR);
		}
		try {
			User user=this.userservice.FindByMail(user_mail);
			Classroom classroom=this.classservice.FindByClassname(class_name);
			UserClassroom userClassroom=new UserClassroom();
			userClassroom.setClassroom(classroom);
			userClassroom.setUser(user);
			this.userclassservice.add(userClassroom);
			userFollowClassjson.put(ConstantField.STATUS, Status.SUCCESS);
			this.responseClient(userFollowClassjson);
		} catch (Exception e) {
			userFollowClassjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
			this.responseClient(userFollowClassjson);
			e.printStackTrace();
		}
		return null;
		
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public ClassService getClassservice() {
		return classservice;
	}
	public void setClassservice(ClassService classservice) {
		this.classservice = classservice;
	}
	public UserClassService getUserclassservice() {
		return userclassservice;
	}
	public void setUserclassservice(UserClassService userclassservice) {
		this.userclassservice = userclassservice;
	}
}
