package com.codingdojo.kenny.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.kenny.modelos.Dojo;
import com.codingdojo.kenny.modelos.Ninja;
import com.codingdojo.kenny.servicios.AppService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
	
	@Autowired
	private AppService servicio;
	
	@RequestMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja,
					@ModelAttribute("dojo") Dojo dojo,
						Model model) {
		/*
		 * ENVIO DETODOS LOS DOJOS AL JSP
		 */
		model.addAttribute("dojos",servicio.getAlldojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("ninja") Ninja ninja,
						Model model,
						BindingResult result) {
		servicio.createNinja(ninja, result);
		if(result.hasErrors()) {
			model.addAttribute("dojos",servicio.getAlldojos());
			return "newNinja.jsp";
		}
		
		return "redirect:/ninja/new";
		
	}
}
