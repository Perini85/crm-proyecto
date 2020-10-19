package com.proyecto.Backend_crm.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="tipos_usuarios")
public class Tipo_Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_tipo_usuario;
	
	private String nombre_tipo_usuario;

	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public String getNombre_tipo_usuario() {
		return nombre_tipo_usuario;
	}

	public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
		this.nombre_tipo_usuario = nombre_tipo_usuario;
	}
	
	private static final long serialVersionUID = 1L;
	

}
