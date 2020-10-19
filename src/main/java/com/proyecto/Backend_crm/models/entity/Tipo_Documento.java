package com.proyecto.Backend_crm.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tipo_documentos")
public class Tipo_Documento implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id_tipo_documento;
	
	
	private String descripcion;
	
	
	
	
	
	public long getId_tipo_documento() {
		return Id_tipo_documento;
	}





	public void setId_tipo_documento(long id_tipo_documento) {
		Id_tipo_documento = id_tipo_documento;
	}





	public String getDescripcion() {
		return descripcion;
	}





	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	private static final long serialVersionUID = 1L;

}
