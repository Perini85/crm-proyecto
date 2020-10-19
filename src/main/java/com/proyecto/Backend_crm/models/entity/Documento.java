package com.proyecto.Backend_crm.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="documentos")
public class Documento implements Serializable{
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_documento;
	private int  id_estado_venta;
	private int id_producto;
	private int id_cliente;
	private int id_usuario;
	private int id_tipo_documento;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	public long getId_documento() {
		return id_documento;
	}
	public void setId_documento(long id_documento) {
		this.id_documento = id_documento;
	}
	public int getId_estado_venta() {
		return id_estado_venta;
	}
	public void setId_estado_venta(int id_estado_venta) {
		this.id_estado_venta = id_estado_venta;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_tipo_documento() {
		return id_tipo_documento;
	}
	public void setId_tipo_documento(int id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	




	private static final long serialVersionUID = 1L;
	
	

}
