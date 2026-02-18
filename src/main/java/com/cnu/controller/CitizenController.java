package com.cnu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnu.service.CitizenService;

@Controller
public class CitizenController {
	
	@Autowired
	private CitizenService service;
	
	@GetMapping("/")
	public String indexPage()
	{
		return "index";
	}

}
