package edu.hcmuaf.service;

import java.util.List;
import java.util.Map;

import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.dto.UserDTO;

public interface IRoleService {
	List<RoleDTO> findAll();
	Map<String, String> findAllRole();
	RoleDTO findById(Long id);

	void delete(long[] ids);

	RoleDTO save(RoleDTO roleDTO);
	Map<String, String> toMap(List<RoleDTO> listRole);
	List<String> toStringList(List<RoleDTO> listDTO);
}
