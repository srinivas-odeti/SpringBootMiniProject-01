package com.cnu.service;

import java.util.List;

import com.cnu.entity.CitizenPlan;
import com.cnu.search.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenService {

	public List<String> showPlanNames();
	
	public List<String> showPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
