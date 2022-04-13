package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청 정보 추출
		String uri = request.getServletPath();
		String path = uri.substring(uri.lastIndexOf("/"));
		//System.out.println("uri = " + uri);    	// uri = /member/login.do
		System.out.println("path = " + path);	// path = /login.do
		
		// 2. 데이터 처리 코드 선택
		String view = null;  // view 처리 파일명 저장
		HttpSession session = request.getSession();
		
		if(path.equals("/login.do")) {
			request.setCharacterEncoding("utf-8");	// 한글 인코딩 설정
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			// DB
			MemberDAO dao = new MemberDAO();
			String name = dao.login(id, pwd);			
			
			if(name != null){
				session.setAttribute("memName", name);
				session.setAttribute("memId", id);
				
				response.sendRedirect("../board/boardList.do");		
			} else {		
				response.sendRedirect("loginForm.jsp");
			}
		} else if(path.equals("/boardWriteForm.do")) {
			view = "../board/boardWriteForm.jsp";
		} else if(path.equals("/boardWrite.do")) {
			// 1. 데이터 처리
			request.setCharacterEncoding("utf-8");  // 한글 인코딩 설정
			
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String id = (String)session.getAttribute("memId");
			String name = (String)session.getAttribute("memName");
			
			// DB처리
			BoardDTO dto = new BoardDTO();
			dto.setId(id);
			dto.setName(name);
			dto.setSubject(subject);
			dto.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			int result = dao.boardWrite(dto);  
			// 2. 화면 네비게이션 = 데이터 공유 + view 처리 파일 선택
			request.setAttribute("result", result);
			view = "../board/boardWrite.jsp";
		} else if(path.equals("/boardDelete.do")) {
			// 1. 데이터 처리
			//데이터
			int seq = Integer.parseInt(request.getParameter("seq"));
			int pg = Integer.parseInt(request.getParameter("pg"));
			
			// db
			BoardDAO dao = new BoardDAO();
			int result = dao.boardDelete(seq);
			// 2. 화면 네비게이션
			request.setAttribute("result", result);
			request.setAttribute("seq", seq);
			request.setAttribute("pg", pg);
			view = "../board/boardDelete.jsp";			
		} else if(path.equals("/boardView.do")) {
			// 1. 데이터 처리
			int seq = Integer.parseInt(request.getParameter("seq"));
			int pg = Integer.parseInt(request.getParameter("pg"));
			
			BoardDAO dao = new BoardDAO();
			// 조회수 증가
			dao.updateHit(seq);
			// 상세보기 데이터
			BoardDTO dto = dao.boardView(seq); 
			// 2. 화면 네비게이션
			request.setAttribute("seq", seq);
			request.setAttribute("pg", pg);
			request.setAttribute("dto", dto);
			view = "../board/boardView.jsp";
		} else if(path.equals("/boardList.do")) {
			// 1. 데이터 처리
			int pg = 1;
			if(request.getParameter("pg") != null)
				pg = Integer.parseInt(request.getParameter("pg"));
			
			// 목록 : 1페이지당 5개씩
			int endNum = pg * 5;
			int startNum = endNum - 4;
			
			BoardDAO dao = new BoardDAO();
			List<BoardDTO> list = dao.getBoardList(startNum, endNum);
			
			// 페이징 : 3블럭
			int totalA = dao.getTotalBoard();   // 총 데이터 갯수
			int totalP = (totalA + 4) / 5;		// 총 페이지 수
			
			int startPage = (pg-1) / 3*3 + 1;
			int endPage = startPage + 2;	
			if(endPage > totalP) endPage = totalP;
			// 2. 데이터 공유
			request.setAttribute("pg", pg);
			request.setAttribute("list", list);
			request.setAttribute("totalP", totalP);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			// 3. view 처리 파일 선택
			view = "../board/boardList.jsp";
		} 
		
		// 3. 화면이동
		if(view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
