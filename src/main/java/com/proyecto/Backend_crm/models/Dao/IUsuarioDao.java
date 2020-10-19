package com.proyecto.Backend_crm.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.Backend_crm.models.entity.Tipo_Usuario;
import com.proyecto.Backend_crm.models.entity.Usuario;

public interface IUsuarioDao  extends JpaRepository<Usuario,Long> {
	
	
	@Query("from Tipo_Usuario")
	public List<Tipo_Usuario> findAllTipoUsuario();	
	

}
