package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;
import com.example.demo.Entity.Persona;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.dto.DataDTO;
import com.example.demo.service.PersonaService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;


@RestController
public class PersonaController {

	@Autowired
	public PersonaService personaService;
	//Guardar
	@PutMapping("/guardarpersona")
	public ResponseEntity<Integer> guardarPersona(@RequestParam("nombre")String nombre,@RequestParam("apellidos")String apellidos,@RequestParam("direccioncp")Integer direccioncp){
		Integer id=0;
		try{
			id=this.personaService.guardarPersona(nombre, apellidos,direccioncp);
		}catch(Exception e) {
			System.out.println("Error");
		}
		if(id==0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(id,HttpStatus.OK);
				
	}
	
	
	//Guardar DTO
	@PutMapping("/guardarDTOpersona")
	public ResponseEntity<Integer> guardarPersona(@RequestBody DataDTO data){
		Integer id=0;
		try{
			id=this.personaService.guardarPersona(data.getNombre(), data.getApellidos(), data.getdireccioncp());
		}catch(Exception e) {
			System.out.println("Error");
		}
		if(id==0) {
			return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	//Buscar
	@GetMapping("/obtenerPersona/(id)")
	public ResponseEntity<DataDTO> ObtenerPersona(@PathVariable("id") Integer id){
		//Persona persona=this.personaService.obtenerPorid(id);
		//DataDTO data=new DataDTO(this.personaService.obtenerPorid(id));
		//DataDTO data=new DataDTO(Persona);
		//DataDTO data=new DataDTO();
		//data.setApellidos(persona.getApellidos());
		//data.setId(persona.getId());
		//data.setNombre(persona.getNombre());
		
		return new ResponseEntity<>(new DataDTO(this.personaService.obtenerPorid(id)),HttpStatus.OK);
	}
	
	//Exportar
	@Autowired
	private PersonaRepository personaRepository;
	

	@GetMapping("/exportarPersonas")
	public void ExportarPDF(){
		try (Scanner inn = new Scanner(System.in)) {
			System.out.print("Desea exportar en otra carpeta especifica diferente por default, Sources:  'si'  'no'    ");
			String exportar = inn.nextLine();
			if(exportar.toLowerCase().contains("si"))
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Ingrese la ruta donde desea exportar las Personas registradas en la base de datos. Ejemplo('C:/Documents')  :  ");
			String ruta = in.nextLine();
		Document document=new Document();
		String destino=ruta+"/BaseDeDatosDePersona.pdf";
		try {
			PdfWriter.getInstance(document,new FileOutputStream(destino));
			document.open();

			for(int f=1;f<personaRepository.count();f++) {

			document.add(new Phrase(this.personaService.guardarObjtToString(f)));
			
		}
			document.close();
			System.out.println("Creado el PDF en la ruta: "+ruta+"/BaseDeDatosDePersona.pdf de la carpeta");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			}
	}
	}

