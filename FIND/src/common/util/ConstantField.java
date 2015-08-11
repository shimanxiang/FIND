package common.util;

public class ConstantField {

	public static  String STATUS="status";
	public static final String USER_ID="user_id";
	public static final String USER_MAIL="user_mail";
	public static final String USER_PASSWORD="user_password";
	public static final String USER_NAME="user_name";
	public static final String USER_TYPE="user_type";
	public static final String USER_CLASS_NAME="user_class_name";
	public static final String PARAMS = "params";
	public static final String USER = "user";
	public static final String CLASSROOM ="classroom";
	public static final String FRONT_PARAMS="params";
	
	
	private final static String[] AUTHORITY={"班级创建者","班级管理员","普通用户","游客"};
	public final static String CLASS_CREATER="班级创建者";
	public final static String CLASS_MANAGER="班级管理员";
	public final static String PRIMARY_USER="普通用户";
	public final static String TOURIST="游客";
	
	public static String [] UPLOAD_IMG_TYPE={".jpg",".jepg",".bmp",".gif",".jpeg2000",".tiff",".psd",".png",".svg"};
	
	public static String [] UPLOAD_VIDEO_TYPE={".avi",".rmvb",".rm ",".asf",".divx",".mpg ",".mpeg ",".mpe", ".wmv" ,".mp4", ".mkv" };
	
	
	public static String [] SENSITIVE_WORDS_PATH={"/"+""};
	public static String UPLOAD_IMG_PATH="img";
	public static String UPLOAD_VIDEO_PATH="video";
	
	
//	public static final String HOST_BUCKET = "http://bcs.duapp.com/headpicturebucket";
	
}
