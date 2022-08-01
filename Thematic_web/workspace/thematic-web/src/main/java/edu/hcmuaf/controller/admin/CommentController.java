package edu.hcmuaf.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CommentDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.service.ICommentService;
import edu.hcmuaf.service.INewService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value = "commentControllerOfAdmin")
public class CommentController {
	@Autowired
	private ICommentService commentService;
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private INewService newService;
	
	@RequestMapping(value = "/quan-tri/binh-luan/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/comment/list");
		CommentDTO model = new CommentDTO();
	
		//code more
		model.setListResult(commentService.findAllComment());
		if (request.getParameter("message") != null) {
			Map<String, String> map = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/binh-luan/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editComment(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/comment/edit");
		CommentDTO model = new CommentDTO();
		if (id != null) {
			model = commentService.findById(id);
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
