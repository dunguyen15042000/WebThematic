package edu.hcmuaf.dto;

public class CommentDTO extends AbstractDTO<CommentDTO>{
	private String content;
	private Long newId;
	private String newTitle;
	private Long userId;
	private String userName;
	

	//getter and setter
	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getUserName() {
		return userName;
	}

	public Long getNewId() {
		return newId;
	}

	public void setNewId(Long newId) {
		this.newId = newId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
