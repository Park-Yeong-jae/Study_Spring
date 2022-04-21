package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageBoardDTO;

@Controller
public class ImageboardController {
	// Write Form
	@RequestMapping(value = "/imageboard/imageboardWiteForm", method = RequestMethod.GET)
	public String imageboardWriteForm() {
		return "/imageboard/imageboardWriteForm.jsp";
	}
	// Write
	@RequestMapping(value = "/imageboard/imageboardWrite")
	public ModelAndView imagevoardWrite(HttpServletRequest request, MultipartFile image1) {		
		// 1. 데이터 처리		
		// filePath = D:\aa_ycs\java_ycs\spring\workspace\.metadata\.plugins\
		//            org.eclipse.wst.server.core\tmp0\wtpwebapps\step19\storage
		String filePath = request.getSession().getServletContext().getRealPath("/storage");
		String fileName = image1.getOriginalFilename();
		
		System.out.println("filePath = " + filePath);
		System.out.println("fileName = " + fileName);
		
		// 이클립스가 관리하는 폴더에 파일 저장하기
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
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("/imageboard/imageboardWrite.jsp");
		return modelAndView;
	}
}






