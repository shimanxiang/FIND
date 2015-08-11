package find.action.useraction;

import common.util.ConstantField;
import common.util.Status;
import net.sf.json.JSONObject;
import find.entity.User;
import find.service.mailservice.MailService;
import find.service.userservice.UserService;
import find.util.BaseAction;
/**
 * 找回密码
 * @author MONEY
 *
 */
public class FindpasswordAction extends BaseAction {
	
	private String user_mail;
	private String user_new_password;
	
	private UserService userservice;
	private MailService mailservice;
	
	/*
	 *找回密码-验证用户
	 */
	@Override
	public String execute() throws Exception {
		
		System.out.println("找回密码-验证用户");
		
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject fpjson = new JSONObject();
		
		if(user_mail==null){
			System.out.println("����Ϊ��...");
			fpjson.put(ConstantField.STATUS, Status.PARAMETER_ERROR);
			this.responseClient(fpjson);
			return SUCCESS;
		}
		try {
			if(userservice.exits(user_mail)){
				
				fpjson.put(ConstantField.STATUS, Status.SUCCESS);
				System.out.println(fpjson.toString());
				this.responseClient(fpjson);
			}else {
				fpjson.put(ConstantField.STATUS, Status.USER_ACCOUNT_NOT_EXIST);
				System.out.println(fpjson.toString());
				this.responseClient(fpjson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*
	 * 找回密码-邮箱验证֤
	 */
	public String safetyverification() throws Exception {
		
		System.out.println("找回密码-邮箱验证");
		
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject fpjson = new JSONObject();
		
		String identifying_code="";
		try {
				identifying_code=mailservice.send(user_mail);
				fpjson.put(ConstantField.STATUS, Status.SUCCESS);
				fpjson.put("identifying_code", identifying_code);
				System.out.println(fpjson.toString());
				this.responseClient(fpjson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*
	 *找回密码-重置密码
	 */
	public String resetpassword() throws Exception {
		
		System.out.println("找回密码-重置密码");
		
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject fpjson = new JSONObject();
		
		try {
			User user=this.userservice.FindByMail(user_mail);
			user.setUser_psw(user_new_password);
			this.userservice.update(user);
			fpjson.put(ConstantField.STATUS, Status.SUCCESS);
			System.out.println(fpjson.toString());
			this.responseClient(fpjson);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getUser_new_password() {
		return user_new_password;
	}

	public void setUser_new_password(String user_new_password) {
		this.user_new_password = user_new_password;
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
	public MailService getMailservice() {
		return mailservice;
	}

	public void setMailservice(MailService mailservice) {
		this.mailservice = mailservice;
	}
}
