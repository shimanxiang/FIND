package find.dao.classroom;
import common.daobase.BaseDAO;
import common.entity.PageBean;
import find.entity.Classroom;
import find.entity.Photo;
import find.entity.User;

public interface ClassroomDAO extends BaseDAO<Classroom>{
	
	public static final String binaryName = Classroom.class.getName();
	public static final String CLASS_ID = "class_id";
	public static final String CLASS_NAME = "class_name";
}
