package edu.hcmuaf.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.ICategoryService;

@RestController(value ="cartAPIOfAdmin")
public class CartAPI {
	@Autowired
	private ICartService cartService;
	
//	@PostMapping("/api/cart")
//	public CartDTO createCart(@RequestBody CartDTO cartDTO) {
//		return cartService.save(cartDTO);
//	}
//	
//	@PutMapping("/api/cart")
//	public CartDTO updateCart(@RequestBody CartDTO cartDTO) {
//		return cartService.save(cartDTO);
//	}
//	
//	@DeleteMapping("/api/cart")
//	public void deleteCart(@RequestBody long[] ids) {
//		cartService.delete(ids);
//		
//	}
}
