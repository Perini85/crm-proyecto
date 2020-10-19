package com.proyecto.Backend_crm.models.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tipo_clientes")
public class Tipo_Cliente implements Serializable{
	
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_tipo_cliente;
	private String nombre_tipo_cliente;
	
	
	
	
	

	public long getId_tipo_cliente() {
		return id_tipo_cliente;
	}
	
	public void setId_tipo_cliente(long id_tipo_cliente) {
		this.id_tipo_cliente = id_tipo_cliente;
	}
	
	public String getNombre_tipo_cliente() {
		return nombre_tipo_cliente;
	}
	
	public void setNombre_tipo_cliente(String nombre_tipo_cliente) {
		this.nombre_tipo_cliente = nombre_tipo_cliente;
	}
	
	
	
	
	private static final long serialVersionUID = 1L;
	

}
