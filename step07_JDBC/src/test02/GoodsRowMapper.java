package test02;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GoodsRowMapper implements RowMapper<GoodsVO> {

	@Override
	public GoodsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		GoodsVO vo = new GoodsVO();
		vo.setCode(rs.getString("code"));
		vo.setName(rs.getString("name"));
		vo.setPrice(rs.getInt("price"));
		vo.setMaker(rs.getString("maker"));
		return vo;
	}
}
