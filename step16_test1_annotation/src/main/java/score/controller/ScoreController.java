package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreController {
	@RequestMapping(value = "/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request) {
		// 1. 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDAO dao = new ScoreDAO();
		int result = dao.deleteScore(studNo);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scoreDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request) {
		// 1. 데이터 처리
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		ScoreDAO dao = new ScoreDAO();
		int totalA = dao.getTotalA();	// 총 데이터 수
		int totalP = (totalA + 4) / 5;	// 총 페이수 수
		
		// 삭제 후 되돌아올 때, 페이지수가 총페이지보다 크면, 현재 페이지 수정
		if(pg > totalP) pg = totalP;
		
		// 목록 : 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<ScoreDTO> list = dao.getScoreList(startNum, endNum);
		
		// 페이징 : 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP) endPage = totalP;
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("scoreList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request) {
		// 1. 데이터 처리
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
	
	@RequestMapping(value = "/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request) {
		// 1. 데이터 처리
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scoreWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/score/scoreWriteForm.do")
	public String scoreWriteForm() {
		return "scoreWriteForm.jsp";
	}
}
