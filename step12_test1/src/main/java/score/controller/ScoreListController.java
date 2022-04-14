package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		// 목록 : 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		ScoreDAO dao = new ScoreDAO();
		List<ScoreDTO> list = dao.getScoreList(startNum, endNum);
		
		// 페이징 : 3블럭
		int totalA = dao.getTotalA();	// 총 데이터 수
		int totalP = (totalA + 4) / 5;	// 총 페이수 수
		
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP) endPage = totalP;
		
		// 2. 화면 네비게이션
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("totalP", totalP);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		
		return "scoreList";
	}

}
