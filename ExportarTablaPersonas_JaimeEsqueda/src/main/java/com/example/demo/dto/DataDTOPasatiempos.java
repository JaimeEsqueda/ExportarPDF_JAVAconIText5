package com.example.demo.dto;

import com.example.demo.Entity.Pasatiempos;

public class DataDTOPasatiempos {

	
	public  DataDTOPasatiempos() {
	}
	public  DataDTOPasatiempos(Pasatiempos pasatiempo) {
		this.id=pasatiempo.getId();
		this.nombre=pasatiempo.getNombre();
		this.pasatiempo=pasatiempo.getPasatiempo();
		this.id_persona=pasatiempo.getId_persona();
	}
	public Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer pasatiempo;
	
	public Integer getPasatiempo() {
		return pasatiempo;
	}

	public void setPasatiempo(Integer pasatiempo) {
		this.pasatiempo = pasatiempo;
	}
	
	public Integer id_persona;
	
	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}
}
