package edu.hcmuaf.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.service.ICategoryService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/quan-tri/the-loai/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		CategoryDTO model = new CategoryDTO();
		model.setListResult(categoryService.findAllCategory());
		ModelAndView mav = new ModelAndView("admin/category/list");
		if (request.getParameter("message") != null) {
			Map<String, String> map = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/the-loai/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		CategoryDTO model = new CategoryDTO();
		if (id != null) {
			model = categoryService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> map =  messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		
		mav.addObject("model", model);
		return mav;
	}

}
