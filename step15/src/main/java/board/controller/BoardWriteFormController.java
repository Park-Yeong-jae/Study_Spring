package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardWriteFormController{

	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리 코드
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// view 처리 파일명 저장
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}

}
