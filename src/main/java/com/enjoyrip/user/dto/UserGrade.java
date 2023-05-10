package com.enjoyrip.user.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class UserGrade { // 사용자 역할 DTO

	private BigInteger userId; // 사용자 번호 (외래키)
	private String grade; // 사용자 등급(역할)
	private Timestamp updatedAt; // 변경 일시

	public BigInteger getUserId() {
		return userId;
	}

//	public void setUserId(BigInteger userId) {
//		this.userId = userId;
//	}

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
