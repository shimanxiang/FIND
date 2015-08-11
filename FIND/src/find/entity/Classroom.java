package find.entity;

import java.util.HashSet;
import java.util.Set;

public class Classroom implements java.io.Serializable{
	
	private int class_id;
	private String class_name;
	
	private String class_head_pic_link;
	
	private String class_introduction;
	
	//图片
	private Set class_pic=new HashSet(0);
	//视频
	private Set class_video=new HashSet(0);
	//文章
	private Set class_word=new HashSet(0);
	//用户
	private Set class_user=new HashSet(0);
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_head_pic_link() {
		return class_head_pic_link;
	}
	public void setClass_head_pic_link(String class_head_pic_link) {
		this.class_head_pic_link = class_head_pic_link;
	}
	public String getClass_introduction() {
		return class_introduction;
	}
	public void setClass_introduction(String class_introduction) {
		this.class_introduction = class_introduction;
	}
	public Set getClass_pic() {
		return class_pic;
	}
	public void setClass_pic(Set class_pic) {
		this.class_pic = class_pic;
	}
	public Set getClass_video() {
		return class_video;
	}
	public void setClass_video(Set class_video) {
		this.class_video = class_video;
	}
	public Set getClass_word() {
		return class_word;
	}
	public void setClass_word(Set class_word) {
		this.class_word = class_word;
	}
	public Set getClass_user() {
		return class_user;
	}
	public void setClass_user(Set class_user) {
		this.class_user = class_user;
	}
	
}
