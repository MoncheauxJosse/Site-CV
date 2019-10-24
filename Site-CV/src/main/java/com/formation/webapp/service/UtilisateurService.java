package com.formation.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formation.webapp.beans.UtilisateurEntity;
import com.formation.webapp.dao.UtilisateurDao;
import com.formation.webapp.pojo.UtilisateurBean;


@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	private UtilisateurDao utilisateurDao;

	@Override
	public List<UtilisateurBean> listeUtilisateur() {
		return UtilisateurBean.toArray(utilisateurDao.findAll());
	}

	@Override
	public UtilisateurBean recupererUtilisateur(Long id) {
		return new UtilisateurBean(utilisateurDao.findById(id).get());
	}
	
	@Override
	public void deleteById(Long id) {
		utilisateurDao.deleteById(id);		
	}
	
	@Override
	public ResponseEntity<Void> ajouterUtilisateur(UtilisateurBean UtilisateurBean) {
		UtilisateurEntity utilisateur = new UtilisateurEntity(UtilisateurBean);
		utilisateurDao.save(utilisateur);
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(utilisateur.getNom()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public ResponseEntity<Void> modifierUtilisateur (UtilisateurBean UtilisateurBean) {
		UtilisateurEntity utilisateur = new UtilisateurEntity(UtilisateurBean);
		utilisateurDao.save(utilisateur);
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(utilisateur.getNom()).toUri();
		return ResponseEntity.created(location).build();
	}

}
