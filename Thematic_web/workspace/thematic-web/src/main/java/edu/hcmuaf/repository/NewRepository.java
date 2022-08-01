package edu.hcmuaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hcmuaf.entity.CategoryEntity;
import edu.hcmuaf.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	public List<NewEntity> findAllByCategory(CategoryEntity categoryEntity);
}
