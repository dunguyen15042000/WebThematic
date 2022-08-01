package edu.hcmuaf.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.CommentDTO;
import edu.hcmuaf.service.ICommentService;

@RestController(value = "commentAPIOfWeb")
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/api/web/comment")
	public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
		return commentService.save(commentDTO);
	}
}
