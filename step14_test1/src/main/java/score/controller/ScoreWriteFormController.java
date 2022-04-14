package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ScoreWriteFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리 코드
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// view 처리 파일명 저장
		modelAndView.setViewName("scoreWriteForm.jsp");
		return modelAndView;
	}
}