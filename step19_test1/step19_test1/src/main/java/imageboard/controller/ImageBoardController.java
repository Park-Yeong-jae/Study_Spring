package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageBoardDTO;
import imageboard.dao.ImageBoardDAO;

@Controller
public class ImageBoardController {

	@RequestMapping(value = "/ImageBoard/imageboardWriteForm.do")
	public ModelAndView imageboardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("imageboardWriteForm.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/ImageBoard/imageboardWrite.do")
	public ModelAndView imageboardWrite(HttpServletRequest request, MultipartFile image1) {
		String filePath = request.getSession().getServletContext().getRealPath("/storage");
		String fileName = image1.getOriginalFilename();

		File file = new File(filePath, fileName);
		try {
			FileCopyUtils.copy(image1.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageBoardDTO dto = new ImageBoardDTO();
		dto.setImageId(request.getParameter("imageId"));
		dto.setImageName(request.getParameter("imageName"));
		dto.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		dto.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		dto.setImageContent(request.getParameter("imageContent"));
		dto.setImage1(fileName);

		ImageBoardDAO dao = new ImageBoardDAO();
		int result = dao.imageboardWrite(dto);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("imageboardWrite.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/ImageBoard/imageboardList.do")
	public ModelAndView imageboardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pg = Integer.parseInt(request.getParameter("pg"));
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}

		ImageBoardDAO dao = new ImageBoardDAO();
		
		int imgCnt = dao.getImgCnt();
		int pCnt = (imgCnt + 4) / 5;

		if (pg > pCnt) pg = pCnt;

		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<ImageBoardDTO> list = dao.imageboardList(startNum, endNum);

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > pCnt) endPage = pCnt;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("pCnt", pCnt);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);

		modelAndView.setViewName("imageboardList.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/ImageBoard/imageboardView.do")
	public ModelAndView imageboardView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		ImageBoardDAO dao = new ImageBoardDAO();
		
		ImageBoardDTO dto = dao.imageboardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardView.jsp");
		return modelAndView;

	}

	@RequestMapping(value="/ImageBoard/imageboardDelete.do")
	public ModelAndView imageboardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));	

		ImageBoardDAO dao = new ImageBoardDAO();
		int result = dao.imageDelete(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("imageboardDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/imageboard/imageboardModifyForm.do")
	public ModelAndView imageboardModifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ImageBoardDAO dao = new ImageBoardDAO();
		ImageBoardDTO dto = dao.imageboardView(seq);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);	
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardModifyForm.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/ImageBoard/imageboardModify.do")
	public ModelAndView imageboardModify(HttpServletRequest request, MultipartFile image1) {
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		String image_org = request.getParameter("image_org");
		
		String filePath = request.getSession().getServletContext().getRealPath("/storage");
		String fileName = image1.getOriginalFilename();
		
		if(fileName == null) fileName = image_org;

		File file = new File(filePath, fileName);
		try {
			FileCopyUtils.copy(image1.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageBoardDTO dto = new ImageBoardDTO();
		dto.setImageId(request.getParameter("imageId"));
		dto.setImageName(request.getParameter("imageName"));
		dto.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		dto.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		dto.setImageContent(request.getParameter("imageContent"));
		dto.setImage1(fileName);
		
		ImageBoardDAO dao = new ImageBoardDAO();
		int result = dao.modify(dto);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("seq", seq);
		modelAndView.setViewName("imageboardModify.jsp");
		return modelAndView;
	}
}
