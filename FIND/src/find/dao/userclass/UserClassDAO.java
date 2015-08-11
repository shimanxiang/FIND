package find.dao.userclass;

import common.daobase.BaseDAO;
import find.entity.UserClassroom;

public interface UserClassDAO extends BaseDAO<UserClassroom>{
	public static final String binaryName=UserClassroom.class.getName();
	public static final String USER = "user";
	public static final String CLASSROOM="classroom";
}
