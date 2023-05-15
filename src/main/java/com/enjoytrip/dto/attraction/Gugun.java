package com.enjoytrip.dto.attraction;

public class Gugun {
	
	//gugun table PK
	private Long gugunCode;
	
	//gugun table 구/군 이름 ex)강서구,달성구,강화군
	private String gugunName;
	
	//sido table PK gugun table FK
	private Long sidoCode;

	public Long getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(Long gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public Long getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(Long sidoCode) {
		this.sidoCode = sidoCode;
	}

	@Override
	public String toString() {
		return "Gugun [gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", sidoCode=" + sidoCode + "]";
	}
	
	
}
