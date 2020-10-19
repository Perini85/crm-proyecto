package com.proyecto.Backend_crm.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.Backend_crm.models.entity.Cliente;
import com.proyecto.Backend_crm.models.entity.Tipo_Cliente;
import com.proyecto.Backend_crm.models.service.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
private  IClienteService clienteService;


@GetMapping("/cliente")
public List<Cliente> index() {
	return clienteService.findAll();
}
	
@GetMapping("/cliente/{id}")
public ResponseEntity<?> show(@PathVariable Long id) {
	
	Cliente cli = null;
	Map<String, Object>response = new HashMap<>();
	
	try { 
		cli= clienteService.findById(id);
		
	}catch(DataAccessException e) {
		response.put(" mensaje","Error al realizar consulta en la base de datos");
		response.put(" error ",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	if(cli == null) {
		
		response.put(" mensaje","El cliente ID:".concat(id.toString().concat(" No existe")));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<Cliente>(cli,HttpStatus.OK);

}

@PostMapping("/cliente")

public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
	
	Cliente clienteNuevo = null;
	Map<String, Object> response = new HashMap<>();
	
	if(result.hasErrors()) {

		List<String> errors = result.getFieldErrors()
				.stream()
				.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
				.collect(Collectors.toList());
		
		response.put("errors", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
	try {
		clienteNuevo = clienteService.save(cliente);
	} catch(DataAccessException e) {
		response.put("mensaje", "Error al realizar el insert en la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	response.put("mensaje", "El documento ha sido creado con Exito!");
	response.put("documento", clienteNuevo);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

}

@PutMapping("/cliente/{id}")

public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, @PathVariable Long id, BindingResult result) {
	
Cliente actualCliente = clienteService.findById(id);
	
Cliente clienteActualizado = null;
	Map<String, Object> response = new HashMap<>();
	
	if(result.hasErrors()) {

		List<String> errors = result.getFieldErrors()
				.stream()
				.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
				.collect(Collectors.toList());
		
		response.put("errors", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
	
	if(actualCliente==null) {
		response.put("mensaje", " Error: no se puede editar: ".concat(id.toString().concat(" No existe")));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
	}
	
	try {
		actualCliente.setNombre_cliente(cliente.getNombre_cliente());
		actualCliente.setApellidos_cliente(cliente.getApellidos_cliente());
		actualCliente.setRut_cliente(cliente.getRut_cliente());
		actualCliente.setNumero(cliente.getNumero());
		actualCliente.setCorreo(cliente.getCorreo());
		actualCliente.setDireccion_cliente(cliente.getDireccion_cliente());
		actualCliente.setComuna(cliente.getComuna());
		actualCliente.setRegion(cliente.getRegion());
		actualCliente.setId_tipo_cliente(cliente.getId_tipo_cliente());
		
		
		
		
		clienteActualizado = clienteService.save(actualCliente);
		
	}catch(DataAccessException e) {
		response.put(" mensaje","Error al actualizar clientes en la base de datos");	 
		response.put(" error ",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	response.put("mensaje", "cliente actualizado con exito");
	response.put("cliente", clienteActualizado);
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED); 
	
}



@GetMapping("/cliente/TipoCliente")
public List<Tipo_Cliente> listarTCliente(){
	return clienteService.findAllTCliente();
}

@DeleteMapping("/cliente/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
	Map<String, Object> response = new HashMap<>();
	
	
	try {
		Cliente cliente = clienteService.findById(id);
		
     
		
		clienteService.delete(id);
	}catch(DataAccessException e) {
		response.put(" mensaje","Error al eliminar clientes en la base de datos");	 
		response.put(" error ",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	response.put("mensaje", "el cliente ha sido eliminado");
	return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	
}

}


