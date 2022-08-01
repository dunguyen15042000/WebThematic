package edu.hcmuaf.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "registerController")
public class RegisterController {
	@Autowired
	private IUserService userService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/dang-nhap/dang-ky", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		UserDTO model = new UserDTO();
		ModelAndView mav = new ModelAndView("login/register");
		if (request.getParameter("message") != null) {
			Map<String, String> map =  messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
//		Map<String, String> roles = roleService.toMap(model.getListRole());
		mav.addObject("model", model);
		return mav;
	}
}
