package com.proyecto.Backend_crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.Backend_crm.models.Dao.IClienteDao;
import com.proyecto.Backend_crm.models.entity.Cliente;
import com.proyecto.Backend_crm.models.entity.Tipo_Cliente;

@Service
public class ClienteServiceImpl  implements IClienteService{
	
	
	@Autowired
	private IClienteDao  clienteDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>)clienteDao.findAll();
	}
	

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipo_Cliente> findAllTCliente() {
		
		return clienteDao.findAllTCliente();
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		
		
		return clienteDao.findAll(pageable);
	}

}
