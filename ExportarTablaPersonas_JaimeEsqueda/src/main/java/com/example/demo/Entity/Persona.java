package com.example.demo.Entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persona",schema="public")
public class Persona {
//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="direccioncp")
	private Integer direccioncp;
	
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pasatiempos> pasatiempos;
	   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getdireccioncp() {
		return direccioncp;
	}
	public void setdireccioncp(Integer direccioncp) {
		this.direccioncp = direccioncp;
	}

    public String imprimirPersona(String nombre, String apellidos,Integer direccioncp){
    	this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.direccioncp=direccioncp;    
        return "\n Id: "+id+", Nombre: "+nombre+", Apellidos: "+apellidos+", Dirección: "+direccioncp;

}
}
