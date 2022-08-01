package edu.hcmuaf.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.SecurityUtils;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request) {
		CartDTO cartDTO = new CartDTO();
		ModelAndView mav = new ModelAndView("web/cart2");
		String username = SecurityUtils.getPrincipal().getUsername();
		UserDTO userDTO = userService.findByUsername(username);
		cartDTO.setListNews(cartService.findAllNewsById(userDTO.getCartId()));
		mav.addObject("cart", cartDTO);
		return mav;
	}
	
}
