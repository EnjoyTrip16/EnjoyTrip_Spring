package com.enjoytrip.dao.attraction;

import java.util.List;

import com.enjoytrip.dto.attraction.Gugun;
import com.enjoytrip.dto.attraction.Sido;

public interface SidoGugunDao {
	public List<Sido> retrieveSido();
	
	public List<Gugun> retrieveGugun(Long sidoCode,Long gugunCode);
}
