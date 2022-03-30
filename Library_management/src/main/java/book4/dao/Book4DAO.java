package book4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book4.bean.Book4DTO;

public class Book4DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##dbexam";
	String password = "m1234";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Book4DAO() {
		try {
			Class.forName(driver);
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
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 글 저장
	public int book4Write(Book4DTO dto) {
		int result = 0;
		String sql = "insert into book4 values(?, ?, ?, ?, ?, ?)";

		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBook4_code());
			pstmt.setString(2, dto.getBook4_name());
			pstmt.setString(3, dto.getBook4_author());
			pstmt.setString(4, dto.getBook4_publisher());
			pstmt.setInt(5, dto.getBook4_price());
			pstmt.setString(6, dto.getBook4_date());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 목록
	public List<Book4DTO> getBook4List(int startNum, int endNum) {
		List<Book4DTO> list = new ArrayList<Book4DTO>();
		String sql = "select * from (select rownum rn, tt.* from " + "(select * from book4 order by book4_code asc) tt)"
				+ "where rn>=? and rn<=?";

		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Book4DTO dto = new Book4DTO();
				dto.setBook4_code(rs.getString("book4_code"));
				dto.setBook4_name(rs.getString("book4_name"));
				dto.setBook4_author(rs.getString("book4_author"));
				dto.setBook4_publisher(rs.getString("book4_publisher"));
				dto.setBook4_price(rs.getInt("book4_price"));
				dto.setBook4_date(rs.getString("book4_date"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 총 데이터 갯수
	public int getTotalBook4() {
		int result = 0;
		String sql = "select count(*) as cnt from book4";

		conn = getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
