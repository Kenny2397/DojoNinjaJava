package com.codingdojo.kenny.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.kenny.modelos.Dojo;
import com.codingdojo.kenny.modelos.Ninja;
import com.codingdojo.kenny.repositorios.DojoRepository;
import com.codingdojo.kenny.repositorios.NinjaRepository;

@Service
public class AppService {
	@Autowired
	private DojoRepository repositorio_dojo;
	
	@Autowired
	private NinjaRepository repositorio_ninja;

	/*
	 * ============DOJO=================================
	 */
	public List<Dojo> getAlldojos(){
		return repositorio_dojo.findAll();
	}
	
	public Dojo create_dojo(Dojo dojo, BindingResult result) {
		
		String dojoName = dojo.getName();
		/*
		 * revisamos si existe el dojo
		 */
		if(repositorio_dojo.findByName(dojoName).isPresent()) {
			result.rejectValue("name", "Unique", "El nombre del dojo fue ingresado previamente.");
		}	
		/*
		 * GUARDAMOS SI NO HAY ERRORES
		 */
		if(result.hasErrors()) {
			return null;
		} else {
			//Guardo dojo
			return repositorio_dojo.save(dojo);
		}
		
	}
	
		
	public Dojo getDojoById(Long id) {
		Optional<Dojo> dojo = repositorio_dojo.findById(id);
		
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
	
	/*
	 * ===============NINJA=======================
	 */
	
	public Ninja createNinja(Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}else {
			
			return repositorio_ninja.save(ninja);
		}
	}
	
	public List<Ninja> getNinjasFromDojoId(Long id){
		Optional<Dojo> thisDojo = repositorio_dojo.findById(id);
		if(!thisDojo.isPresent()) {
			return null;
		}
		
		Dojo dojo = thisDojo.get();
		List<Ninja> lista_ninjas = dojo.getNinjas();
		return lista_ninjas;
	}

}
