package com.cnu.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cnu.entity.CitizenPlan;
import com.cnu.repo.CitizenPlanRepo;
import com.cnu.search.SearchRequest;
import com.cnu.utils.EmailUtils;
import com.cnu.utils.ExcelGenerator;
import com.cnu.utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenPlanRepo planRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;
	
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
		CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())){
			entity.setPlanName(request.getPlanName());
		}
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())){
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if(null!=request.getGender() && !"".equals(request.getGender())){
			entity.setGender(request.getGender());
		}
		
		if(null!=request.getStartDate() && !"".equals(request.getStartDate())){
		    entity.setPlanStartDate(request.getStartDate());
		}

		if(null!=request.getEndDate() && !"".equals(request.getEndDate())){
		    entity.setPlanEndDate(request.getEndDate());
		}
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response, List<CitizenPlan> plans) throws Exception {
			    
		File file = new File("Plans.xls");
		excelGenerator.generate(response, plans,file);
		
		String subject = "Subject";
		String body="Body";
		String to = "srinivascnu112@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response, List<CitizenPlan> plans) throws Exception {
		
		File file = new File("Plans.pdf");
	    pdfGenerator.generate(response, plans, file);
		
	    String subject = "Subject";
		String body="Body";
		String to = "srinivascnu112@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,file);
		
		file.delete();
	    
		return true;
	}
	
}