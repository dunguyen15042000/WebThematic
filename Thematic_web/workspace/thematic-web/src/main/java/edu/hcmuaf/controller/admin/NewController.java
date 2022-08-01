package edu.hcmuaf.controller.admin;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.service.ICategoryService;
import edu.hcmuaf.service.INewService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	@Autowired
	ServletContext servletContext;
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		NewDTO newDTO = new NewDTO();
		ModelAndView mav = new ModelAndView("admin/new/list");
		newDTO.setListResult(newService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> map = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("model", newDTO);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id ,HttpServletRequest request) {
		NewDTO model = new NewDTO();
		
		if (id != null) {
			model = newService.findById(id);
		}
		
		
		ModelAndView mav = new ModelAndView("admin/new/edit");
		if (request.getParameter("message") != null) {
			Map<String, String> map =  messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message")); 
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	
}
