package edu.hcmuaf.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.MessageUtil;
import edu.hcmuaf.util.SecurityUtils;

@Controller(value="profileControllerOfWeb")
public class ProfileController {
	@Autowired
	private IUserService userService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/ho-so", method = RequestMethod.GET)
	public ModelAndView editProfile(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		String url = "/web/profile";
		ModelAndView mav = new ModelAndView(url);
		UserDTO model = new UserDTO();
		if(id !=null) {
			model = userService.findById(id);
		}else {
			model = userService.findByUsername(SecurityUtils.getPrincipal().getUsername());
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
