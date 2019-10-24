package com.formation.webapp.pojo;


import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;
import com.formation.webapp.beans.LoginEntity;


public class LoginPojo {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nom;
	@Size(min = 2, max = 255)
	private String societe;
	
	
	

	
	public LoginPojo(Long id, String nom, @Size(min = 2, max = 255) String societe) {
		super();
		this.id = id;
		this.nom = nom;
		this.societe = societe;
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



	public  LoginPojo(LoginEntity e) {
		super();
		this.id = e.getId();
		this.societe=e.getSociete();
		this.nom = e.getNom();
	}



	public LoginPojo() {
		
	}

	public static List <LoginPojo> toArray (List<LoginEntity> logins) {
		List<LoginPojo> res = new ArrayList<>();
		for (LoginEntity login : logins) {
			res.add(new LoginPojo(login));
		}
		return res;
	}
	
	public LoginEntity convertToEntity(LoginPojo eb) {
		LoginEntity conv = new LoginEntity();
		conv.setId(eb.getId());
		conv.setNom(eb.getNom());
		conv.setSociete(eb.getSociete());
	
		
		return conv;
	}

}


