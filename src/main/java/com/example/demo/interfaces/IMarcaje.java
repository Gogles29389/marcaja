package com.example.demo.interfaces;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Marcaje;

@Repository
public interface IMarcaje extends CrudRepository <Marcaje, Integer>  {
	
	
}
