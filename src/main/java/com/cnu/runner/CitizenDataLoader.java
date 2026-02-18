package com.cnu.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cnu.entity.CitizenPlan;
import com.cnu.repo.CitizenPlanRepo;

@Component
public class CitizenDataLoader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		CitizenPlan c1 =new CitizenPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);
		
		CitizenPlan c2 =new CitizenPlan();
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Job");

		
		CitizenPlan c3 =new CitizenPlan();
		c3.setCitizenName("Steve");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setTerminateDate(LocalDate.now());
		c3.setTerminationReason("Employed");
		
		CitizenPlan c4 =new CitizenPlan();
		c4.setCitizenName("Tim");
		c4.setGender("Male");
		c4.setPlanName("Medical");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(5000.00);
		
		CitizenPlan c5 =new CitizenPlan();
		c5.setCitizenName("David");
		c5.setGender("Male");
		c5.setPlanName("Medical");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");

		
		CitizenPlan c6 =new CitizenPlan();
		c6.setCitizenName("Cathy");
		c6.setGender("Female");
		c6.setPlanName("Medical");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminateDate(LocalDate.now());
		c6.setTerminationReason("Employed");
		
		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6);
		repo.saveAll(list);

	}

}
