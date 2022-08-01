package edu.hcmuaf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity{
	
	@Column(name = "total")
	private int total;
	 
	@OneToOne(mappedBy = "cart")
	private UserEntity user;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cart_new", joinColumns = @JoinColumn(name = "cartid"), 
	  			inverseJoinColumns = @JoinColumn(name = "newid"))
	private List<NewEntity> news = new ArrayList<>();
	 
	//getter and setter	 
	public UserEntity getUser() {
		return user;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<NewEntity> getNews() {
		return news;
	}

	public void setNews(List<NewEntity> news) {
		this.news = news;
	}

	
	
}
