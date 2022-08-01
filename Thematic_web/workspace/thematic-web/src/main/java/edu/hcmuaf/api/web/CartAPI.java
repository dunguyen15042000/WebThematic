package edu.hcmuaf.api.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.INewService;

@RestController(value ="cartAPIOfWeb")
public class CartAPI {
	@Autowired
	private ICartService cartService;
	@Autowired
	private INewService newService;
	
	
	@PostMapping("/api/web/cart")
	public CartDTO createItemIntoCart(@RequestBody NewDTO newDTO) {
		NewDTO news = newService.findById(newDTO.getId());
		CartDTO cartDTO = cartService.save(news);
		cartDTO.setTotal(cartDTO.getListNews().size());
		return cartDTO;
	}
	
//	@PutMapping("/api/cart")
//	public CartDTO updateCart(@RequestBody NewDTO newDTO) {
//		return cartService.save(newDTO);
//	}
	
	@DeleteMapping("/api/web/cart")
	public void deleteItemCart(@RequestBody long[] ids) {		//ids: list id of product
		for(long i: ids) {
			System.out.println(i);
		}
		cartService.delete(ids);
		
	}
}
