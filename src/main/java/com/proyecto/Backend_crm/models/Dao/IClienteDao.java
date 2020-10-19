package com.proyecto.Backend_crm.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.Backend_crm.models.entity.Cliente;
import com.proyecto.Backend_crm.models.entity.Tipo_Cliente;

public interface IClienteDao extends JpaRepository<Cliente,Long>{
	
	
	
	@Query("from Tipo_Cliente")
	public List<Tipo_Cliente> findAllTCliente();

}
