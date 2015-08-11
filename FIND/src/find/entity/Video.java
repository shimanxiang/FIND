package find.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Video extends File implements java.io.Serializable{
	private int id;
	private String video_title;
	private String video_author;
	private Timestamp video_publishtime;
	private String video_link;
	private int file_type;
	
	private int video_isShowAuthor;
	private Classroom classroom;
	private Corporation corporation;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public String getVideo_author() {
		return video_author;
	}
	public void setVideo_author(String video_author) {
		this.video_author = video_author;
	}
	public Timestamp getVideo_publishtime() {
		return video_publishtime;
	}
	public void setVideo_publishtime(Timestamp video_publishtime) {
		this.video_publishtime = video_publishtime;
	}
	public String getVideo_link() {
		return video_link;
	}
	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}
	public int getVideo_isShowAuthor() {
		return video_isShowAuthor;
	}
	public void setVideo_isShowAuthor(int video_isShowAuthor) {
		this.video_isShowAuthor = video_isShowAuthor;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public Corporation getCorporation() {
		return corporation;
	}
	public void setCorporation(Corporation corporation) {
		this.corporation = corporation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFile_type() {
		return file_type;
	}
	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}
}
