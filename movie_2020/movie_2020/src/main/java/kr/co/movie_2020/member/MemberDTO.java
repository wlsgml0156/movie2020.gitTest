package kr.co.movie_2020.member;

public class MemberDTO {
	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_email;
	private int m_no;

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public MemberDTO() {
	}

	@Override
	public String toString() {
		return "MemberDTO [m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_email=" + m_email
				+ ", m_no=" + m_no + "]";
	}

}
