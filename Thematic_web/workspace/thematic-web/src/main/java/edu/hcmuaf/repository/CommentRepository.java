package edu.hcmuaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hcmuaf.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
	List<CommentEntity> findAllByNewsId(Long id);
	
}
