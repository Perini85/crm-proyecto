package com.proyecto.Backend_crm.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.Backend_crm.models.entity.Documento;
import com.proyecto.Backend_crm.models.entity.Tipo_Documento;

public interface IDocumentoDao extends JpaRepository <Documento,Long>{
	
	
	@Query("from Tipo_Documento")
	public List<Tipo_Documento> findAllTipoDocumento();	

}
