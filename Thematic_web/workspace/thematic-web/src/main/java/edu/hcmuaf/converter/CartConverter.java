package edu.hcmuaf.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.entity.CartEntity;
import edu.hcmuaf.entity.NewEntity;

@Component
public class CartConverter {
	@Autowired
	private NewConverter newConverter;
	
	public CartDTO toDTO(CartEntity cartEntity) {
		CartDTO result = new CartDTO();
		result.setId(cartEntity.getId());
		result.setUserId(cartEntity.getUser().getId());
		result.setUserName(cartEntity.getUser().getUserName());
		result.setTotal(cartEntity.getNews().size());
		List<NewDTO> listDTO = new ArrayList<NewDTO>();
		for(NewEntity item: cartEntity.getNews()) {
			listDTO.add(newConverter.toDTO(item));
		}
		result.setListNews(listDTO);
		return result;
	} 
	
	public CartEntity toEntity(CartDTO cartDTO) {
		CartEntity result = new CartEntity();
		result.setTotal(cartDTO.getTotal());
		List<NewEntity> entities = new ArrayList<>();
		for(NewDTO item: cartDTO.getListNews()) {
			entities.add(newConverter.toEntity(item));
		}
		result.setNews(entities);
		return result;
	}

	public CartEntity toEntity(CartEntity result, CartDTO cartDTO) {
		result.setTotal(cartDTO.getTotal());
		List<NewEntity> entities = new ArrayList<>();
		for(NewDTO item: cartDTO.getListNews()) {
			entities.add(newConverter.toEntity(item));
		}
		result.setNews(entities);
		return result;
	}
}
