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
import com.proyecto.Backend_crm.models.entity.Tipo_Usuario;
import com.proyecto.Backend_crm.models.entity.Usuario;
import com.proyecto.Backend_crm.models.service.IUsuarioService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private  IUsuarioService usuarioService ;
	
	
	@GetMapping("/usuario")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/TipoUsuario")
	public List<Tipo_Usuario> listarTdoc() {
		return usuarioService.findAllTipoUsuario();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Usuario usu = null;
		Map<String, Object>response = new HashMap<>();
		
		try { 
			usu = usuarioService.findById(id);
			
		}catch(DataAccessException e) {
			response.put(" mensaje","Error al realizar consulta en la base de datos");
			response.put(" error ",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(usu == null) {
			
			response.put(" mensaje","El Usuario ID:".concat(id.toString().concat(" No existe")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
	}
	
	@PostMapping("/cargaDoc")

	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		
		Usuario usuNuevo = null;
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
			usuNuevo = usuarioService.save(usuario);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario ha sido creado con Exito!");
		response.put("documento", usuNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
@PutMapping("/usuario/{id}")
	
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, @PathVariable Long id, BindingResult result) {
		
	Usuario actualUsu = usuarioService.findById(id);
		
	Usuario usuarioActualizado = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(actualUsu==null) {
			response.put("mensaje", " Error: no se puede editar: ".concat(id.toString().concat(" No existe")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			actualUsu.setNombre_usuario(usuario.getNombre_usuario());
			actualUsu.setApellidos_usuario(usuario.getApellidos_usuario());
			actualUsu.setRut_usuario(usuario.getRut_usuario());
			actualUsu.setCorreo(usuario.getCorreo());
			actualUsu.setFecha_nacimiento(usuario.getFecha_nacimiento());
			actualUsu.setId_tipo_usuario(usuario.getId_tipo_usuario());
			
			usuarioActualizado = usuarioService.save(actualUsu);
			
		}catch(DataAccessException e) {
			response.put(" mensaje","Error al actualizar clientes en la base de datos");	 
			response.put(" error ",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "usuario actualizado con exito");
		response.put("documento",usuarioActualizado);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED); 
		
	}

@DeleteMapping("/usuario/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
	Map<String, Object> response = new HashMap<>();
	
	
	try {
		Usuario usuario = usuarioService.findById(id);
		
     
		
		usuarioService.delete(id);
	}catch(DataAccessException e) {
		response.put(" mensaje","Error al eliminar usuario en la base de datos");	 
		response.put(" error ",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	response.put("mensaje", "el usuario ha sido eliminado");
	return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	
}

}
