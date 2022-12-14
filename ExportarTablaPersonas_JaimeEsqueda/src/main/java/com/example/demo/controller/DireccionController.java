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

import com.example.demo.dto.DataDTOdireccion;
import com.example.demo.service.DireccionService;


@RestController
public class DireccionController {

	@Autowired
	public DireccionService direccionService;
	//Guardar
	@PutMapping("/guardardireccion")
	public ResponseEntity<Integer> guardarPersona(@RequestParam("calle")String calle,@RequestParam("numero_interior")String numero_interior,@RequestParam("numero_exterior")String numero_exterior,@RequestParam("codigopostal")Integer codigopostal,@RequestParam("colonia")String colonia,@RequestParam("ciudad")Integer ciudad,@RequestParam("estado")Integer estado){
		Integer id=0;
		try{
			id=this.direccionService.guardarDireccion(calle, numero_interior,numero_exterior, codigopostal, colonia, ciudad, estado);
		}catch(Exception e) {
			System.out.println("Error");
		}
		if(id==0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	//Guardar DTO
	@PutMapping("/guardarDTOdireccion")
	public ResponseEntity<Integer> guardarDireccion(@RequestBody DataDTOdireccion data){
		Integer id=0;
		try{
			id=this.direccionService.guardarDireccion(data.getCalle(), data.getNumero_interior(), data.getNumero_exterior(),data.getdireccioncp(), data.getColonia(), data.getEstado(),getColonia());
		}catch(Exception e) {
			System.out.println("Error");
		}
		if(id==0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	private Integer getColonia() {
		// TODO Auto-generated method stub
		return null;
	}

	//Buscar
	@GetMapping("/obtenerDireccion/(id)")
	public ResponseEntity<DataDTOdireccion> ObtenerDireccion(@PathVariable("id") Integer id){
		//Persona persona=this.personaService.obtenerPorid(id);
		//DataDTO data=new DataDTO(this.personaService.obtenerPorid(id));
		//DataDTO data=new DataDTO(Persona);
		//DataDTO data=new DataDTO();
		//data.setApellidos(persona.getApellidos());
		//data.setId(persona.getId());
		//data.setNombre(persona.getNombre());
		
		return new ResponseEntity<>(new DataDTOdireccion(this.direccionService.obtenerPorid(id)),HttpStatus.OK);
	}
}
