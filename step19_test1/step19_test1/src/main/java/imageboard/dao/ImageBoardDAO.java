package imageboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import imageboard.bean.ImageBoardDTO;

public class ImageBoardDAO {
	String dirver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##dbexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ImageBoardDAO() {
		try {
			Class.forName(dirver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int imageboardWrite(ImageBoardDTO dto) {
		int result = 0;
		String sql = "insert into imageboard values(seq_imageboard.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getImageId());
			pstmt.setString(2, dto.getImageName());
			pstmt.setInt(3, dto.getImagePrice());
			pstmt.setInt(4, dto.getImageQty());
			pstmt.setString(5, dto.getImageContent());
			pstmt.setString(6, dto.getImage1());
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int getImgCnt() {
		int result = 0;
		String sql = "select count(*) as cnt from imageboard";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<ImageBoardDTO> imageboardList(int startNum, int endNum){
		List<ImageBoardDTO> list = new ArrayList<ImageBoardDTO>();
		String sql = "select * from "
				+ "(select rownum rn, tt. * from "
				+ "(select * from imageboard order by seq desc) tt) "
				+ "where rn>=? and rn<=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ImageBoardDTO dto = new ImageBoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setImageName(rs.getString("imageName"));
				dto.setImagePrice(rs.getInt("imagePrice"));
				dto.setImageQty(rs.getInt("imageQty"));
				dto.setImage1(rs.getString("image1"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public ImageBoardDTO imageboardView(int seq) {
		ImageBoardDTO dto = null;
		String sql = "select * from imageboard where seq = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ImageBoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setImageName(rs.getString("imageName"));
				dto.setImagePrice(rs.getInt("imagePrice"));
				dto.setImageQty(rs.getInt("imageQty"));
				dto.setImageContent(rs.getString("imageContent"));
				dto.setImage1(rs.getString("image1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public int imageDelete(int seq) {
		int result = 0;
		String sql = "delete imageboard where seq = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modify(ImageBoardDTO dto) {
		int result = 0;
		String sql = "update imageboard set imageName=?, imagePrice=?, imageQty=?, "
					 + " imageContent=?, image1=? where seq=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getImageName());
			pstmt.setInt(2, dto.getImagePrice());
			pstmt.setInt(3, dto.getImageQty());
			pstmt.setString(4, dto.getImageContent());
			pstmt.setString(5, dto.getImage1());
			pstmt.setInt(6, dto.getSeq());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
