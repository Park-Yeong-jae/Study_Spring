package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.dao.ScoreDAO;

@Controller
public class ScoreDeleteController {
	@RequestMapping(value="/score/scoreDelete.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");

		ScoreDAO dao = new ScoreDAO();
		int result = dao.deleteScore(studNo);
		
		// 2. 화면 네비게이션		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);

		modelAndView.setViewName("scoreDelete.jsp");

		return modelAndView;
	}
}
