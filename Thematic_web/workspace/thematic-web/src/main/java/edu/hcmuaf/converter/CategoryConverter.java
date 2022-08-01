package edu.hcmuaf.converter;

import org.springframework.stereotype.Component;

import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDTO(CategoryEntity categoryEntity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(categoryEntity.getId());
		result.setName(categoryEntity.getName());
		result.setCode(categoryEntity.getCode());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity result = new CategoryEntity();
		result.setCode(categoryDTO.getCode());
		result.setName(categoryDTO.getName());
		return result;
	}

	public CategoryEntity toEntity(CategoryEntity result, CategoryDTO categoryDTO) {
		result.setCode(categoryDTO.getCode());
		result.setName(categoryDTO.getName());
		return result;
	}
}
