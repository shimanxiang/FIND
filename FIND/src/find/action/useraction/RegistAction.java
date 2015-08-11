package find.action.useraction;

import net.sf.json.JSONObject;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionSupport;

import common.util.ConstantField;
import common.util.SHA1Util;
import common.util.Status;
import find.entity.Classroom;
import find.entity.User;
import find.service.mailservice.MailService;
import find.service.userservice.UserService;
import find.util.BaseAction;
/**
 * 注册
 * @author MONEY
 *
 */
public class RegistAction extends BaseAction{ 
	
		private String user_mail;
		private String user_name;
		private String user_password;
		
		private UserService userservice;
		private MailService mailservice;
		@Override 
	    public String execute() throws Exception { 
			
			System.out.println("用户注册");
			
			this.getResponse().setContentType("text/json;charset=utf-8");
			this.getResponse().setCharacterEncoding("UTF-8");
			JSONObject registerjson = new JSONObject();
			
			try {
				if(this.userservice.exits(user_mail)!=true){
					
					User user=new User();
					user.setUser_mail(user_mail);
					user.setUser_nickname(user_name);
					user.setUser_psw(user_password);
					user.setUser_type(ConstantField.PRIMARY_USER);
						
					this.getSession().put(ConstantField.USER,
							(User) user);
					
					this.userservice.add(user);
					registerjson.put(ConstantField.STATUS, Status.SUCCESS); 
					System.out.println(registerjson.toString());
					this.responseClient(registerjson);
				}else {
					registerjson.put(ConstantField.STATUS, Status.USER_ACCONUT_EXIST);
					System.out.println(registerjson.toString());
					this.responseClient(registerjson);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				registerjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
				this.responseClient(registerjson);
			}
	        return SUCCESS;
	    } 
		
		public String getUser_mail() {
				return user_mail;
		}
		public void setUser_mail(String user_mail) {
				this.user_mail = user_mail;
		}
		public String getUser_name() {
				return user_name;
		}
		public void setUser_name(String user_name) {
				this.user_name = user_name;
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
		public MailService getMailservice() {
			return mailservice;
		}
		public void setMailservice(MailService mailservice) {
			this.mailservice = mailservice;
		}
}
