package find.action.classaction;

import net.sf.json.JSONObject;
import common.util.ConstantField;
import common.util.Status;
import find.entity.Classroom;
import find.service.classservice.ClassService;
import find.util.BaseAction;
/**
 * 创建，删除班级 显示班级信息
 * @author MONEY
 *
 */
public class ClassroomManagerAction extends BaseAction{
	private String class_name;
	private String class_head_pic_link;
	private String class_introduction;
	private ClassService classservice;
	@Override
	public String execute() throws Exception {
		
		System.out.println("班级管理");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		
		JSONObject createclassjson = new JSONObject();
		try {
			if (this.classservice.exits(class_name)!=true) {
	
				Classroom classroom=new Classroom();
				classroom.setClass_name(class_name);
				classroom.setClass_head_pic_link(class_head_pic_link);
				classroom.setClass_introduction(class_introduction);
				
				this.classservice.add(classroom);
				createclassjson.put(ConstantField.STATUS, Status.SUCCESS); // 创建班级成功
				System.out.println(createclassjson.toString());
				this.responseClient(createclassjson);
				}else {
					createclassjson.put(ConstantField.STATUS, Status.CLASS_ACCONUT_EXIST); // 班级已经存在
					System.out.println(createclassjson.toString());
					this.responseClient(createclassjson);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
		
		}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_head_pic_link() {
		return class_head_pic_link;
	}
	public void setClass_head_pic_link(String class_head_pic_link) {
		this.class_head_pic_link = class_head_pic_link;
	}
	public ClassService getClassservice() {
		return classservice;
	}
	public void setClassservice(ClassService classservice) {
		this.classservice = classservice;
	}
	public String getClass_introduction() {
		return class_introduction;
	}
	public void setClass_introduction(String class_introduction) {
		this.class_introduction = class_introduction;
	}
}
