package edu.hcmuaf.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll();
	int getTotalItem();
	NewDTO findById(long id);
//	NewDTO insert(NewDTO newDTO);
//	NewDTO update(NewDTO newDTO);
	NewDTO save(NewDTO newDTO);
	void delete(long[] ids);
	List<String> setCategoryNameForListResult(List<NewDTO> listResult);
	List<NewDTO> findAllByCategoryCode(String categoryCode);
}
