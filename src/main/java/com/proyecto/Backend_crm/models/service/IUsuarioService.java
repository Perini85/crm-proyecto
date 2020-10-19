package com.proyecto.Backend_crm.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.Backend_crm.models.entity.Tipo_Usuario;
import com.proyecto.Backend_crm.models.entity.Usuario;

public interface IUsuarioService {
	
	
	
	public List <Usuario> findAll();
	
	public Usuario save( Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);	
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public List <Tipo_Usuario>  findAllTipoUsuario();

}
