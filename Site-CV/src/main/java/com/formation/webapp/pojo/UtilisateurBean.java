package com.formation.webapp.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.formation.webapp.beans.UtilisateurEntity;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UtilisateurBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String Role;
	private String nom;
	@Size(min = 2, max = 255)
	private String prenom;
	private Date dateNaissance;
	@Valid
	private String adresse;
	@Size(min = 10 , max = 15)
	private String telephone;
	@Email
	private String mail;
	
	
	

	
	public UtilisateurBean(Long id, String nom, @Size(min = 2, max = 255) String prenom, Date dateNaissance,
			@Valid String adresse, @Size(min = 10, max = 15) String telephone, @Email String mail, String Role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
		this.Role= Role;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Date getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public  UtilisateurBean(UtilisateurEntity e) {
		super();
		this.id = e.getId();
		this.Role=e.getRole();
		this.nom = e.getNom();
		this.prenom = e.getPrenom();
		this.dateNaissance =e.getDateNaissance();
		this.adresse = e.getAdresse();
		this.telephone = e.getTelephone();
		this.mail = e.getMail();
	}



	public UtilisateurBean() {
		
	}

	public static List <UtilisateurBean> toArray (List<UtilisateurEntity> utilisateurs) {
		List<UtilisateurBean> res = new ArrayList<>();
		for (UtilisateurEntity utilisateur : utilisateurs) {
			res.add(new UtilisateurBean(utilisateur));
		}
		return res;
	}
	
	public UtilisateurEntity convertToEntity(UtilisateurBean eb) {
		UtilisateurEntity conv = new UtilisateurEntity();
		conv.setId(eb.getId());
		conv.setNom(eb.getNom());
		conv.setPrenom(eb.getPrenom());
		conv.setDateNaissance(eb.getDateNaissance());
		conv.setAdresse(eb.getAdresse());
		conv.setTelephone(eb.getTelephone());
		conv.setMail(eb.getMail());
		conv.setRole(eb.getRole());
		
		return conv;
	}

}
