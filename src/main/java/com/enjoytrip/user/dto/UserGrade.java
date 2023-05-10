package com.enjoytrip.user.dto;

import java.sql.Timestamp;

//사용자 역할 DTO
public class UserGrade {

	// 사용자 번호 (FK)
	private long userId;
	
	// 사용자 등급(역할)
	private String grade;

	// 변경 일시
	private Timestamp updatedAt;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserGrade [userId=" + userId + ", grade=" + grade + ", updatedAt=" + updatedAt + "]";
	}

}
