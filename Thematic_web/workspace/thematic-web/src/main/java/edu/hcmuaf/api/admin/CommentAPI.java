package edu.hcmuaf.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.CategoryDTO;
import edu.hcmuaf.dto.CommentDTO;
import edu.hcmuaf.service.ICommentService;

@RestController(value ="commentAPIOfAdmin")
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/api/comment")
	public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
		return commentService.save(commentDTO);
	}
	
	@PutMapping("/api/comment")
	public CommentDTO updateComment(@RequestBody CommentDTO commentDTO) {
		return commentService.save(commentDTO);
	}
	
	@DeleteMapping("/api/comment")
	public void deleteComment(@RequestBody long[] ids) {
		for(long id: ids) {
			System.out.println("id: " + id);
		}
		commentService.delete(ids);
		
	}
	
}
