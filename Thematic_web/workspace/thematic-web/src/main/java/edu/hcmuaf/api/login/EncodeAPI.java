package edu.hcmuaf.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.util.MD5Utils;

@RestController(value = "encodeAPIOfLogin")
public class EncodeAPI {
	@Autowired
	private MD5Utils md5Utils;
	
	@PostMapping("/api/encode")
	public UserDTO registerAccount(@RequestBody UserDTO userDTO) {
		UserDTO result = new UserDTO();
		result.setPassword(md5Utils.encode(userDTO.getPassword()));
		return result;
	}
}
