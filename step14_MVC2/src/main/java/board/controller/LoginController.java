package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");	// 한글 인코딩 설정
		// 1. 데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		
		// 2. 화면 네비게이션
		// ModelAndView : 화면 네비게이션 정보를 저장하는 클래스
		//  => 공유데이터 저장
		//  => view 파일명 저장
		ModelAndView modelAndView = new ModelAndView();
		if(name != null){
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			
			//response.sendRedirect("../board/boardList.jsp");	
			modelAndView.setViewName("redirect:../board/boardList.do");
		} else {		
			//response.sendRedirect("loginForm.jsp");
			modelAndView.setViewName("redirect:loginForm.jsp");
		}
		return modelAndView;
	}

}
