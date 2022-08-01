package edu.hcmuaf.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.IUserService;

@RestController(value = "userAPIOfWeb")
public class ProfileAPI {
	@Autowired
	private IUserService userService;
	
	@PutMapping("/api/web/user")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		return userService.update(userDTO);
	}
}
