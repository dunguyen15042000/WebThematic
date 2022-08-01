package edu.hcmuaf.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Utils {
	
	public String encode(String input) {
		String md5Hex = DigestUtils.md5Hex(input).toUpperCase();
		return md5Hex;
	}
	
	
	public static void main(String[] args) {
		MD5Utils ex = new MD5Utils();
		System.out.println(ex.encode("123456"));
		
		// result = E10ADC3949BA59ABBE56E057F20F883E
	}
}
