package edu.hcmuaf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hcmuaf.converter.RoleConverter;
import edu.hcmuaf.converter.UserConverter;
import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.entity.RoleEntity;
import edu.hcmuaf.entity.UserEntity;
import edu.hcmuaf.repository.RoleRepository;
import edu.hcmuaf.repository.UserRepository;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.MD5Utils;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private RoleConverter roleConverter;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private MD5Utils md5Utils;
	
	
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> result = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for(UserEntity item: entities) {
			List<RoleEntity> listRole = item.getRoles();
			List<RoleDTO> listDTO = new ArrayList<>();
			for(RoleEntity role: listRole) {
				RoleDTO roleDTO = roleConverter.toDTO(role);
				listDTO.add(roleDTO);
			}
			UserDTO userDTO = userConverter.toDTO(item);
			userDTO.setListRole(listDTO);
			result.add(userDTO);
		}
		
		return result;
	}
	
	@Override
	public UserDTO findById(Long id) {
		UserDTO result = new UserDTO();
		UserEntity userEntity = userRepository.findOne(id);
		result.setRoleCode(userEntity.getRoles().get(0).getCode());
		List<RoleDTO> listRole = new ArrayList<RoleDTO>();
		for(RoleEntity item: userEntity.getRoles()) {
			RoleDTO roleDTO = roleConverter.toDTO(item);
			listRole.add(roleDTO);
		}
		result.setListRole(listRole);
		result = userConverter.toDTO(userEntity);
		return result;
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO userDTO) {
		System.out.println("Role checked: "+userDTO.getRoleCode());		//get it
		UserEntity userEntity = new UserEntity();
		if ( userDTO.getId() != null ) {
			UserEntity oldUser = userRepository.findOne( userDTO.getId() );
			userEntity = userConverter.toEntity(oldUser, userDTO);
		} else {
			userEntity = userConverter.toEntity(userDTO);
		}
		List<RoleEntity> roles = new ArrayList<>();
		roles.add( roleRepository.findOneByCode( userDTO.getRoleCode() ) );
		userEntity.setRoles(roles);
		
		UserDTO result = new UserDTO();
		result.setRoleCode(userDTO.getRoleCode());
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		System.out.println("size: "+userEntity.getRoles().size());
		if(userEntity.getRoles().size() != 0) {
			for(RoleEntity item: userEntity.getRoles()) {
				RoleDTO roleDTO = roleConverter.toDTO(item);
				list.add(roleDTO);
			}
			result.setListRole(list);
		}
		result = userConverter.toDTO(userRepository.save(userEntity));
		return result;
	}
	

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id: ids) {
			UserEntity userEntity = userRepository.findOne(id);
			List<RoleEntity> roleEntity = userEntity.getRoles();
			if(roleEntity.size() != 0) {
				for(RoleEntity item: roleEntity) {
					for(UserEntity user: item.getUsers()) {
						if(user.getId() == id) {
//							userRepository.delete(id);
							UserEntity entity = userRepository.findOne(id);
							UserDTO userDTO = userConverter.toDTO(entity);
							userDTO.setStatus(2);
							saveStatus(userDTO);
							break;
						}else {
							System.out.println("Can't duplicate with this ID!!");
						}
					}
					break;
				}
			}
		}		
	}

	@Override
	@Transactional
	public UserDTO saveStatus(UserDTO userDTO) {
		System.out.println("Role checked: "+userDTO.getRoleCode());		//get it
		UserEntity userEntity = new UserEntity();
		if ( userDTO.getId() != null ) {
			UserEntity oldUser = userRepository.findOne( userDTO.getId() );
			userEntity = userConverter.toEntity(oldUser, userDTO);
			userEntity.setRoles(oldUser.getRoles());
		} else {
			userEntity = userConverter.toEntity(userDTO);
			String roleCode = userDTO.getRoleCode();
			RoleEntity roleEntity = roleRepository.findOneByCode(roleCode);
			List<RoleEntity> roles  = new ArrayList<>();
			roles.add(roleEntity);
			userEntity.setRoles(roles);
		}
		return userConverter.toDTO(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public UserDTO saveRegister(UserDTO userDTO) {
		userDTO.setPassword(md5Utils.encode(userDTO.getPassword()));
		userDTO.setStatus(1);		//status = null
		userDTO.setRoleCode("USER");
		UserEntity userEntity = new UserEntity();
		userEntity = userConverter.toEntity(userDTO);
		List<RoleEntity> roles = new ArrayList<>();
		roles.add( roleRepository.findOneByCode( userDTO.getRoleCode() ) );
		userEntity.setRoles(roles);
		
		UserDTO result = new UserDTO();
		result.setRoleCode(userDTO.getRoleCode());
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		if(userEntity.getRoles().size() != 0) {
			for(RoleEntity item: userEntity.getRoles()) {
				RoleDTO roleDTO = roleConverter.toDTO(item); 
				list.add(roleDTO);
			}
			result.setListRole(list);
		}
		result = userConverter.toDTO(userRepository.save(userEntity));
		return result;
	}

	@Override
	public UserDTO findByUsername(String username) {
		return userConverter.toDTO(userRepository.findOneByUserNameAndStatus(username, 1));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		UserDTO result = new UserDTO();
		UserEntity userEntity = userRepository.findOne(userDTO.getId());
		userEntity.setFullName(userDTO.getFullName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setSex(userDTO.getSex());
		result = userConverter.toDTO(userRepository.save(userEntity));
		return result;
	}

	

}
