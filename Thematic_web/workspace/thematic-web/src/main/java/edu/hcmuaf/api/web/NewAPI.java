package edu.hcmuaf.api.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.util.CartUtil;

@RestController(value = "newAPIOfWeb")
public class NewAPI {
	@Autowired
	private CartUtil cartUtil;
	
//	@PostMapping("/api/cart")
//	public Integer addToCart(@RequestBody CartDTO params, HttpSession session) {
//		Map<Long, CartDTO> cart  = (Map<Long, CartDTO>) session.getAttribute("cart");
//		if(cart == null) {
//			cart = new HashMap<>();
//			
//		}
//		if(cart.containsKey(params.getId()) == true) {	//contain news in cart
//			CartDTO cartDTO = cart.get(params.getId());
//			cartDTO.setTotal(cartDTO.getTotal()+1);
//		}else { 
//			cart.put(params.getId(), params);
//		}
//		session.setAttribute("cart", cart);
//		return cartUtil.countCart(cart);
//	}
}
