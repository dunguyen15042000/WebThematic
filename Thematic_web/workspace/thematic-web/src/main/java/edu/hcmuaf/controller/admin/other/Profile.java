package edu.hcmuaf.controller.admin.other;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "profileControllerOfAdmin")
public class Profile {
	

	@RequestMapping(value = "/quan-tri/ho-so", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/profile");
		return mav;
	}
}
