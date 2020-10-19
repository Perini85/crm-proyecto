package com.proyecto.Backend_crm.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.Backend_crm.models.Dao.IUsuarioDao;
import com.proyecto.Backend_crm.models.entity.Tipo_Usuario;
import com.proyecto.Backend_crm.models.entity.Usuario;


@Service
public class UsuarioServiceImpl  implements IUsuarioService{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return (List<Usuario>)usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		usuarioDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		
		return usuarioDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipo_Usuario> findAllTipoUsuario() {
		
		return usuarioDao.findAllTipoUsuario();
	}


	
	

}
