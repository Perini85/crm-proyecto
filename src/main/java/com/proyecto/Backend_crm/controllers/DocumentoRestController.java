package com.proyecto.Backend_crm.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.proyecto.Backend_crm.models.entity.Documento;
import com.proyecto.Backend_crm.models.entity.Tipo_Documento;
import com.proyecto.Backend_crm.models.service.IDocumentoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DocumentoRestController {
	
	@Autowired
	private IDocumentoService documentoService;

	
	@GetMapping("/documento")
	public List<Documento> index() {
		return documentoService.findAll();
	}
	
	@GetMapping("/documento/page/{page}")
	public Page<Documento> index(@PathVariable Integer page) {
		Pageable pagina = PageRequest.of(page, 4);
		return documentoService.findAll(pagina);
	}
	
	@GetMapping("/documento/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Documento doc = null;
		Map<String, Object>response = new HashMap<>();
		
		try { 
			doc= documentoService.findById(id);
			
		}catch(DataAccessException e) {
			response.put(" mensaje","Error al realizar consulta en la base de datos");
			response.put(" error ",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(doc == null) {
			
			response.put(" mensaje","El cliente ID:".concat(id.toString().concat(" No existe")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Documento>(doc,HttpStatus.OK);
	}
	
	
	@PostMapping("/documento")

	public ResponseEntity<?> create(@Valid @RequestBody Documento documento, BindingResult result) {
		
		Documento docNuevo = null;
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
			docNuevo = documentoService.save(documento);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El documento ha sido creado con Exito!");
		response.put("documento", docNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
@PutMapping("/documento/{id}")
	
	public ResponseEntity<?> update(@Valid @RequestBody Documento documento, @PathVariable Long id, BindingResult result) {
		
		Documento actualDoc = documentoService.findById(id);
		
		Documento docActualizado = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(actualDoc==null) {
			response.put("mensaje", " Error: no se puede editar: ".concat(id.toString().concat(" No existe")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			actualDoc.setId_cliente(documento.getId_cliente());
			actualDoc.setId_usuario(documento.getId_usuario());
			actualDoc.setId_tipo_documento(documento.getId_tipo_documento());
			actualDoc.setId_estado_venta(documento.getId_estado_venta());
			actualDoc.setId_producto(documento.getId_producto());
			actualDoc.setFecha(documento.getFecha());
			
			docActualizado = documentoService.save(actualDoc);
			
		}catch(DataAccessException e) {
			response.put(" mensaje","Error al actualizar documento en la base de datos");	 
			response.put(" error ",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "documento actualizado con exito");
		response.put("documento", docActualizado);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED); 
		
	}

@DeleteMapping("/documento/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
	Map<String, Object> response = new HashMap<>();
	
	
	try {
		Documento documento = documentoService.findById(id);
		
		documentoService.delete(id);
		
	}catch(DataAccessException e) {
		response.put(" mensaje","Error al eliminar documento en la base de datos");	 
		response.put(" error ",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	response.put("mensaje", "el documento ha sido eliminado");
	return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	
}	



@GetMapping("/documento/Tipodoc")
public List<Tipo_Documento>listaDocumentos(){
	return documentoService.findAllTipoDocumento();
}

}
