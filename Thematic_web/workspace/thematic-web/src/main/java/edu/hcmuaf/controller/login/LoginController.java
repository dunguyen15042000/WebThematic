package edu.hcmuaf.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "loginController")
public class LoginController {
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		UserDTO model = new UserDTO();
		if (id != null) {
			model = userService.findById(id);
		}
		ModelAndView mav = new ModelAndView("login/login");
		if (request.getParameter("message") != null) {
			Map<String, String> map = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	
	

}
