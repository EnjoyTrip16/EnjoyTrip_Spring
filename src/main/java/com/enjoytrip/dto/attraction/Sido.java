package com.enjoytrip.dto.attraction;

public class Sido {
	
	//sido table PK
	private long sidoCode;
	
	//sido table 시/도 이름 ex)서울시, 경기도
	private String sidoName;

	public long getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(long sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	@Override
	public String toString() {
		return "Sido [sidoCode=" + sidoCode + ", sidoName=" + sidoName + "]";
	}
	
	
}
