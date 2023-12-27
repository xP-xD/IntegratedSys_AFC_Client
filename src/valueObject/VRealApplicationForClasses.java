package valueObject;

import java.io.Serializable;

public class VRealApplicationForClasses implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String lectureId;
	private String lecture;
	private String professor;
	private String credit;
	private String time;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLectureId() {
		return lectureId;
	}
	public void setLectureId(String id) {
		this.lectureId = id;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
