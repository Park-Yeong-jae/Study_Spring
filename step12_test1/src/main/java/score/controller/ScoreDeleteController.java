package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDAO dao = new ScoreDAO();
		int result = dao.deleteScore(studNo);
		// 2. 화면 네비게이션
		request.setAttribute("result", result);
		request.setAttribute("pg", pg);
		
		return "scoreDelete";
	}

}
