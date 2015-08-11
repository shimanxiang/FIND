package find.service.classservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import common.entity.PageBean;
import common.servicebase.BaseService;
import find.entity.Classroom;
import find.entity.Photo;
import find.entity.User;
import find.responseentity.BaseClassInfoMsg;
import find.responseentity.BaseUserInfoMsg;
import find.responseentity.ClassAndStatusMsg;
import find.responseentity.UserAndStatusMsg;


public interface ClassService extends BaseService<Classroom>{
	
	 public boolean exits(String class_name);
	 public Classroom FindByClassname(String class_name);
	 public ClassAndStatusMsg FindByclassname(String class_name);
	 public List QueryByClassid(int class_id);
	 public List FuzzyQuery(String class_name);
	 public BaseClassInfoMsg queryBaseClassInfo(String class_name);
	 public ArrayList<BaseUserInfoMsg> queryClassUser(String class_name);
	 
}	
