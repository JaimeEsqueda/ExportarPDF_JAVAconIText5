package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pasatiempos",schema="public")
public class Pasatiempos {

	//Atributos
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		@Column(name="nombre")
		private String nombre;
		@Column(name="pasatiempo")
		private Integer pasatiempo;

	    @ManyToOne
	    @JoinColumn(name = "id_persona", nullable = false, updatable = false, insertable=false)
	    private Persona persona;
		private Integer id_persona;


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
		public Integer getPasatiempo() {
			return pasatiempo;
		}
		public void setPasatiempo(Integer pasatiempo) {
			this.pasatiempo = pasatiempo;
		}
		public void setId_persona(Integer id_persona) {
			this.id_persona = id_persona;
		}
		public Integer getId_persona() {
			return id_persona;
		}		
		
}
