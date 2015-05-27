package br.com.cadei.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private ProfessorBeanIF professor = new ProfessorBean();

	public LoginBean() {

	}

	public String logar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		if (this.getLogin().isEmpty() || this.getSenha().isEmpty()) {
			fc.addMessage("login", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Digite o login e/ou a senha.", null));
		} 
		
		else {

			if (professor.validarSenhaProfessor(this.getLogin(),
					this.getSenha())) {
				return "index?faces-redirect=true";
			}
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
