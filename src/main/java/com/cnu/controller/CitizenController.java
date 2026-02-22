package com.cnu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cnu.entity.CitizenPlan;
import com.cnu.search.SearchRequest;
import com.cnu.service.CitizenService;

@Controller
public class CitizenController {
	
	@Autowired
	private CitizenService service;
	
	@GetMapping("/")
	public String indexPage(Model model)
	{
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		//Reloading new form for every search request object
		//model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.showPlanNames());
		model.addAttribute("status", service.showPlanStatus());
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute("search") SearchRequest request, Model model)
	{
		System.out.println(request);
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}

}
