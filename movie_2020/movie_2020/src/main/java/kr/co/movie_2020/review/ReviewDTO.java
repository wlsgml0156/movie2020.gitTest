package kr.co.movie_2020.review;

public class ReviewDTO {
	private int bbsno;
	private String wname;
	private String subject;
	private String content;
	private int readcnt;
	private String regdt;

	public int getBbsno() {
		return bbsno;
	}

	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public ReviewDTO() {
	}

	@Override
	public String toString() {
		return "ReviewDTO [bbsno=" + bbsno + ", wname=" + wname + ", subject=" + subject + ", content=" + content
				+ ", readcnt=" + readcnt + ", regdt=" + regdt + "]";
	}

}
