package it.sara.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.sara.spring.DatiMessaggio;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) 
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/home")
	public String home() 
	{
		
		return "home";
	}
	
	@GetMapping("/about")
	public String about() 
	{
		
		return "about";
	}
	
	
	@GetMapping("/contacts")
	public String form(Model model)
	{
		DatiMessaggio dati = new DatiMessaggio();
		model.addAttribute("dati",dati);
		
		return "contacts";
	}
	
	@PostMapping("/send")
	public String submitForm(@ModelAttribute("dati") DatiMessaggio dati)
	{
		System.out.println(dati);
		return "send_success";
		
	}
	

}
