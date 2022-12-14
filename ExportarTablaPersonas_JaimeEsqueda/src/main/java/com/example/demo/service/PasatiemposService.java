package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Pasatiempos;
import com.example.demo.Repository.PasatiemposRepository;


@Service
public class PasatiemposService {
	

	@Autowired
	private PasatiemposRepository pasatiemposRepository;
	
	public PasatiemposService(PasatiemposRepository pasatiemposRepository) {
		this.pasatiemposRepository=pasatiemposRepository;
	}
	
	public Pasatiempos obtenerPorid(Integer id) {
		return this.pasatiemposRepository.findById(id).get();
	}
	
	public Integer guardarPasatiempos(String nombre, Integer pasatiempo, Integer id_persona) {
		Pasatiempos pasatiempos=new Pasatiempos();
		pasatiempos.setNombre(nombre);
		pasatiempos.setPasatiempo(pasatiempo);
		pasatiempos.setId_persona(id_persona);
		pasatiempos=pasatiemposRepository.save(pasatiempos);
		return pasatiempos.getId();
	}

}
