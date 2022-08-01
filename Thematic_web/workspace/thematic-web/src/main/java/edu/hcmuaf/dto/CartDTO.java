package edu.hcmuaf.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO extends AbstractDTO<CartDTO>{
	private Long userId;
	private String userName;
	private int total;
	private List<NewDTO> listNews = new ArrayList<>(); 
	
	//getter and setter
	public Long getUserId() {
		return userId;
	}
	public List<NewDTO> getListNews() {
		return listNews;
	}
	public void setListNews(List<NewDTO> listNews) {
		this.listNews = listNews;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
