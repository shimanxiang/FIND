package find.entity;

import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable{
	
	private int user_id;
	private String user_mail;
	private String user_nickname;
	private String user_psw;	
	private String user_type;
	private Classroom classroom;
	private Corporation corporation;
	
	//图片
	private Set user_pic=new HashSet(0);
	//视频
	private Set user_video=new HashSet(0);
	//文章
	private Set user_word=new HashSet(0);
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_psw() {
		return user_psw;
	}
	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
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
	
	public Set getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(Set user_pic) {
		this.user_pic = user_pic;
	}
	public Set getUser_video() {
		return user_video;
	}
	public void setUser_video(Set user_video) {
		this.user_video = user_video;
	}
	public Set getUser_word() {
		return user_word;
	}
	public void setUser_word(Set user_word) {
		this.user_word = user_word;
	}
}
