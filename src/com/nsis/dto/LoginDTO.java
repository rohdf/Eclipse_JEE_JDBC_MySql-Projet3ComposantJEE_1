package com.nsis.dto;

import com.nsis.bo.LoginBo;

public class LoginDTO {
	 private String login, password;       

	 public LoginDTO(){      
	  this.login = "anonyme";      
	  this.password = "default";   
	 }    

	 public LoginDTO(LoginBo login) {
		setLogin(login.getIdentifiant());
		setPassword(login.getMotDePasse());
	}

	public String getLogin() {      
	  return login;   
	 }    

	 public void setLogin(String login) {      
	  this.login = login;   
	 }    

	 public String getPassword() {      
	  return password;   
	 }    

	 public void setPassword(String password) {    
	  this.password = password;   
	 }
}
