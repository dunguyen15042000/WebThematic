package edu.hcmuaf.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller(value = "forgotPasswordController")
public class ForgotPasswordController {
	
	
	@RequestMapping(value = "/dang-nhap/quen-mat-khau", method = RequestMethod.GET)
	public ModelAndView forgotPassword() {
		ModelAndView mav = new ModelAndView("login/forgotPassword");
		return mav;
	}
}
