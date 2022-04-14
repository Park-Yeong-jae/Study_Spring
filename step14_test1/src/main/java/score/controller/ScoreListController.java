package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		ScoreDAO dao = new ScoreDAO();
		int totalA = dao.getTotalA();   	// 총 데이터 갯수
		int totalP = (totalA + 4) / 5;		// 총 페이지 수
		
		// 삭제후 되돌아 올 때, 페이지수가 총페이지보다 크면, 현재 페이지 수정
		if(pg > totalP) pg = totalP;  
		
		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;		
		
		List<ScoreDTO> list = dao.getScoreList(startNum, endNum);
		
		// 페이징 : 3블럭		
		int startPage = (pg-1) / 3*3 + 1;
		int endPage = startPage + 2;	
		if(endPage > totalP) endPage = totalP;
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 공유데이터 저장
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		// view 처리 파일명 저장
		modelAndView.setViewName("scoreList.jsp");
		return modelAndView;
	}
}
