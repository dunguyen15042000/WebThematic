package edu.hcmuaf.service;

import java.util.List;
import java.util.Map;

import edu.hcmuaf.dto.CategoryDTO;

public interface ICategoryService {
	Map<String, String> findAll();
	List<CategoryDTO> findAllCategory();
	public void delete(long[] ids);
	CategoryDTO findById(Long id);
	CategoryDTO save(CategoryDTO categoryDTO);
	CategoryDTO findOneByCode(String code);
}
