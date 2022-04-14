package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreViewController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = dao.getScore(studNo);
		// 2. 화면 네비게이션
		request.setAttribute("dto", dto);
		request.setAttribute("pg", pg);
		
		return "scoreView";
	}

}
