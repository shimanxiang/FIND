package find.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Word  extends File implements java.io.Serializable{
	
	private int id;
	private String word_author;
	private String word_title;
	private String word_content;
	private Date word_happentime;
	private Timestamp word_publishtime;
	private int word_isShowAuthor;
	private int file_type;
	private Classroom classroom;
	private Corporation corporation;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord_author() {
		return word_author;
	}
	public void setWord_author(String word_author) {
		this.word_author = word_author;
	}
	public String getWord_title() {
		return word_title;
	}
	public void setWord_title(String word_title) {
		this.word_title = word_title;
	}
	public String getWord_content() {
		return word_content;
	}
	public void setWord_content(String word_content) {
		this.word_content = word_content;
	}
	public Date getWord_happentime() {
		return word_happentime;
	}
	public void setWord_happentime(Date word_happentime) {
		this.word_happentime = word_happentime;
	}
	public Timestamp getWord_publishtime() {
		return word_publishtime;
	}
	public void setWord_publishtime(Timestamp word_publishtime) {
		this.word_publishtime = word_publishtime;
	}
	public int getWord_isShowAuthor() {
		return word_isShowAuthor;
	}
	public void setWord_isShowAuthor(int word_isShowAuthor) {
		this.word_isShowAuthor = word_isShowAuthor;
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
