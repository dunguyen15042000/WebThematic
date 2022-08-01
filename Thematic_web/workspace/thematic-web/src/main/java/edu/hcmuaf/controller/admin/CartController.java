package edu.hcmuaf.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.IUserService;

@Controller(value="cartControllerOfAdmin")
public class CartController {
	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value = "/quan-tri/gio-hang/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		String url = "admin/cart/list";
		ModelAndView mav = new ModelAndView(url);
		CartDTO cartDTO = new CartDTO();
		cartDTO.setListResult(cartService.findAll());
		mav.addObject("model", cartDTO);
		return mav;
	}
}
