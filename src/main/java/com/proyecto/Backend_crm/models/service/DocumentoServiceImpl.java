package com.proyecto.Backend_crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.Backend_crm.models.Dao.IDocumentoDao;
import com.proyecto.Backend_crm.models.entity.Documento;
import com.proyecto.Backend_crm.models.entity.Tipo_Documento;

@Service
public class DocumentoServiceImpl  implements IDocumentoService{

	
	@Autowired
	private IDocumentoDao documentoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		
		return (List<Documento>) documentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Documento> findAll(Pageable pageable) {
		
		 return documentoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Documento save(Documento documento) {
		
		return documentoDao.save(documento);
	}

	@Override
	@Transactional(readOnly = true)
	public Documento findById(Long id) {
		return documentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		documentoDao.deleteById(id);
		
	}

	@Override
	public List<Tipo_Documento> findAllTipoDocumento() {
		
		return documentoDao.findAllTipoDocumento();
	}
	
	
	

}
