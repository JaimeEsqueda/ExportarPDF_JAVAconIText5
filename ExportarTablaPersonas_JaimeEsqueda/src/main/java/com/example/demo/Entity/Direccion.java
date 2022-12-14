package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="direccion",schema="public")
public class Direccion {

	//Atributos
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		@Column(name="calle")
		private String calle;
		@Column(name="numero_interior")
		private String numero_interior;
		@Column(name="numero_exterior")
		private String numero_exterior;
		@Column(name="codigopostal")
		private Integer codigopostal;
		@Column(name="colonia")
		private String colonia;
		@Column(name="ciudad")
		private Integer ciudad;
		@Column(name="estado")
		private Integer estado;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCalle() {
			return calle;
		}
		public void setCalle(String calle) {
			this.calle = calle;
		}
		public String getNumero_interior() {
			return numero_interior;
		}
		public void setNumero_interior(String numero_interior) {
			this.numero_interior = numero_interior;
		}
		public String getNumero_exterior() {
			return numero_exterior;
		}
		public void setNumero_exterior(String numero_exterior) {
			this.numero_exterior = numero_exterior;
		}
		public Integer getCodigopostal() {
			return codigopostal;
		}
		public void setCodigopostal(Integer codigopostal) {
			this.codigopostal = codigopostal;
		}
		public String getColonia() {
			return colonia;
		}
		public void setColonia(String colonia) {
			this.colonia = colonia;
		}
		public Integer getCiudad() {
			return ciudad;
		}
		public void setCiudad(Integer ciudad) {
			this.ciudad = ciudad;
		}
		public Integer getEstado() {
			return estado;
		}
		public void setEstado(Integer estado) {
			this.estado = estado;
		}
		
		
		
}
