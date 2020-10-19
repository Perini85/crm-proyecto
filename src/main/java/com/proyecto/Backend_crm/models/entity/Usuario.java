package com.proyecto.Backend_crm.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_usuario;
	
	private int id_tipo_usuario;
	
	private int rut_usuario;
	
	private String nombre_usuario;
	
	private String apellidos_usuario;
	
	
	private String correo;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	
	
	
	
	
	
	
	
	public long getId_usuario() {
		return id_usuario;
	}








	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}








	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}








	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}








	public int getRut_usuario() {
		return rut_usuario;
	}








	public void setRut_usuario(int rut_usuario) {
		this.rut_usuario = rut_usuario;
	}








	public String getNombre_usuario() {
		return nombre_usuario;
	}








	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}








	public String getApellidos_usuario() {
		return apellidos_usuario;
	}








	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}








	public String getCorreo() {
		return correo;
	}








	public void setCorreo(String correo) {
		this.correo = correo;
	}








	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}








	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}








	private static final long serialVersionUID = 1L;

}
