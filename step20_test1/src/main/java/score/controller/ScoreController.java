package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;

@Controller
public class ScoreController {
	@Autowired
	ScoreService scoreService;
	
	@RequestMapping("/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request) {
		// 1. 데이터 처리
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));

		// db
		//ScoreDAO dao = new ScoreDAO();
		int result = scoreService.deleteScore(studNo); 
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("studNo", studNo);
		modelAndView.setViewName("scoreDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreListJson.do")
	public ModelAndView scoreListJson(HttpServletRequest request) throws Exception{
		// 1. 데이터 처리 코드
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<ScoreDTO> list = scoreService.getScoreList(startNum, endNum);
		
		// json으로 결과값 반환
		String rt = null;
		int total = list.size();
		
		if(total > 0) rt = "OK";
		else rt = "FAIL";
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray items = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				ScoreDTO dto = list.get(i);
				JSONObject temp = new JSONObject();
				temp.put("studNo", dto.getStudNo());
				temp.put("name", dto.getName());
				temp.put("kor", dto.getKor());
				temp.put("eng", dto.getEng());
				temp.put("mat", dto.getMat());
				temp.put("tot", dto.getTot());
				temp.put("avg", dto.getAvg());
				temp.put("logtime", dto.getLogtime());
				
				items.put(i, temp);
			}
			json.put("items", items);
		}
		System.out.println("json" + json);  // json 내용 확인
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("scoreListJson.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request) {
		// 1. 데이터 처리 코드
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		//ScoreDAO dao = new ScoreDAO();
		int totalA = scoreService.getTotalA();   	// 총 데이터 갯수
		int totalP = (totalA + 4) / 5;		// 총 페이지 수
		
		// 삭제후 되돌아 올 때, 페이지수가 총페이지보다 크면, 현재 페이지 수정
		if(pg > totalP) pg = totalP;  
		
		// 목록 : 1페이지당 5개씩  // ajax로 처리함
		//int endNum = pg * 5;
		//int startNum = endNum - 4;		
		
		//List<ScoreDTO> list = scoreService.getScoreList(startNum, endNum);
		
		// 페이징 : 3블럭		
		int startPage = (pg-1) / 3*3 + 1;
		int endPage = startPage + 2;	
		if(endPage > totalP) endPage = totalP;
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 공유데이터 저장
		modelAndView.addObject("pg", pg);
		//modelAndView.addObject("list", list);		// ajax로 처리함
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		// view 처리 파일명 저장
		modelAndView.setViewName("scoreList.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreModify.do")
	public ModelAndView scoreModify(HttpServletRequest request) {
		// 1. 데이터 처칠
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
		// db
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		//System.out.println(dto.toString());
		
		//ScoreDAO dao = new ScoreDAO();
		int result = scoreService.updateScore(dto);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scoreModify.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreModifyForm.do")
	public ModelAndView scoreModifyForm(HttpServletRequest request) throws Exception {
		// 1. 데이터 처리
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// db
		//ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = scoreService.getScore(studNo);
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("scoreModifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request) {
		// 1. 데이터 처리
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = scoreService.getScore(studNo); 
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("scoreView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// 1. 데이터 처리 코드
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

		//ScoreDAO dao = new ScoreDAO();
		int result = scoreService.insertScore(dto);

		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 2-1. 공유데이터 저장
		modelAndView.addObject("result", result);
		// 2-2. view 처리 파일명 저장
		modelAndView.setViewName("scoreWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreWriteForm.do")
	public String scoreWriteForm() {
		return "scoreWriteForm.jsp";
	}
}
