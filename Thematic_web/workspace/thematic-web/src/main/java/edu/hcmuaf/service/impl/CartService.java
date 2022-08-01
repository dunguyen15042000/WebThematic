package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hcmuaf.converter.CartConverter;
import edu.hcmuaf.converter.NewConverter;
import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.entity.CartEntity;
import edu.hcmuaf.entity.NewEntity;
import edu.hcmuaf.entity.UserEntity;
import edu.hcmuaf.repository.CartRepository;
import edu.hcmuaf.repository.NewRepository;
import edu.hcmuaf.repository.UserRepository;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.util.SecurityUtils;

@Service
public class CartService implements ICartService{
	@Autowired
	private CartConverter cartConverter;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private NewConverter newConverter;
	
	@Override
	@Transactional
	public void delete(long[] ids) {
		if(ids.length == 0 || ids == null) {
			System.out.println("Empty!!!");
		}else {
			UserEntity userEntity = userRepository.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), 1);
			CartEntity cartEntity = cartRepository.findOne(userEntity.getCart().getId());
			for(long id: ids) {
				for(NewEntity item: cartEntity.getNews()) {
					if(item.getId().equals(id)) {
						cartEntity.getNews().remove(item);
						break;
					}
				}
			}
			for(NewEntity item: cartEntity.getNews()) {
				if(cartEntity.getNews().size() == 0) {
					System.out.println("size = 0");
				}else {
					System.out.println("title: " +item.getTitle());
				}
			}
			cartRepository.save(cartEntity);
		}
	}
	
	@Override
	public CartDTO findById(Long id) {
		return cartConverter.toDTO(cartRepository.findOne(id));
	}
	
	@Override
	@Transactional
	public CartDTO save(NewDTO newDTO) {
		UserEntity user = userRepository.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), 1);
		CartEntity cartEntity = user.getCart();
		List<NewEntity> listEntities = cartEntity.getNews();
		
		NewEntity newEntity = newRepository.findOne(newDTO.getId());
		if(listEntities.contains(newEntity)) {
			//nothing
		}else {
			listEntities.add(newEntity);
		}
		cartEntity.setNews(listEntities);
		user.setCart(cartEntity);
		userRepository.save(user);
		cartRepository.save(cartEntity);
		return cartConverter.toDTO(cartEntity);
	}
	
	@Override
	public List<NewDTO> findAllNewsById(Long cartID) {
		List<NewDTO> result = new ArrayList<>();
		List<NewEntity> entities = (cartRepository.findOne(cartID)).getNews();
		for(NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			result.add(newDTO);
		}
		return result;
	}
	
	@Override
	@Transactional
	public CartDTO createCartByUser(UserDTO userDTO) {
		UserEntity userEntity = userRepository.findOne(userDTO.getId());
		CartEntity cartEntity = new CartEntity();
		cartEntity.setUser(userEntity);
		cartEntity.setTotal(cartEntity.getNews().size());
		cartRepository.save(cartEntity);
		//save user after update cart into db
		userEntity.setCart(cartEntity);
		userRepository.save(userEntity);
		
		return cartConverter.toDTO(cartEntity);
	}

	@Override
	public List<CartDTO> findAll() {
		List<CartDTO> result = new ArrayList<>();
		List<CartEntity> entities = cartRepository.findAll();
		for(CartEntity item: entities) {
			result.add(cartConverter.toDTO(item));
		}
		return result;
	}
	
	
	
}
