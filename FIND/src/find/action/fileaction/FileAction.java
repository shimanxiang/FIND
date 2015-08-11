package find.action.fileaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import find.util.BaseAction;

public class FileAction extends BaseAction{
	

	HttpServletRequest request ;
	@Override
	public String execute() throws Exception {
		//String pathh=request.getContextPath();
		//String projectname = System.getProperty("user.dir"); 
		//System.out.println(projectname);
		String s =ServletActionContext.getServletContext().getRealPath("/");
		System.out.println(s);		
		return SUCCESS;
	}
	//上传图片
	public String uploadimage() throws Exception{
		return null;
	}
	//上传视频
	public String uploadvideo() throws Exception{
		return null;
		
	}
	
}
