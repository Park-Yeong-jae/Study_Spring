package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;

//<bean id="dao" class="test,dao.GoodsDAO"/>
@Repository("dao")
public class GoodsDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//SQL 명령어들
	String GOODS_INSERT = "insert into goods values(?,?,?,?)";
	String GOODS_UPDATE = "update goods set name=?, price=?, maker=? "
							+ "where code=?";
	String GOODS_DELETE = "delete goods where code=?";
	String GOODS_GET ="select * from goods where code=?";
	String GOODS_LIST = "select * from goods order by code asc";
	
	// CRUD 기능
	// 1) 책 등록 : insert
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_INSERT);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	// 2) 책 수정 : update
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(GOODS_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getMaker());
			pstmt.setString(4, vo.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	// 3) 책 삭제 : delete
	public int deleteGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(GOODS_DELETE);
			pstmt.setString(1, vo.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	// 4) 책 상세 조회
	public GoodsVO getGoods(GoodsVO vo) {
	      GoodsVO vo1 = null;
	      conn = JDBCUtil.getConnection();
	      try {
	         pstmt = conn.prepareStatement(GOODS_GET);
	         pstmt.setString(1, vo.getCode());
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            vo1 = new GoodsVO();
	            vo1.setCode(rs.getString("code"));
	            vo1.setName(rs.getString("name"));
	            vo1.setPrice(rs.getInt("price"));
	            vo1.setMaker(rs.getString("maker"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(rs, pstmt, conn);
	      }
	      
	      return vo1;
	   }
	
	// 5) 책 목록 조회
	public List<GoodsVO> getGoodsList() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		GoodsVO vo = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_LIST);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
}
