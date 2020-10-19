package com.proyecto.Backend_crm.models.service;

import java.util.List;

import com.proyecto.Backend_crm.models.entity.Cliente;
import com.proyecto.Backend_crm.models.entity.Tipo_Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService {
	
	
	
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public Page<Cliente> findAll(Pageable pageable);
	
	
	public List<Tipo_Cliente> findAllTCliente();
	

}
