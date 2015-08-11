package find.entity;

import java.sql.Timestamp;
import java.util.Date;
public class Photo extends File implements java.io.Serializable{
	
		private int id;
		private String photo_title;
		private String photo_author;
		private Timestamp photo_publishtime;
		private String photo_link;
		private int photo_isShowAuthor;
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
		public String getPhoto_title() {
			return photo_title;
		}
		public void setPhoto_title(String photo_title) {
			this.photo_title = photo_title;
		}
		public String getPhoto_author() {
			return photo_author;
		}
		public void setPhoto_author(String photo_author) {
			this.photo_author = photo_author;
		}
		public Timestamp getPhoto_publishtime() {
			return photo_publishtime;
		}
		public void setPhoto_publishtime(Timestamp photo_publishtime) {
			this.photo_publishtime = photo_publishtime;
		}
		public String getPhoto_link() {
			return photo_link;
		}
		public void setPhoto_link(String photo_link) {
			this.photo_link = photo_link;
		}
		public int getPhoto_isShowAuthor() {
			return photo_isShowAuthor;
		}
		public void setPhoto_isShowAuthor(int photo_isShowAuthor) {
			this.photo_isShowAuthor = photo_isShowAuthor;
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
