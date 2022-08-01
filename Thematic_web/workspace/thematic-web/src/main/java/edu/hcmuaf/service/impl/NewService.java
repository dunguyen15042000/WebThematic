package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.converter.CategoryConverter;
import edu.hcmuaf.converter.NewConverter;
import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.entity.CategoryEntity;
import edu.hcmuaf.entity.NewEntity;
import edu.hcmuaf.repository.CategoryRepository;
import edu.hcmuaf.repository.NewRepository;
import edu.hcmuaf.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private NewConverter newConverter;
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> models = new ArrayList<>(); 
		List<NewEntity> entities = newRepository.findAll();
		for(NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity newEntity = newRepository.findOne(id);
		return newConverter.toDTO(newEntity);
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		if(newDTO.getId() != null) {
			NewEntity oldNews = newRepository.findOne(newDTO.getId());
			oldNews.setCategory(categoryEntity);
			newEntity = newConverter.toEntity(oldNews, newDTO);
		}else {
			newEntity = newConverter.toEntity(newDTO);
			newEntity.setCategory(categoryEntity);
		}
		return newConverter.toDTO(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id: ids) {
			newRepository.delete(id);
		}
	}

	@Override
	public List<String> setCategoryNameForListResult(List<NewDTO> listResult) {
		List<String> result = new ArrayList<>();
		for(NewDTO item: listResult) {
			result.add(categoryRepository.findOne(item.getCategoryId()).getName());
		}
		return result;
	}

	@Override
	public List<NewDTO> findAllByCategoryCode(String categoryCode) {
		List<NewDTO> result = new ArrayList<>();
		List<NewEntity> list = newRepository.findAllByCategory(categoryRepository.findOneByCode(categoryCode));
		for(NewEntity item: list) {
			result.add(newConverter.toDTO(item));
		}
		return result;
	}



}
