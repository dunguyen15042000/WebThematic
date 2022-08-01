package edu.hcmuaf.service;

import java.util.List;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.dto.UserDTO;

public interface ICartService {
	CartDTO save(NewDTO newDTO);
	
	public void delete(long[] ids);
	CartDTO findById(Long id);

	List<NewDTO> findAllNewsById(Long id);

	CartDTO createCartByUser(UserDTO userDTO);

	List<CartDTO> findAll();
	


}
