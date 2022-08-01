package edu.hcmuaf.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.IUserService;

@RestController(value = "registerAPIOfLogin")
public class RegisterAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/register")
	public UserDTO registerAccount(@RequestBody UserDTO userDTO) {
		return userService.saveRegister(userDTO);
	}
}
