package find.action.classaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import common.util.ConstantField;
import common.util.Status;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import find.entity.Classroom;
import find.entity.File;
import find.entity.User;
import find.responseentity.BaseClassInfoMsg;
import find.responseentity.BaseUserInfoMsg;
import find.service.classservice.ClassService;
import find.service.fileservice.FileService;
import find.service.userclassservice.UserClassService;
import find.util.BaseAction;

public class ClassInformationAction extends BaseAction{
	
	private String class_name="2";
	private int currentPage=1;
	private int fileType=1;
	private ClassService classservice;
	private FileService fileservice;
	private UserClassService userclassservice;
	

	//获得班级基本信息
	@Override
	public String execute() throws Exception {
		System.out.println("查询班级基本信息");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject ClassInfjson = new JSONObject();
		if(class_name==null){
			ClassInfjson.put(ConstantField.STATUS,Status.PARAMETER_ERROR);
		}
		try {
			BaseClassInfoMsg baseClassInfo=this.classservice.queryBaseClassInfo(class_name);
			if(baseClassInfo!=null){
				ClassInfjson=JSONObject.fromObject(baseClassInfo);
				ClassInfjson.put(ConstantField.STATUS, Status.SUCCESS);
				System.out.println(ClassInfjson.toString());
				this.responseClient(ClassInfjson);
			}else {
				ClassInfjson.put(ConstantField.STATUS, Status.FAIL);
			}
		} catch (Exception e) {
			ClassInfjson.put(ConstantField.STATUS, Status.FAIL);
			this.responseClient(ClassInfjson);
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 获得班级上传
	 * 0.图片
	 * 1.视频
	 * 2.文章
	 */
	public String QueryClassFile() throws Exception{
		System.out.println("查找班级上传");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject ClassFilejson = new JSONObject();
		if(class_name==null){
			ClassFilejson.put(ConstantField.STATUS,Status.PARAMETER_ERROR);
		}
		try {
			Classroom classroom=this.classservice.FindByClassname(class_name);
			if (classroom!=null) {
				ArrayList<File> list=new ArrayList<File>();
				list=this.fileservice.QueryFile(classroom,currentPage,fileType);
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
	//查询班级成员
	public String QueryClassUser() throws Exception{
		
		System.out.println("查找班级成员");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject ClassUserjson = new JSONObject();
		if(class_name==null){
			ClassUserjson.put(ConstantField.STATUS,Status.PARAMETER_ERROR);
		}
		try {
			ArrayList<BaseUserInfoMsg> list=this.classservice.queryClassUser(class_name);
			if(list!=null){
				JSONArray jsonArray=new JSONArray();
				jsonArray=JSONArray.fromObject(list);
				System.out.println(jsonArray);
				ClassUserjson.put("userlist", jsonArray);
				ClassUserjson.put(ConstantField.STATUS, Status.SUCCESS);
				this.responseClient(ClassUserjson);
			}else{
				ClassUserjson.put(ConstantField.STATUS, Status.FAIL);
			}
		} catch (Exception e) {
			ClassUserjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
			this.responseClient(ClassUserjson);
			e.printStackTrace();
		}
		return null;
	}
	//查询关注该班级的成员
	public String QueryClassFollowUser() throws Exception{
		System.out.println("查询关注该班级的成员");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONObject ClassFollowUserjson = new JSONObject();
		if(class_name==null){
			ClassFollowUserjson.put(ConstantField.STATUS,Status.PARAMETER_ERROR);
		}
		try {
			Classroom classroom=this.classservice.FindByClassname(class_name);
			List<BaseUserInfoMsg> list=this.userclassservice.QueryClassFollowUser(classroom);
			if (list!=null) {
				JSONArray jsonArray=JSONArray.fromObject(list);
				ClassFollowUserjson.put("FollowUser", jsonArray);
				ClassFollowUserjson.put(ConstantField.STATUS, Status.SUCCESS);
				System.out.println(ClassFollowUserjson.toString());
				this.responseClient(ClassFollowUserjson);
			}else {
				ClassFollowUserjson.put(ConstantField.STATUS, Status.NO_FOLLOW);
				this.responseClient(ClassFollowUserjson);
			}
		} catch (Exception e) {
			ClassFollowUserjson.put(ConstantField.STATUS, Status.SERVER_UNAVAILABLE);
			this.responseClient(ClassFollowUserjson);
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
	public ClassService getClassservice() {
		return classservice;
	}
	public void setClassservice(ClassService classservice) {
		this.classservice = classservice;
	}
	public FileService getFileservice() {
		return fileservice;
	}
	public void setFileservice(FileService fileservice) {
		this.fileservice = fileservice;
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
