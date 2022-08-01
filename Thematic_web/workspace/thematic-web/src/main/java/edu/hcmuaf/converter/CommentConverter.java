package edu.hcmuaf.converter;

import org.springframework.stereotype.Component;

import edu.hcmuaf.dto.CommentDTO;
import edu.hcmuaf.entity.CommentEntity;

@Component
public class CommentConverter {
	
	public CommentDTO toDTO(CommentEntity commentEntity) {
		CommentDTO result = new CommentDTO();
		result.setId(commentEntity.getId());
		result.setNewId(commentEntity.getNews().getId());
		result.setNewTitle(commentEntity.getNews().getTitle());
		result.setUserName(commentEntity.getUser().getUserName());
		result.setContent(commentEntity.getContent());
		result.setCreatedDate(commentEntity.getCreatedDate());
		result.setCreatedBy(commentEntity.getCreatedBy());
		return result;
	}
	
	public CommentEntity toEntity(CommentDTO commentDTO) {
		CommentEntity result = new CommentEntity();
		result.setContent(commentDTO.getContent());
		return result;
	}

	public CommentEntity toEntity(CommentEntity result, CommentDTO commentDTO) {
		result.setContent(commentDTO.getContent());
		return result;
	}
}
