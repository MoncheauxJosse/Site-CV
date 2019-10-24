package com.formation.webapp.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.formation.webapp.pojo.LoginPojo;
import com.formation.webapp.pojo.UtilisateurBean;

@Entity
public class LoginEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Login_generator")
	@SequenceGenerator(name = "login_generator", sequenceName = "login_sequence", initialValue = 3, allocationSize = 1)
	private Long id;
	private String nom;
	private String societe;

	
	public LoginEntity() {
		super();
	}

	public LoginEntity(LoginPojo e) {
		super();
		this.id = e.getId();
		this.nom = e.getNom();
		this.societe = e.getSociete();

	}
	
	public LoginPojo convertToEntity(LoginEntity eb) {
		LoginPojo conv = new LoginPojo();
		conv.setId(eb.getId());
		conv.setNom(eb.getNom());
		conv.setSociete(eb.getSociete());
		
		
		return conv;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		if(this.nom == "") {
    		this.setNom("Anonyme");
    		}
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSociete() {
		if(this.societe == "") {
    		this.setSociete("Anonyme");
		}
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static List<LoginEntity> toArray(List<LoginPojo> logins) {
		List<LoginEntity> resultat = new ArrayList<>();
		for (LoginPojo login : logins) {
			resultat.add(new LoginEntity(login));
		}
		return resultat;
	}



}

