package edu.hcmuaf.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.dto.MyUser;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.security.CustomSuccessHandler;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.ICategoryService;
import edu.hcmuaf.service.INewService;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.SecurityUtils;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private CustomSuccessHandler successHandler;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		String url = "web/home";
		ModelAndView mav = new ModelAndView(url);

		if (successHandler.isLogin() == true) { // login completed
			mav = successHandler.loadCart(url);
		}
		NewDTO newDTO = new NewDTO();
		newDTO.setListResult(newService.findAll());

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setListResult(categoryService.findAllCategory());

		mav.addObject("news", newDTO);
		mav.addObject("categories", categoryDTO.getListResult());

		return mav;
	}

}
