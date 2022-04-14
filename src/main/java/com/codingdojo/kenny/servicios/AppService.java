package com.codingdojo.kenny.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.kenny.modelos.Dojo;
import com.codingdojo.kenny.repositorios.DojoRepository;

@Service
public class AppService {
	@Autowired
	private DojoRepository repositorio_dojo;

	public List<Dojo> getAlldojos(){
		return repositorio_dojo.findAll();
	}
	
	
}
