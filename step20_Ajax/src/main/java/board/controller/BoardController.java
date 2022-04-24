package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		// db
		//BoardDAO dao = new BoardDAO();
		int result = boardService.boardDelete(seq);

		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "board/boardListJson.do")
	public ModelAndView boardListJson(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<BoardDTO> list = boardService.getBoardList(startNum, endNum); 
		
		// JSON으로 결과값 반환
		String rt = null;
		int total = list.size();
		
		if(total > 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray items = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				BoardDTO dto = list.get(i);
				JSONObject temp = new JSONObject();
				temp.put("seq", dto.getSeq());
				temp.put("id", dto.getId());
				temp.put("name", dto.getName());
				temp.put("subject", dto.getSubject());
				temp.put("content", dto.getContent());
				temp.put("hit", dto.getHit());
				temp.put("logtime", dto.getLogtime());
				
				items.put(i, temp);
			}
			
			json.put("items", items);
		}
		
		// json 데이터 확인
		System.out.println("json : " + json);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("boardListJson.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		// 목록 : 1페이지당 5개씩 : ajax로 처리
		//int endNum = pg * 5;
		//int startNum = endNum - 4;
		
		//BoardDAO dao = new BoardDAO();
		//List<BoardDTO> list = boardService.getBoardList(startNum, endNum); 
		
		// 페이징 : 3블럭
		int totalA = boardService.getTotalBoard();  // 총 데이터 갯수
		int totalP = (totalA + 4) / 5;				// 총 페이지 수
		
		int startPage = (pg-1) / 3*3 + 1;
		int endPage = startPage + 2;	
		if(endPage > totalP) endPage = totalP;
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 공유데이터 저장
		modelAndView.addObject("pg", pg);
		//modelAndView.addObject("list", list);		// ajax로 처리
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		// view 처리 파일명 저장
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//BoardDAO dao = new BoardDAO();
		boardService.updateHit(seq);	// 조회수 증가

		BoardDTO dto = boardService.boardView(seq); 
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("boardView.jsp");
		
		return modelAndView;
	}

	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// 1. 데이터 처리 코드
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		BoardDTO dto = new BoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);

		//BoardDAO dao = new BoardDAO();
		int result = boardService.boardWrite(dto);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 2-1. 공유데이터 저장
		modelAndView.addObject("result", result);
		// 2-2. view 처리 파일명 저장
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardWriteForm.do")
	public String boardWriteForm() throws Exception {
		return "boardWriteForm.jsp";
/*		// 1. 데이터 처리 코드
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// view 처리 파일명 저장
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
*/
	}
}
