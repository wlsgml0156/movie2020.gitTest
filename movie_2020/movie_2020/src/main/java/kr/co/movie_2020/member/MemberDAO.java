package kr.co.movie_2020.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class MemberDAO {

	@Autowired
	private DBOpen dbopen;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;
	ArrayList<MemberDTO> list = null;

	public MemberDAO() {
		dbopen = new DBOpen();
	}

	public int joinIns(MemberDTO dto) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" insert into member( m_id, m_pwd, m_name,m_email ) ");
			sql.append(" values(?,?,?,?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pwd());
			pstmt.setString(3, dto.getM_name());
			pstmt.setString(4, dto.getM_email());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원가입 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	}// joinIns() end

	public int duplecateID(String m_id) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();

			sql.append(" SELECT COUNT(m_id) as cnt ");
			sql.append(" FROM member ");
			sql.append(" WHERE m_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} 
		return cnt;
	}// duplecateID() end

	public String loginProc(MemberDTO dto) {
		String m_id = null;

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT m_id ");
			sql.append(" FROM member ");
			sql.append(" WHERE m_id=? AND m_pwd=? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pwd());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				m_id = rs.getString("m_id");
			} else {
				m_id = "guest";
			} // if end

		} catch (Exception e) {
			System.out.println("로그인실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end

		return m_id;

	} // loginProc() end

	public MemberDTO myInfo(String m_id) {

		MemberDTO dto = new MemberDTO();

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select m_id, m_pwd, m_name, m_email ");
			sql.append(" from member where m_id=? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setM_id(rs.getString("m_id"));
				dto.setM_pwd(rs.getString("m_pwd"));
				dto.setM_email(rs.getString("m_email"));
				dto.setM_name(rs.getString("m_name"));

			} else {
				m_id = null;
			} // if end

		} catch (Exception e) {
			System.out.println("회원정보조회 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end

		return dto;

	} // myInfo() end

	public int myinfoUpdate(MemberDTO dto) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" update member ");
			sql.append(" set m_pwd=? , m_name=? , m_email=? ");
			sql.append(" where m_id=?  ");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, dto.getM_pwd());
			pstmt.setString(2, dto.getM_name());
			pstmt.setString(3, dto.getM_email());
			pstmt.setString(4, dto.getM_id());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원정보수정 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	} // myinfoUpdate() end

	public String checkPw(MemberDTO dto) {
		String result = "";
		String m_id = dto.getM_id();
		String m_pwd = dto.getM_pwd();
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select count(*) ");
			sql.append(" from member ");
			sql.append(" where m_id =? and m_pwd=? ");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = m_pwd;
			} else {
				m_id = null;
			} // if end

			if (cnt == 1) {
				result = m_pwd;
			} // if end

		} catch (Exception e) {
			System.out.println("비밀번호확인 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		System.out.println(m_id);
		System.out.println(m_pwd);
		System.out.println(result);
		System.out.println("---");

		return result;

	} // checkPw() end

	public int delete(String s_id, String m_pwd) {
		int cnt = 0;
		String m_id = s_id;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" delete from member ");
			sql.append(" where m_id =? and m_pwd =? ");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pwd);

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원탈퇴 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	} //delete() end

}
