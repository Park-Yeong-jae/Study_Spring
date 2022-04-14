package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));

		// db
		ScoreDAO dao = new ScoreDAO();
		int result = dao.deleteScore(studNo);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("studNo", studNo);
		modelAndView.setViewName("scoreDelete.jsp");
		return modelAndView;
	}
}