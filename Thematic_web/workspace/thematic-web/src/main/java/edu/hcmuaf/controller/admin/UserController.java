package edu.hcmuaf.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.IRoleService;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		UserDTO model = new UserDTO();
		model.setListResult(userService.findAll());
//		Map<String, String> roles = userService.toMap(model.getListRole());
		ModelAndView mav = new ModelAndView("admin/user/list");
		if (request.getParameter("message") != null) {
			Map<String, String> map = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
//		mav.addObject("roles", roles);
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		UserDTO model = new UserDTO();
		if (id != null) {
			model = userService.findById(id);
		}
		ModelAndView mav = new ModelAndView("admin/user/edit");
		if (request.getParameter("message") != null) {
			Map<String, String> map =  messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
//		Map<String, String> roles = roleService.toMap(model.getListRole());
		List<RoleDTO> listDTO = roleService.findAll();
		List<String> roles = roleService.toStringList(listDTO);
//		Map<String, String> roles = roleService.toMap(roleService.findAll());
		mav.addObject("roles", roles);
		mav.addObject("model", model);
		return mav;
	}
	
}
