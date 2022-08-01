package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.hcmuaf.constant.SystemConstant;
import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.MyUser;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.entity.RoleEntity;
import edu.hcmuaf.entity.UserEntity;
import edu.hcmuaf.repository.CartRepository;
import edu.hcmuaf.repository.UserRepository;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.SecurityUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICartService cartService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		
		UserDTO userDTO = userService.findByUsername(myUser.getUsername());
		if(userDTO.getCartId() == null) {
			cartService.createCartByUser(userDTO);
		}
		
		return myUser;
	}

}
