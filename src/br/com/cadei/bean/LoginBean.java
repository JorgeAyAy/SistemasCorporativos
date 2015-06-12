package br.com.cadei.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cadei.entidade.Professor;

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
	private Professor prof = new Professor();

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
				HttpSession session = SessionBean.getSession();
	            session.setAttribute("nome", login);
				return "index";
			}
		}
		return null;
	}
	
	public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
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

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	

}
