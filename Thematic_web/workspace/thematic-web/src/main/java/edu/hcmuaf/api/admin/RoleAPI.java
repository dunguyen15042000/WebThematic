package edu.hcmuaf.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.hcmuaf.dto.RoleDTO;
import edu.hcmuaf.service.IRoleService;

@RestController(value ="roleAPIOfAdmin")
public class RoleAPI {

	@Autowired
	private IRoleService roleService;
	
	@PostMapping("/api/role")
	public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
		return roleService.save(roleDTO);
	}
	
	@PutMapping("/api/role")
	public RoleDTO updateRole(@RequestBody RoleDTO roleDTO) {
		return roleService.save(roleDTO);
	}
	
	@DeleteMapping("/api/role")
	public void deleteRole(@RequestBody long[] ids) {
		roleService.delete(ids);
		
	}
	
}
