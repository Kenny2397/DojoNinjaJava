package com.codingdojo.kenny.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.kenny.modelos.Dojo;
import com.codingdojo.kenny.servicios.AppService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	private AppService servicio;
	
	@RequestMapping("/new")
	public String index(@ModelAttribute("dojo") Dojo dojo,
										Model model) {
		
		//model.addAttribute("dojos", servicio.getAlldojos());
		
		return "index.jsp";
	}
}
