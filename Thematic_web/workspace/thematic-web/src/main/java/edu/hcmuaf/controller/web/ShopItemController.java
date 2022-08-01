package edu.hcmuaf.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.dto.CommentDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.security.CustomSuccessHandler;
import edu.hcmuaf.service.ICategoryService;
import edu.hcmuaf.service.INewService;
import edu.hcmuaf.service.impl.CommentService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value="shopItemControllerOfWeb")
public class ShopItemController {
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private CustomSuccessHandler successHandler;
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value = "/bai-viet", method = RequestMethod.GET)
	public ModelAndView newsOfHomePage(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		String url = "web/shop-item";
		ModelAndView mav = new ModelAndView(url);
		if (successHandler.isLogin() == true) { // login completed
			mav = successHandler.loadCart(url);
		}
		NewDTO newDTO = new NewDTO();
		newDTO = newService.findById(id);
		List<NewDTO> list = newService.findAllByCategoryCode(newDTO.getCategoryCode());	//all news same categoryCode with "newDTO"
		newDTO.setListResult(list);	
		newDTO.getListResult().remove(newDTO);
		mav.addObject("news", newDTO);
		
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setListResult(commentService.findAllByNewsId(id));
		mav.addObject("comments", commentDTO);
		mav.addObject("commentSize", commentDTO.getListResult().size());
		return mav;
	}
	
	

}
