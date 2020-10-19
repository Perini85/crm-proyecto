package com.proyecto.Backend_crm.models.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.Backend_crm.models.entity.Documento;
import com.proyecto.Backend_crm.models.entity.Tipo_Documento;

public interface IDocumentoService {
	
	public List<Documento> findAll();
	
	 public Page<Documento> findAll(Pageable pageable);
		
		
		public Documento save(Documento documento);
		
		public Documento findById(Long id);
		
		public void delete(Long id);
		
		public List <Tipo_Documento> findAllTipoDocumento();

}
