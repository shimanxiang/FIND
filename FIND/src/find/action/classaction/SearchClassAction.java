package find.action.classaction;

import java.util.List;

import common.util.ConstantField;
import common.util.Status;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import find.entity.Classroom;
import find.responseentity.ClassAndStatusMsg;
import find.service.classservice.ClassService;
import find.service.userservice.UserService;
import find.util.BaseAction;

/**
 * 搜索班级
 * @author MONEY
 *
 */
public class SearchClassAction extends BaseAction{
	
	private String class_name;
	private ClassService classservice;
	@Override
	public String execute() throws Exception {
		
		System.out.println("搜索班级");
		this.getResponse().setContentType("text/json;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		JSONArray classlistjson=new JSONArray();
		try {
				List<Classroom> list=this.classservice.FuzzyQuery(class_name);
				classlistjson=JSONArray.fromObject(list);
				this.responseClient(classlistjson.toString());
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
	public ClassService getClassservice() {
		return classservice;
	}
	public void setClassservice(ClassService classservice) {
		this.classservice = classservice;
	}
}
