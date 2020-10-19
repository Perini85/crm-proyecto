package com.proyecto.Backend_crm.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado_venta")
public class Estado_Venta implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id_estado_venta;
	
	private String descripcion;

	public long getId_estado_venta() {
		return Id_estado_venta;
	}

	public void setId_estado_venta(long id_estado_venta) {
		Id_estado_venta = id_estado_venta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private static final long serialVersionUID = 1L;

}
