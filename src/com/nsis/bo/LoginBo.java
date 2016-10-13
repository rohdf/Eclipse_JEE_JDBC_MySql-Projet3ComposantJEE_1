package com.nsis.bo;

import java.io.Serializable;

public class LoginBo implements Serializable{
	private static final long serialVersionUID = 8195721969125471403L;
	
	private String identifiant;
	private String motDePasse;
	
	public LoginBo(String identifiant, String motDePasse) {
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}
	
	public LoginBo() {

	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	
}
