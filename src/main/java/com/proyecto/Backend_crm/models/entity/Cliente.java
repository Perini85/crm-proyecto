package com.proyecto.Backend_crm.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_cliente;
	
	private int id_tipo_cliente;
	private int rut_cliente;
	private String nombre_cliente;
	private String apellidos_cliente;
	private int numero;
	private String correo;
	private String direccion_cliente;
	private String comuna;
	private String region;
	
	
	

	
	
	

	public long getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	

	
	public int getId_tipo_cliente() {
		return id_tipo_cliente;
	}

	public void setId_tipo_cliente(int id_tipo_cliente) {
		this.id_tipo_cliente = id_tipo_cliente;
	}

	public int getRut_cliente() {
		return rut_cliente;
	}
	
	public void setRut_cliente(int rut_cliente) {
		this.rut_cliente = rut_cliente;
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	
	public String getApellidos_cliente() {
		return apellidos_cliente;
	}

	public void setApellidos_cliente(String apellidos_cliente) {
		this.apellidos_cliente = apellidos_cliente;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	private static final long serialVersionUID = 1L;
	

}
