package edu.hcmuaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hcmuaf.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	RoleEntity findOneByCode(String s);


//	List<UserEntity> findAllUsersByRole(RoleEntity roleEntity);
	
}
