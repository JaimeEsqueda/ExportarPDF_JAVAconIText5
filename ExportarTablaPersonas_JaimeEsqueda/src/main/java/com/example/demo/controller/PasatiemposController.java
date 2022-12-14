package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DataDTOPasatiempos;
import com.example.demo.service.PasatiemposService;


@RestController
public class PasatiemposController {

	
	

	@Autowired
	public PasatiemposService pasatiemposService;
	//Guardar
	@PutMapping("/guardarpasatiempo")
	public ResponseEntity<Integer> guardarPasatiempos(@RequestParam("nombre")String nombre,@RequestParam("pasatiempo")Integer pasatiempo,@RequestParam("id_persona")Integer id_persona){
		Integer id=0;
		try{
			id=this.pasatiemposService.guardarPasatiempos(nombre, pasatiempo,id_persona);
		}catch(Exception e) {
			System.out.println("Error");
		}
		if(id==0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	//Guardar DTO
	@PutMapping("/guardarDTOpasatiempo")
	public ResponseEntity<Integer> guardarPasatiempo(@RequestBody DataDTOPasatiempos data){
		Integer id=0;
		try{
			id=this.pasatiemposService.guardarPasatiempos(data.getNombre(), data.getPasatiempo(), data.getId_persona());
		}catch(Exception e) {
			System.out.println("Error");
		}
		if(id==0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	//Buscar
	@GetMapping("/obtenerPasatiempo/(id)")
	public ResponseEntity<DataDTOPasatiempos> ObtenerPasatiempo(@PathVariable("id") Integer id){
		//Persona persona=this.personaService.obtenerPorid(id);
		//DataDTO data=new DataDTO(this.personaService.obtenerPorid(id));
		//DataDTO data=new DataDTO(Persona);
		//DataDTO data=new DataDTO();
		//data.setApellidos(persona.getApellidos());
		//data.setId(persona.getId());
		//data.setNombre(persona.getNombre());
		
		return new ResponseEntity<>(new DataDTOPasatiempos(this.pasatiemposService.obtenerPorid(id)),HttpStatus.OK);
	}
}
