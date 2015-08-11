package find.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import common.util.ConstantField;

//权限拦截器
public class AuthorityInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation a1) throws Exception {
	
		String user_type = (String) ServletActionContext.getRequest().getSession().getAttribute(ConstantField.USER_TYPE);
		Boolean flag =false;
		if(user_type.equals(ConstantField.CLASS_CREATER)
				||user_type.equals(ConstantField.CLASS_MANAGER)
				||user_type.equals(ConstantField.PRIMARY_USER)){
			flag=true;
		}
		
		if(flag==true){
			return a1.invoke();
		}else
			return "noauthority";
		
	}
}
