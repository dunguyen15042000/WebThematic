package edu.hcmuaf.controller.admin.other;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "blankControllerOfAdmin")
public class BlankController {
	
	
	@RequestMapping(value = "/quan-tri/blank-page", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/blankpage");
		return mav;
	}
}
