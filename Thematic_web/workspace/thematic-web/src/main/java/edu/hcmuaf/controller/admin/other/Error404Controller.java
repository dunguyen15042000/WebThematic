package edu.hcmuaf.controller.admin.other;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "404ControllerOfAdmin")
public class Error404Controller {

	
	@RequestMapping(value = "/quan-tri/error-404", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/error-404");
		return mav;
	}
}
