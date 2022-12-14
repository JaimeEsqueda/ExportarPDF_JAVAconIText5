package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Persona;
import com.example.demo.Repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository=personaRepository;
	}
	
	public Persona obtenerPorid(Integer id) {
		return this.personaRepository.findById(id).get();
	}
	public String guardarObjtToString(Integer id) {
		return this.personaRepository.findById(id).get().imprimirPersona(this.personaRepository.findById(id).get().getNombre(),this.personaRepository.findById(id).get().getApellidos(),this.personaRepository.findById(id).get().getdireccioncp());
	}
	
	public Integer guardarPersona(String nombre, String apellidos, Integer direccioncp) {
		Persona persona=new Persona();
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setdireccioncp(direccioncp);
		persona=personaRepository.save(persona);
		return persona.getId();
	}
}
