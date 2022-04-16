package com.codingdojo.kenny.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.kenny.modelos.Dojo;
import com.codingdojo.kenny.modelos.Ninja;
import com.codingdojo.kenny.servicios.AppService;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	@Autowired
	private AppService servicio;
	
	@RequestMapping("/new")
	public String index(@ModelAttribute("dojo") Dojo dojo,
										Model model) {
		
		//model.addAttribute("dojos", servicio.getAlldojos());
		
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo,
							BindingResult result,
							Model model) {
		/*
		 * VALIDAMOS EL DOJO EN EL SERVICIO
		 */
		servicio.create_dojo(dojo, result);
		/*
		 * verificamos errores
		 */
		if(result.hasErrors()) {
			return "index.jsp";
		}
		return "redirect:/dojo/new";		
	}
	
	@RequestMapping("/{id}")
	public String showDojoById(@PathVariable(name="id") Long id,
								@ModelAttribute("ninja") Ninja ninja,
								Model model) {
		List<Ninja> ninjasInDojoId = servicio.getNinjasFromDojoId(id);
		
		Dojo dojo=servicio.getDojoById(id);
		model.addAttribute("ninjas", ninjasInDojoId);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
}
