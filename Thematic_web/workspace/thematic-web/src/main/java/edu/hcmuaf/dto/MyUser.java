package edu.hcmuaf.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class MyUser extends User{
	private static final long serialVersionUID = 1L;
	
	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	private String fullName;
//	private int countQuantityItem;

	//getter and setter
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getFullName() {
		return fullName;
	}

//	public int getCountQuantityItem() {
//		return countQuantityItem;
//	}
//
//	public void setCountQuantityItem(int countQuantityItem) {
//		this.countQuantityItem = countQuantityItem;
//	}
}
