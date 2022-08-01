package edu.hcmuaf.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.service.IRoleService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "roleControllerOfAdmin")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/quan-tri/vai-tro/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		RoleDTO model = new RoleDTO();
		model.setListResult(roleService.findAll());
		ModelAndView mav = new ModelAndView("admin/role/list");
		if (request.getParameter("message") != null) {
			Map<String, String> map = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/vai-tro/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/role/edit");
		RoleDTO model = new RoleDTO();
		if (id != null) {
			model = roleService.findById(id);
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
