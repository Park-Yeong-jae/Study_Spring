package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = (String)session.getAttribute("memId");
		String name =(String)session.getAttribute("memName");	
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = dao.boardWrite(dto);
		
		// 2. 화면 네비게이션
		request.setAttribute("result", result);
		return "boardWrite";
	}

}
