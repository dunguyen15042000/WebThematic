package edu.hcmuaf.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.entity.NewEntity;
import edu.hcmuaf.service.INewService;

@Component
public class NewConverter {
	@Autowired
	private INewService newService;
	
	public NewDTO toDTO(NewEntity newEntity) {
		NewDTO result = new NewDTO();
		result.setId(newEntity.getId());
		result.setTitle(newEntity.getTitle());
		result.setThumbnail(newEntity.getThumbnail());
		result.setContent(newEntity.getContent());
		result.setShortDescription(newEntity.getShortDescription());
		result.setCategoryCode(newEntity.getCategory().getCode());
		result.setCreatedDate(newEntity.getCreatedDate());
		result.setCreatedBy(newEntity.getCreatedBy());
		result.setStatus(newEntity.getStatus());
		return result;
	}
	
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity result = new NewEntity();
		result.setTitle(newDTO.getTitle());
		result.setThumbnail(newDTO.getThumbnail());
		result.setContent(newDTO.getContent());
		result.setShortDescription(newDTO.getShortDescription());
		result.setStatus(newDTO.getStatus());
		return result;
	}
	
	public NewEntity toEntity(NewEntity result, NewDTO newDTO) {
		result.setTitle(newDTO.getTitle());
		result.setThumbnail(newDTO.getThumbnail());
		result.setContent(newDTO.getContent());
		result.setShortDescription(newDTO.getShortDescription());
		result.setStatus(newDTO.getStatus());
		return result;
	}
}
