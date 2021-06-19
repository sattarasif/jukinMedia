package com.jukinmedia.service.covidapp.controller;

/**
 * Help to render the Thymeleaf templates Present into the resource folder
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/home")
	public String login() {
		return "home";
	}
	
	@GetMapping("/login")
	public String adminLogin() {
		return "login";
	}
}
