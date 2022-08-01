package edu.hcmuaf.service;

import java.util.List;

import edu.hcmuaf.dto.CommentDTO;

public interface ICommentService {
	CommentDTO findById(Long id);
	CommentDTO save(CommentDTO commentDTO);
	void delete(long[] ids);
	List<CommentDTO> findAllComment();
	List<CommentDTO> findAllByNewsId(Long id);
}
