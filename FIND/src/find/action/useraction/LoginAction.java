package find.action.useraction;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionSupport;

import common.util.ConstantField;
import common.util.Status;
import find.entity.User;
import find.responseentity.UserAndStatusMsg;
import find.service.userservice.UserService;
import find.util.BaseAction;
/**
 * 
 * 登录，退出
 * @author MONEY
 *
 */
public class LoginAction extends BaseAction { 
	
		private String user_mail;
		private String user_password;
		private UserService userservice; 
		
		/*
		 * 登录
		 */
		@Override 
	    public String execute() throws Exception { 
			
			System.out.println("登录");
			
			this.getResponse().setContentType("text/json;charset=utf-8");
			this.getResponse().setCharacterEncoding("UTF-8");
			
			JSONObject loginjson = new JSONObject();
			
			try {
				UserAndStatusMsg uas=this.userservice.login(user_mail, user_password);
				if(uas.getStatus()==Status.SUCCESS){
					
					//loginjson=JSONObject.fromObject(uas.getU());
					loginjson.put(ConstantField.STATUS, uas.getStatus());
					
					this.getSession().put(ConstantField.USER, (User)uas.getU());
					this.getSession().put(ConstantField.USER_ID, uas.getU().getUser_id());
					this.getSession().put(ConstantField.USER_NAME, uas.getU().getUser_nickname());
					this.getSession().put(ConstantField.USER_TYPE, uas.getU().getUser_type());
					this.responseClient(loginjson);
					return SUCCESS;
				}else{
					loginjson.put(ConstantField.STATUS, uas.getStatus());
					this.responseClient(loginjson);
				}
			} catch (Exception e) {
				e.printStackTrace();
				loginjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
				this.responseClient(loginjson);
			}
			return SUCCESS;
	    } 
		
		/*
		 * 退出
		 */
		public String logout() {
			
			System.out.println("退出");
			this.getResponse().setContentType("text/json;charset=utf-8");
			this.getResponse().setCharacterEncoding("UTF-8");
			
			JSONObject logoutjson = new JSONObject();
			try {
				this.getSession().remove(ConstantField.USER);
				logoutjson.put(ConstantField.STATUS, Status.SUCCESS);
				System.out.println(logoutjson.toString());
				this.responseClient(logoutjson);
			} catch (Exception e) {
				e.printStackTrace();
				logoutjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
				this.responseClient(logoutjson);
			}
			return SUCCESS;
		}
		public String getUser_mail() {
			return user_mail;
		}
		public void setUser_mail(String user_mail) {
			this.user_mail = user_mail;
		}
		public String getUser_password() {
			return user_password;
		}
		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}
		public UserService getUserservice() {
			return userservice;
		}
		public void setUserservice(UserService userservice) {
			this.userservice = userservice;
		}
				
}
