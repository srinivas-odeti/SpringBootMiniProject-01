package com.cnu.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cnu.entity.CitizenPlan;
import com.cnu.repo.CitizenPlanRepo;
import com.cnu.search.SearchRequest;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenPlanRepo planRepo;
	
	@Override
	public List<String> showPlanNames() {
		List<String> list = planRepo.getPlanNames();
		return list;
	}

	@Override
	public List<String> showPlanStatus() {
		List<String> list = planRepo.getPlanStatus();
		
		return list;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		
		
		return planRepo.findAll();
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
