package kr.co.movie_2020.cover;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class CoverDAO {
	@Autowired
	DBOpen dbopen;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql = null;
	ArrayList<CoverDTO> list = null;

	public CoverDAO() {}

	public int create(CoverDTO dto) {
		int cnt = 0;
		try {

			con = dbopen.getConnection();
			sql = new StringBuffer();
			sql.append(
					" insert into movie(ititle, igenre, iforeman, icast, irlsDate, irating, poster, icontent, imonth ) ");
			sql.append(" values(?,?,?,?,?,?,?,?,?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getItitle());
			pstmt.setString(2, dto.getIgenre());
			pstmt.setString(3, dto.getIforeman());
			pstmt.setString(4, dto.getIcast());
			pstmt.setString(5, dto.getIrlsDate());
			pstmt.setString(6, dto.getIrating());
			pstmt.setString(7, dto.getPoster());
			pstmt.setString(8, dto.getIcontent());
			pstmt.setString(9, dto.getImonth());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("(영화)creat 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	} // create() end

	public ArrayList<CoverDTO> list(String imonth) {
		list = new ArrayList<CoverDTO>();
		try {

			con = dbopen.getConnection();
			sql = new StringBuffer();
			sql.append(" select ititle, igenre, irlsDate, poster, imovieno ");
			sql.append(" from movie where imonth=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, imonth);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					CoverDTO dto = new CoverDTO();
					dto.setItitle(rs.getString("ititle"));
					dto.setIgenre(rs.getString("igenre"));
					dto.setIrlsDate(rs.getString("irlsDate"));
					dto.setPoster(rs.getString("poster"));
					dto.setImovieno(rs.getInt("imovieno"));
					list.add(dto);
				} while (rs.next());
			}else {
				list = null;
			}

		} catch (Exception e) {
			System.out.println("(영화)list 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return list;
	} // list() end

	public CoverDTO movieDetail(int imovieno) {
		CoverDTO dto = new CoverDTO();
		try {
			con = dbopen.getConnection();
			sql = new StringBuffer();
			sql.append(" select ititle, igenre, iforeman, icast, irlsDate, irating, poster, icontent, imovieno ");
			sql.append(" from movie where imovieno=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, imovieno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setItitle(rs.getString("ititle"));
				dto.setIgenre(rs.getString("igenre"));
				dto.setIforeman(rs.getString("iforeman"));
				dto.setIcast(rs.getString("icast"));
				dto.setIrlsDate(rs.getString("irlsDate"));
				dto.setIrating(rs.getString("irating"));
				dto.setPoster(rs.getString("poster"));
				dto.setIcontent(rs.getString("icontent"));
				dto.setImovieno(rs.getInt("imovieno"));
			}

		} catch (Exception e) {
			System.out.println("(영화)movieDetail 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	} // movieDetail() end

	public int update(CoverDTO dto) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();
			sql = new StringBuffer();
			sql.append(" update movie");
			sql.append(
					" set ititle=?, igenre=?, iforeman=?, icast=?, irlsDate=?, irating=?, poster=?, icontent=?, imovieno=? ");
			sql.append(" where imovieno=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getItitle());
			pstmt.setString(2, dto.getIgenre());
			pstmt.setString(3, dto.getIforeman());
			pstmt.setString(4, dto.getIcast());
			pstmt.setString(5, dto.getIrlsDate());
			pstmt.setString(6, dto.getIrating());
			pstmt.setString(7, dto.getPoster());
			pstmt.setString(8, dto.getIcontent());
			pstmt.setInt(9, dto.getImovieno());
			pstmt.setInt(10, dto.getImovieno());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("(영화)update수정 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	} // update() end

	public int delete(int imovieno) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuffer();
			sql.append(" DELETE FROM movie");
			sql.append(" WHERE imovieno=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, imovieno);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("(영화)delete삭제 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		}

		return cnt;
	} // delete() end

}
