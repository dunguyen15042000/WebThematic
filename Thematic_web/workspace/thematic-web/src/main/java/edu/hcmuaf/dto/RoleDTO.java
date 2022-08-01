package edu.hcmuaf.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends AbstractDTO<RoleDTO>{
	private String code;
	private String name;
	private List<UserDTO> listUserDTO = new ArrayList<>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserDTO> getListUserDTO() {
		return listUserDTO;
	}
	public void setListUserDTO(List<UserDTO> listUserDTO) {
		this.listUserDTO = listUserDTO;
	}
}
