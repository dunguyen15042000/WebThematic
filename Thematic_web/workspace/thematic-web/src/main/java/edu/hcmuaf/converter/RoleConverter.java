package edu.hcmuaf.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.entity.RoleEntity;

@Component
public class RoleConverter {
	
	public RoleDTO toDTO(RoleEntity roleEntity) {
		RoleDTO result = new RoleDTO();
		result.setId(roleEntity.getId());
		result.setName(roleEntity.getName());
		result.setCode(roleEntity.getCode());
		return result;
	}
	
	public RoleEntity toEntity(RoleDTO roleDTO) {
		RoleEntity result = new RoleEntity();
		result.setCode(roleDTO.getCode());
		result.setName(roleDTO.getName());
		return result;
	}

	public RoleEntity toEntity(RoleEntity result, RoleDTO roleDTO) {
		result.setCode(roleDTO.getCode());
		result.setName(roleDTO.getName());
		return result;
	}

	public Map<String, String> toMap(List<RoleDTO> listRole) {
		Map<String, String> result = new HashMap<>();
		for(RoleDTO item: listRole) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

	public List<String> toStringList(List<RoleDTO> listDTO) {
		List<String> result = new ArrayList<>();
		for(RoleDTO item: listDTO) {
			result.add(item.getCode());
		}
		return result;
	}
}
