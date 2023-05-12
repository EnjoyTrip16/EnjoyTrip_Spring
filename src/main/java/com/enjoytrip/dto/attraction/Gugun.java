package com.enjoytrip.dto.attraction;

public class Gugun {
	
	//gugun table PK
	private long gugunCode;
	
	//gugun table 구/군 이름 ex)강서구,달성구,강화군
	private String gugunName;
	
	//sido table PK gugun table FK
	private long sidoCode;

	public long getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(long gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public long getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(long sidoCode) {
		this.sidoCode = sidoCode;
	}

	@Override
	public String toString() {
		return "Gugun 구/군 정보 [gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", sidoCode=" + sidoCode + "]";
	}
	
	
}
