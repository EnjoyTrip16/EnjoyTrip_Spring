package com.enjoytrip.dto.user;

// 사용자 검색 DTO
public class UserSearch {
	
	// 사용자 번호
	private Long userId;

	// 사용자 아이디
	private String id;

	// 사용자 비밀번호
	private String pw;

	// 사용자 이름
	private String name;

	// 사용자 이메일 주소
	private String email;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserSearch [userId=" + userId + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ "]";
	}
}
