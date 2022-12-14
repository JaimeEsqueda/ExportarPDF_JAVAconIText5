package com.example.demo.dto;

import com.example.demo.Entity.Direccion;

public class DataDTOdireccion {

	
	public  DataDTOdireccion() {
		
	}
	public  DataDTOdireccion(Direccion direccion) {
		this.id=direccion.getId();
		this.calle=direccion.getCalle();
		this.numero_interior=direccion.getNumero_interior();
		this.numero_exterior=direccion.getNumero_exterior();
		this.direccioncp=direccion.getCodigopostal();
		this.colonia=direccion.getColonia();
		this.ciudad=direccion.getCiudad();
		this.estado=direccion.getEstado();
	}
	public Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String calle;
	
	public String numero_interior;
	
	public String numero_exterior;

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
	public Integer direccioncp;

	public Integer getdireccioncp() {
		return direccioncp;
	}
	public void setdireccioncp(Integer direccioncp) {
		this.direccioncp = direccioncp;
		
	}
		public Integer ciudad;

		public Integer getCiudad() {
			return ciudad;
		}
		public void setCiudad(Integer ciudad) {
			this.ciudad = ciudad;
	}
		public Integer estado;

		public Integer getEstado() {
			return estado;
		}
		public void setEstado(Integer estado) {
			this.estado = estado;
	}
		
		public String colonia;

		public String getColonia() {
			return calle;
		}

		public void setColonia(String colonia) {
			this.colonia = colonia;
		}
}
