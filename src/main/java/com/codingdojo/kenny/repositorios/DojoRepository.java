package com.codingdojo.kenny.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.kenny.modelos.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{
	
	List<Dojo> findAll();

}
