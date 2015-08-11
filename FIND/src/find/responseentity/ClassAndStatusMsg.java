package find.responseentity;

import common.util.Status;
import find.entity.Classroom;

public class ClassAndStatusMsg {
	
	private int class_id;
	private String class_name;
	private Status status;
	private String class_class_head_pic_link;
	private String class_introduction;
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getClass_class_head_pic_link() {
		return class_class_head_pic_link;
	}
	public void setClass_class_head_pic_link(String class_class_head_pic_link) {
		this.class_class_head_pic_link = class_class_head_pic_link;
	}
	public String getClass_introduction() {
		return class_introduction;
	}
	public void setClass_introduction(String class_introduction) {
		this.class_introduction = class_introduction;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
}
