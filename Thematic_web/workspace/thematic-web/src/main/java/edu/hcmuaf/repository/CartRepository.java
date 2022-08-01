package edu.hcmuaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hcmuaf.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

}
