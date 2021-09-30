package entities;

public class DoctorNotice {
	int noteid = 0;
	String title = "";
	String content = "";

	public int getNoteid() {
		return noteid;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public DoctorNotice(int noteid, String title, String content) {
		super();
		this.noteid = noteid;
		this.title = title;
		this.content = content;
	}

}
