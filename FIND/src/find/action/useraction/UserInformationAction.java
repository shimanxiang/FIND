package find.action.useraction;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.sparta.xpath.ThisNodeTest;

import common.entity.PageBean;
import common.util.ConstantField;
import common.util.Status;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import find.entity.Photo;
import find.entity.User;
import find.entity.Video;
import find.responseentity.BaseClassInfoMsg;
import find.responseentity.BaseUserInfoMsg;
import find.service.fileservice.FileService;
import find.service.userclassservice.UserClassService;
import find.service.userservice.UserService;
import find.util.BaseAction;
import find.entity.File;
public class UserInformationAction extends BaseAction{
	private UserService userservice;
	private FileService fileservice;
	private UserClassService userclassservice;
	private String user_mail="2";
	private int currentPage=1;
	private int fileType=1;
	
	//更新用户信息
	@Override
	public String execute() throws Exception {
		
		return null;
	}
	//获得用户基本信息
	public String QueryUserBaseInfo() throws Exception{
		System.out.println("查找用户基本信息");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject UserBaseInfojson = new JSONObject();
		if(user_mail==null){
			UserBaseInfojson.put(ConstantField.STATUS, Status.PARAMETER_ERROR);
		}
		try {
			BaseUserInfoMsg baseUserInfo=this.userservice.queryBaseUserInfo(user_mail);
			UserBaseInfojson=JSONObject.fromObject(baseUserInfo);
			UserBaseInfojson.put(ConstantField.STATUS, Status.SUCCESS);
			System.out.println(UserBaseInfojson.toString());
			this.responseClient(UserBaseInfojson);
		} catch (Exception e) {
			UserBaseInfojson.put(ConstantField.STATUS, Status.FAIL);
			this.responseClient(UserBaseInfojson);
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 获得用户上传
	 * 0.图片
	 * 1.视频
	 * 2.文章
	 */
	public String QueryUserFile() throws Exception{
		System.out.println("查找用户上传");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject UserImagejson = new JSONObject();
		if(user_mail==null){
			UserImagejson.put(ConstantField.STATUS,Status.PARAMETER_ERROR);
		}
		try {
			User user=this.userservice.FindByMail(user_mail);
			if(user!=null){
				ArrayList<File> list=new ArrayList<File>();
				list=this.fileservice.QueryFile(user,currentPage,fileType);
				JsonConfig config = new JsonConfig();  
				config.setJsonPropertyFilter(new PropertyFilter() {  
				public boolean apply(Object source, String name, Object value) {  
				//配置出现递归的属性  
				if (name.equals("user") || name.equals("classroom")|| name.equals("corporation")) {  
					 return true;  
				  } else {  
					   return false;  
				 }  
				}  
				});  
				JSONArray jsonArray=JSONArray.fromObject(list,config);
				System.out.println(jsonArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询用户关注的班级
	public String QueryUserFollowClass() throws Exception{
		System.out.println("查询用户关注的班级");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject UserFollowClassjson = new JSONObject();
		if(user_mail==null){
			UserFollowClassjson.put(ConstantField.STATUS,Status.PARAMETER_ERROR);
		}
		try {
			User user=this.userservice.FindByMail(user_mail);
			List<BaseClassInfoMsg> list=this.userclassservice.QueryUserFollowClass(user);
			if(list!=null){
				
				JSONArray jsonArray=JSONArray.fromObject(list);
				UserFollowClassjson.put("FollowClass", jsonArray);
				UserFollowClassjson.put(ConstantField.STATUS, Status.SUCCESS);
				System.out.println(UserFollowClassjson.toString());
				this.responseClient(UserFollowClassjson);
			}else {
				UserFollowClassjson.put(ConstantField.STATUS, Status.NO_FOLLOW);
				this.responseClient(UserFollowClassjson);
			}
		} catch (Exception e) {
			UserFollowClassjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
			this.responseClient(UserFollowClassjson);
			e.printStackTrace();
		}
		return null;
	}
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public FileService getFileservice() {
		return fileservice;
	}
	public void setFileservice(FileService fileservice) {
		this.fileservice = fileservice;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFileType() {
		return fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	public UserClassService getUserclassservice() {
		return userclassservice;
	}
	public void setUserclassservice(UserClassService userclassservice) {
		this.userclassservice = userclassservice;
	}

}
