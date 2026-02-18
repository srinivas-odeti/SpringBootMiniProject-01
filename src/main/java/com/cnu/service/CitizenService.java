package com.cnu.service;

import java.util.List;

import com.cnu.entity.CitizenPlan;
import com.cnu.search.SearchRequest;

public interface CitizenService {

	public List<String> showPlanNames();
	
	public List<String> showPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel();
	
	public boolean exportPdf();
}
