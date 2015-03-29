package br.com.cadei.bean;

import java.io.Serializable;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	private ProfessorBeanIF professor = new ProfessorBean();
	

	public LoginBean(){
		
	}
	
	public String logar(){
		if(this.login == null){
			return "index?faces-redirect=true";
		}
		 if(professor.validarSenhaProfessor(this.getLogin(), this.getSenha())){
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
