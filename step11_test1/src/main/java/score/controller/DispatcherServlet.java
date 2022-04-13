package score.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 클라이언트 요청 정보 추출
		String uri = request.getServletPath();
		String path = uri.substring(uri.lastIndexOf("/"));
		// System.out.println("uri = " + uri);
		System.out.println("path = " + path);

		// 2. 데이터 처리 코드 선택
		String view = null; // view 처리 파일명 저장

		if (path.equals("/scoreWrite.do")) {
			// 1. 데이터 처리
			String studNo = request.getParameter("studNo");
			String name = request.getParameter("name");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int mat = Integer.parseInt(request.getParameter("mat"));
			int tot = kor + eng + mat;
			double avg = tot / 3.0;
			
			ScoreDTO dto = new ScoreDTO();
			dto.setStudNo(studNo);
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMat(mat);
			dto.setTot(tot);
			dto.setAvg(avg);
			
			ScoreDAO dao = new ScoreDAO();
			int result = dao.insertScore(dto);
			
			// 2. 화면 네비게이션
			request.setAttribute("result", result);
			view = "../score/scoreWrite.jsp";
		} else if (path.equals("/scoreWriteForm.do")) {
			view = "../score/scoreWriteForm.jsp";
		} else if (path.equals("/scoreDelete.do")) {
			// 1. 데이터 처리
			int pg = Integer.parseInt(request.getParameter("pg"));
			String studNo = request.getParameter("studNo");
			
			ScoreDAO dao = new ScoreDAO();
			int result = dao.deleteScore(studNo);
			// 2. 화면 네비게이션
			request.setAttribute("pg", pg);
			request.setAttribute("studNo", studNo);
			request.setAttribute("result", result);
			view = "../score/scoreDelete.jsp";
		} else if (path.equals("/scoreView.do")) {
			// 1. 데이터 처리
			int pg = Integer.parseInt(request.getParameter("pg"));
			String studNo = request.getParameter("studNo");
			
			ScoreDAO dao = new ScoreDAO();
			ScoreDTO dto = dao.getScore(studNo);
			
			// 2. 화면 네비게이션
			request.setAttribute("pg", pg);
			request.setAttribute("studNo", studNo);
			request.setAttribute("dto", dto);
			view = "../score/scoreView.jsp";
		} else if (path.equals("/scoreList.do")) {
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
			
			// 2. 데이터 공유
			request.setAttribute("pg", pg);
			request.setAttribute("list", list);
			request.setAttribute("totalP", totalP);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			// 3. view 처리 파일 선택
			view = "../score/scoreList.jsp";
		}

		// 3. 화면이동
		if (view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

}
