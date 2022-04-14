package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreViewController {
	
	@RequestMapping(value="/score/scoreView.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");

		ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = dao.getScore(studNo);
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);

		modelAndView.setViewName("scoreView.jsp");

		return modelAndView;
	}
}
