package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreListController {
	@RequestMapping(value="/score/scoreList.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		int totalA = dao.getTotalA(); // 총 데이터 수
		int totalP = (totalA + 4) / 5; // 총 페이수 수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);

		modelAndView.setViewName("scoreList.jsp");

		return modelAndView;
	}
}
