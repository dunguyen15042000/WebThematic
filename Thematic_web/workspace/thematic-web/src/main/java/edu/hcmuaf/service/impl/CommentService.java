package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hcmuaf.converter.CommentConverter;
import edu.hcmuaf.dto.CommentDTO;
import edu.hcmuaf.entity.CommentEntity;
import edu.hcmuaf.repository.CategoryRepository;
import edu.hcmuaf.repository.CommentRepository;
import edu.hcmuaf.repository.NewRepository;
import edu.hcmuaf.repository.UserRepository;
import edu.hcmuaf.service.ICommentService;
import edu.hcmuaf.util.SecurityUtils;

@Service
public class CommentService implements ICommentService{
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private CommentConverter commentConverter;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NewRepository newRepository; 
	
	@Override
	public CommentDTO findById(Long id) {
		return commentConverter.toDTO(commentRepository.findOne(id));
	}

	@Override
	public CommentDTO save(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();
		commentEntity = commentConverter.toEntity(commentDTO);
		commentEntity.setNews(newRepository.findOne(commentDTO.getNewId()));
		commentEntity.setUser(userRepository.findOneByUserNameAndStatus(SecurityUtils.getPrincipal().getUsername(), 1));
		
		return commentConverter.toDTO(commentRepository.save(commentEntity));
	}
	
	@Override
	public List<CommentDTO> findAllComment() {
		List<CommentDTO> result = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll();
		for(CommentEntity item: entities) {
			result.add(commentConverter.toDTO(item));
		}
		return result;
	}

	@Override
	public void delete(long[] ids) {
		if(ids.length == 0 || ids == null) {
			System.out.println("Empty!!!");
		}
		for(long id: ids) {
			System.out.println("delete obj by id: " + id);
			commentRepository.delete(id);
		}
		
		 
	}

	@Override
	public List<CommentDTO> findAllByNewsId(Long id) {
		List<CommentDTO> result = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAllByNewsId(id);
		for(CommentEntity item: entities) {
			result.add(commentConverter.toDTO(item));
		}
		return result;
	}


	
	
}
