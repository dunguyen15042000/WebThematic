package edu.hcmuaf.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hcmuaf.converter.UserConverter;
import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.entity.NewEntity;
import edu.hcmuaf.entity.UserEntity;
import edu.hcmuaf.repository.UserRepository;

@Component
public class CartUtil {
	@Autowired
	private UserRepository userRepository;
	
//	public int countItemCart(List<NewEntity> listEntities) {
//		int count = 0;
//		for(NewEntity item: listEntities) {
//			count += item.getQuantity();
//		}
//		return count;
//	}
}
