package edu.hcmuaf.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.security.CustomSuccessHandler;
import edu.hcmuaf.service.ICategoryService;
import edu.hcmuaf.service.INewService;
import edu.hcmuaf.util.MessageUtil;

@Controller(value="shopCategoryControllerOfWeb")
public class ShopCategoryController {
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private CustomSuccessHandler successHandler;
	
	@RequestMapping(value = "/the-loai", method = RequestMethod.GET)
	public ModelAndView categoryOfHomePage(@RequestParam(value = "categoryCode", required = false) String code, HttpServletRequest request) {
		String url = "web/shop-category";
		ModelAndView mav = new ModelAndView(url);
		if (successHandler.isLogin() == true) { // login completed
			mav = successHandler.loadCart(url);
		}
		NewDTO newDTO = new NewDTO();
		newDTO.setListResult(newService.findAllByCategoryCode(code));	
		newDTO.getListResult().remove(newDTO);
		CategoryDTO categoryDTO = categoryService.findOneByCode(code);
		
		
		mav.addObject("news", newDTO);
		mav.addObject("category", categoryDTO);
		return mav;
	}
}
