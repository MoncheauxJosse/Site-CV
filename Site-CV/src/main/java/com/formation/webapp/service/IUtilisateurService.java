package com.formation.webapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.formation.webapp.pojo.UtilisateurBean;



public interface IUtilisateurService {

	
	public ResponseEntity<Void> ajouterUtilisateur(UtilisateurBean UtilisateurBean);

	public ResponseEntity<Void> modifierUtilisateur(UtilisateurBean UtilisateurBean);

	public UtilisateurBean recupererUtilisateur(Long id);

	public List<UtilisateurBean> listeUtilisateur();

	public void deleteById(Long id);		


}
