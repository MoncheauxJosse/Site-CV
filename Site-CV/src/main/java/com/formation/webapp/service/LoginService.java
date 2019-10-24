package com.formation.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formation.webapp.beans.LoginEntity;
import com.formation.webapp.dao.LoginDao;
import com.formation.webapp.pojo.LoginPojo;


@Service
public class LoginService implements ILoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public List<LoginPojo> listeLogin() {
		return LoginPojo.toArray(loginDao.findAll());
	}

	@Override
	public LoginPojo recupererLogin(Long id) {
		return new LoginPojo(loginDao.findById(id).get());
	}
	
	@Override
	public void deleteById(Long id) {
		loginDao.deleteById(id);		
	}
	
	@Override
	public ResponseEntity<Void> ajouterLogin(LoginPojo LoginPojo) {
		LoginEntity login = new LoginEntity(LoginPojo);
		loginDao.save(login);
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(login.getNom()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public ResponseEntity<Void> modifierLogin (LoginPojo LoginPojo) {
		LoginEntity login = new LoginEntity(LoginPojo);
		loginDao.save(login);
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(login.getNom()).toUri();
		return ResponseEntity.created(location).build();
	}


}

