package com.advertisementportal.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdController {

	@RequestMapping("/createNewAd")
	public String createNewUser(Model m, Principal p)
	{
		m.addAttribute("username", p.getName());
		return "createNewAd";
	}
}
