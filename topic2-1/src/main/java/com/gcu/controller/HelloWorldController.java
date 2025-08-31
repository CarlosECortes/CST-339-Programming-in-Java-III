package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@GetMapping("/test1")
	@ResponseBody
	public String printHello() {
		return "Hello World!";
	}
		
	@GetMapping("/test2")
	public String printHello(Model model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello"; // This points to src/main/resources/template/hello.html
	
	}
	
	@GetMapping("/test3")
	public ModelAndView printHello1() {
		ModelAndView mv = new ModelAndView("hello"); //uses hello.html
		mv.addObject("message", "Hello World from ModelAndView");
		mv.addObject("message2", "Another Hello World from ModelAndView!");
		return mv;
	}
	
	@GetMapping("/test4")
	public String printHello(@RequestParam("message") String message, Model model) {
		model.addAttribute("message", message);
		return "hello";
	}

}
