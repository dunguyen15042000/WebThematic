package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.converter.RoleConverter;
import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.entity.RoleEntity;
import edu.hcmuaf.entity.UserEntity;
import edu.hcmuaf.repository.RoleRepository;
import edu.hcmuaf.repository.UserRepository;
import edu.hcmuaf.service.IRoleService;

@Service
public class RoleService implements IRoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleConverter roleConverter;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Map<String, String> findAllRole() {
		Map<String, String> result = new HashMap<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for(RoleEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		
		return result;
	}
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleEntity> entities = roleRepository.findAll();
		List<RoleDTO> result = new ArrayList<>();
		for(RoleEntity item: entities) {
			RoleDTO roleDTO = roleConverter.toDTO(item);
			result.add(roleDTO);
		}
		return result;
	}

	@Override
	public RoleDTO findById(Long id) {
		return roleConverter.toDTO(roleRepository.findOne(id));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id: ids) {
			RoleEntity roleEntity = roleRepository.findOne(id);
			List<UserEntity> userEntity = roleEntity.getUsers();
			System.out.println("Accessing...");
			if(userEntity.size() != 0) {
				for(UserEntity item: userEntity) {
					for(RoleEntity role: item.getRoles()) {
						if(role.getId() == id) {
							roleRepository.delete(id);
						}else {
							System.out.println("Can't duplicate with this ID!!");
						}
					}
				}
			}
		}
	}

	@Override
	@Transactional
	public RoleDTO save(RoleDTO roleDTO) {
		RoleEntity roleEntity = new RoleEntity();
		if(roleDTO.getId() != null) {
			RoleEntity oldRole = roleRepository.findOne(roleDTO.getId());
			if(oldRole.getUsers() != null || oldRole.getUsers().size() != 0) {
				roleEntity.setUsers(oldRole.getUsers());
			}
			roleEntity = roleConverter.toEntity(oldRole, roleDTO);
		}else {
			roleEntity = roleConverter.toEntity(roleDTO);
		}
		
		return roleConverter.toDTO(roleRepository.save(roleEntity));
	}

	@Override
	public Map<String, String> toMap(List<RoleDTO> listRole) {
		Map<String, String> result = new HashMap<>();
		for(RoleDTO item: listRole) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

	@Override
	public List<String> toStringList(List<RoleDTO> listDTO) {
		return roleConverter.toStringList(listDTO);
	}


	

}
