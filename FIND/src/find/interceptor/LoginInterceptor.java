package find.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//登录拦截器
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation a1) throws Exception {
		Object user=ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user!=null){
			return a1.invoke();
		}else
			return "login";
	}

}
