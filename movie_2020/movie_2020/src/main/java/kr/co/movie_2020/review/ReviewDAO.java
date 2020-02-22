package kr.co.movie_2020.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class ReviewDAO {

	@Autowired
	private DBOpen dbopen;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;

	public int create(ReviewDTO dto) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" insert into reviewBbs(wname, subject, content, readcnt )  ");
			sql.append(" values(?,?,?,0) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("리뷰추가 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	}// create() end

	public List<ReviewDTO> selectList() {

		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select bbsno, subject, readcnt, wname, regdt  ");
			sql.append(" from reviewBbs order by bbsno desc ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO reviewDto = new ReviewDTO();
				reviewDto.setBbsno(rs.getInt("bbsno"));
				reviewDto.setWname(rs.getString("wname"));
				reviewDto.setReadcnt(rs.getInt("readcnt"));
				reviewDto.setSubject(rs.getString("subject"));
				reviewDto.setRegdt(rs.getString("regdt"));
				list.add(reviewDto);
			}

		} catch (Exception e) {
			System.out.println("리뷰가져오기 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return list;

	} // selectList() end

	public void incrementCnt(int bbsno) {
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE reviewBbs");
			sql.append(" SET readcnt=readcnt+1 ");
			sql.append(" WHERE bbsno=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("조회수 증가 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // try end
	}// incrementCnt() end

	public List<ReviewDTO> selectOne(int bbsno) {

		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select bbsno, subject, readcnt, wname, regdt, content  ");
			sql.append(" from reviewBbs where bbsno=? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO reviewDto = new ReviewDTO();
				reviewDto.setBbsno(bbsno);
				reviewDto.setWname(rs.getString("wname"));
				reviewDto.setReadcnt(rs.getInt("readcnt"));
				reviewDto.setSubject(rs.getString("subject"));
				reviewDto.setRegdt(rs.getString("regdt"));
				String content = rs.getString("content");
				content = content.replace("\n", "<br/>");
				content = content.replace(" ", "&nbsp;");
				reviewDto.setContent(content);
				list.add(reviewDto);
				
			}


		} catch (Exception e) {
			System.out.println("리뷰가져오기 실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return list;

	} // selectOne() end

	public ReviewDTO reviewInfo(int bbsno) {
		ReviewDTO dto = new ReviewDTO();

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select subject, content, wname, bbsno ");
			sql.append(" from  reviewBbs ");
			sql.append(" where bbsno=?  ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setWname(rs.getString("wname"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setBbsno(rs.getInt("bbsno"));
			}

		} catch (Exception e) {
			System.out.println("리뷰수정정보가져오기 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return dto;

	} // reviewInfo() end

	public int reviewInfoChange(ReviewDTO dto, int bbsno) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" update reviewBbs ");
			sql.append(" set content = ?,subject = ? ");
			sql.append(" where bbsno=?  ");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getSubject());
			pstmt.setInt(3, bbsno);

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시글수정 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	} // reviewInfoChange() end

	public int delete(int bbsno) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" delete from reviewBbs ");
			sql.append(" where bbsno=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bbsno);

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시글삭제 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}

	public int totalCount() {

		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append("SELECT count(*) AS cnt FROM reviewBbs");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	}

	// startNum ~ endNum 구간 리스트 반환
	public ArrayList<ReviewDTO> pagedList(int startNum, int endNum) {
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select bbsno,subject,wname,readcnt,regdt ");
			sql.append(" from (select (@rownum := @rownum +1) as rn, bbsno, subject, wname, readcnt, regdt  ");
			sql.append(" from (select bbsno,subject,wname,readcnt,regdt  from reviewBbs ");
			sql.append(" order by bbsno desc limit 10000000) A, (select @rownum :=0) as x limit ? ");
			sql.append(" ) B where rn >= ? ");
			
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1, endNum);
			pstmt.setInt(2, startNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBbsno(rs.getInt("bbsno"));
				dto.setSubject(rs.getString("subject"));
				dto.setWname(rs.getString("wname"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setRegdt(rs.getString("regdt"));
			
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return list;
	}



}
