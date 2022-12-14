package com.example.demo.service;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Direccion;
import com.example.demo.Entity.Persona;
import com.example.demo.Repository.DireccionRepository;
import com.example.demo.Repository.PersonaRepository;

@Service
public class DireccionService {

	
	@Autowired
	private DireccionRepository direccionRepository;
	
	public DireccionService(DireccionRepository direccionRepository) {
		this.direccionRepository=direccionRepository;
	}
	
	public Direccion obtenerPorid(Integer id) {
		return this.direccionRepository.findById(id).get();
	}
	
	public Integer guardarDireccion(String calle, String numero_interior, String numero_exterior, Integer codigopostal,String colonia,  Integer ciudad, Integer estado) {
		Direccion direccion=new Direccion();
		direccion.setCalle(calle);
		direccion.setNumero_interior(numero_interior);
		direccion.setNumero_exterior(numero_exterior);
		direccion.setCodigopostal(codigopostal);
		direccion.setColonia(colonia);
		direccion.setCiudad(ciudad);
		direccion.setCiudad(estado);

		direccion=direccionRepository.save(direccion);
		return direccion.getId();
	}


}
