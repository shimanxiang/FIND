package find.service.userclassservice;

import java.util.List;

import common.servicebase.BaseService;
import find.entity.Classroom;
import find.entity.User;
import find.entity.UserClassroom;
import find.responseentity.BaseClassInfoMsg;
import find.responseentity.BaseUserInfoMsg;

public interface UserClassService extends BaseService<UserClassroom>{
	
	public List<BaseClassInfoMsg> QueryUserFollowClass(User user); 
	public List<BaseUserInfoMsg> QueryClassFollowUser(Classroom classroom);
	
}
