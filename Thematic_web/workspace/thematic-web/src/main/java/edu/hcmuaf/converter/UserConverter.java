package edu.hcmuaf.converter;

import org.springframework.stereotype.Component;

import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.entity.UserEntity;

@Component
public class UserConverter {
	
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO result = new UserDTO();
		result.setId(userEntity.getId());
		result.setUsername(userEntity.getUserName());
		result.setPassword(userEntity.getPassword());
		result.setFullName(userEntity.getFullName());
		result.setStatus(userEntity.getStatus());
		result.setEmail(userEntity.getEmail());
		result.setSex(userEntity.getSex());
		result.setCreatedDate(userEntity.getCreatedDate());
		if(userEntity.getCart() != null) {
			result.setCartId(userEntity.getCart().getId());
		}
		return result;
	}
	
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity result = new UserEntity();
		result.setUserName(userDTO.getUsername());
		result.setPassword(userDTO.getPassword());
		result.setFullName(userDTO.getFullName());
		result.setStatus(userDTO.getStatus());
		result.setEmail(userDTO.getEmail());
		result.setSex(userDTO.getSex());
		return result;
	}

	public UserEntity toEntity(UserEntity result, UserDTO userDTO) {
		result.setUserName(userDTO.getUsername());
		result.setPassword(userDTO.getPassword());
		result.setFullName(userDTO.getFullName());
		result.setStatus(userDTO.getStatus());
		result.setEmail(userDTO.getEmail());
		result.setSex(userDTO.getSex());
		return result;
	}
}
