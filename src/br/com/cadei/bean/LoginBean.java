package br.com.cadei.bean;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login, senha;
	private ProfessorBeanIF professor = new ProfessorBean();
	

	public LoginBean(){
		
	}
	
	public String logar(){
		if(this.login == null){
			return "index?faces-redirect=true";
		}
		else if(professor.validarSenhaProfessor(this.login, this.senha)){
			return "index?faces-redirect=true";
		}
		return null;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public ProfessorBeanIF getProfessor() {
		return professor;
	}


	public void setProfessor(ProfessorBeanIF professor) {
		this.professor = professor;
	}
	
}
