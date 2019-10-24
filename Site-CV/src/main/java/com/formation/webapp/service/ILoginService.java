package com.formation.webapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.formation.webapp.pojo.LoginPojo;


public interface ILoginService {
	
	public ResponseEntity<Void> ajouterLogin(LoginPojo LoginPojo);

	public ResponseEntity<Void> modifierLogin(LoginPojo LoginPojo);

	public LoginPojo recupererLogin(Long id);

	public List<LoginPojo> listeLogin();

	public void deleteById(Long id);		

}
