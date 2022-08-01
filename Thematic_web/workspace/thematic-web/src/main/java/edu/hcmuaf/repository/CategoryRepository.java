package edu.hcmuaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hcmuaf.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	public CategoryEntity findOneByCode(String code);
}
