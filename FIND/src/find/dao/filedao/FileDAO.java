package find.dao.filedao;
import common.daobase.BaseDAO;
import find.entity.Classroom;
import find.entity.File;
import find.entity.Photo;
import find.entity.User;
import find.entity.Video;
import find.entity.Word;

public interface FileDAO extends BaseDAO<File>{
	
	public static final String PhotoName=Photo.class.getName();
	public static final String VideoName=Video.class.getName();
	public static final String WordName=Word.class.getName();
	public static final String ClassroomName=Classroom.class.getName();
	public static final String UserName=User.class.getName();
	
}
