package find.entity;

import org.apache.naming.java.javaURLContextFactory;

public class UserClassroom implements java.io.Serializable{
	
	private int userclassroom_id;
	private User user;
	private Classroom classroom;
	
	public int getUserclassroom_id() {
		return userclassroom_id;
	}
	public void setUserclassroom_id(int userclassroom_id) {
		this.userclassroom_id = userclassroom_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
}
