package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.converter.CategoryConverter;
import edu.hcmuaf.converter.NewConverter;
import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.entity.CategoryEntity;
import edu.hcmuaf.entity.NewEntity;
import edu.hcmuaf.repository.CategoryRepository;
import edu.hcmuaf.repository.NewRepository;
import edu.hcmuaf.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter; 
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private NewConverter newConverter;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}


	@Override
	public List<CategoryDTO> findAllCategory() {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> entities =categoryRepository.findAll();
		for(CategoryEntity item: entities) {
			CategoryDTO categoryDTO = categoryConverter.toDTO(item);
			result.add(categoryDTO);
		}
		return result;
	}


	@Override
	@Transactional
	public void delete(long[] ids) {
		if(ids.length == 0 || ids == null) {
			System.out.println("Empty!!!");
		}
		for(long id: ids) {
			System.out.println("delete obj by id: " + id);
			CategoryEntity categoryEntity = categoryRepository.findOne(id);
			if(categoryEntity != null) {
				List<NewEntity> listEntity = newRepository.findAllByCategory(categoryEntity);
				for(NewEntity item: listEntity) {
					newRepository.delete(item);
				}
			}
			categoryRepository.delete(id);
		}
	}


	@Override
	public CategoryDTO findById(Long id) {
		return categoryConverter.toDTO(categoryRepository.findOne(id));
	}


	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if(categoryDTO.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(categoryDTO.getId());
			if(oldCategory.getNews() != null || oldCategory.getNews().size() != 0) {
				categoryEntity.setNews(newRepository.findAllByCategory(oldCategory));
			}
			categoryEntity = categoryConverter.toEntity(oldCategory, categoryDTO);
		}else {
			categoryEntity = categoryConverter.toEntity(categoryDTO);
		}
		
		return categoryConverter.toDTO(categoryRepository.save(categoryEntity));
	}


	@Override
	public CategoryDTO findOneByCode(String code) {
		return categoryConverter.toDTO(categoryRepository.findOneByCode(code));
	}
	
	
	
	

}
