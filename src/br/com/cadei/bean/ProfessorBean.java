package br.com.cadei.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.cadei.dao.ClassDao;
import br.com.cadei.dao.HibernateUtil;
import br.com.cadei.entidade.Constantes;
import br.com.cadei.entidade.Professor;

@ManagedBean(name="beanprofessor")
@SessionScoped
public class ProfessorBean implements Serializable, ProfessorBeanIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor = new Professor();
	private List<Professor> professorList;
	private ClassDao<Professor> dao;		
	private int tipoConsulta;
	private String campo;
	private String pesProfessor;
	private Constantes constantes = new Constantes();
	private String turma;
	private String resenha;
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ProfessorBean() {
		dao = new ClassDao<Professor>(Professor.class);			

	}
	
	public String editar()
	{
		return "editarProfessor?faces-redirect=true";
	}

	public int getTipoConsulta() {
		return tipoConsulta;
	}



	public void setTipoConsulta(int tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}


	public String getCampo() {
		return campo;
	}



	public void setCampo(String campo) {
		this.campo = campo;
	}


	public String getPesProfessor() {
		return pesProfessor;
	}


	public void setPesProfessor(String pesProfessor) {
		this.pesProfessor = pesProfessor;
	}



	public Professor getMembro() {
		return professor;
	}


	public void setMembro(Professor professor) {
		this.professor = professor;
	}


	public List<Professor> getProfessorList() {
			return professorList;
		
	}


	public void setProfessorList(List<Professor> membroList) {
		this.professorList = membroList;
	}


	public String limpar(){
		professor = new Professor();
		return null;
	}
	
	public String selecionado(){
		System.out.println("<<<<<<<<<<<<<<<<<<<"+professor.getNome()+">>>>>>>>>>>>>.");

		return null;
	}	

	public String novo()
	{
		this.professor = new Professor();
		return "cadastroProfessor?faces-redirect=true";
	}

	public String salvar(){
	

		FacesContext fc = FacesContext.getCurrentInstance();
	
		this.professor.setTurma(turma);
		if(validarSenha()){
			if(professor.getObjref()!=0){
				try{
					dao.update(professor);
					novo();
					fc.addMessage("editarProfessor", new FacesMessage("Professor Editado com sucesso!!!"));
					professor = new Professor();
					professorList = dao.findAll();
					novo();
				}catch(Exception e){
					e.printStackTrace();
					FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
					fc.addMessage(null, ms);
				}
				
			return null;
			
		}
		
			try{
				dao.create(professor);
				novo();
				fc.addMessage("cadastroProfessor", new FacesMessage("Professor Salvo com sucesso!!!"));
				professor = new Professor();
				professorList = dao.findAll();
				novo();
				
			}catch(Exception e){
				e.printStackTrace();
				FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
				fc.addMessage(null, ms);
			}
		}else{
			fc.addMessage("cadastroProfessor", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas n��o conferem.", null));
		}
		
			return "login?faces-redirect=true";
	}
	
	private boolean validarSenha() {
		if(this.resenha.equals(this.professor.getSenha())){
			return true;
		}
		return false;
	}

	public String delete(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			
			HibernateUtil.getSessionFactory().getCurrentSession().evict(professor);
			
			professor = dao.findByCod(professor.getObjref());	
			dao.delete(professor);
			fc.addMessage("consultaProfessor", new FacesMessage("Professor Deletado com sucesso!!!"));
		}catch(Exception e){
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		findProfessor();
		return null;
	}	



	@SuppressWarnings("unchecked")
	public String findProfessor(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if(campo =="objref")
			{ 
				Integer pesProfessor1 =   Integer.parseInt(pesProfessor); 
				professorList  = (ArrayList<Professor>)	dao.consultaByTipoCriteria(0, null, tipoConsulta, campo, pesProfessor1).list();
				return null;
			}		
			professorList  = 	(ArrayList<Professor>) dao.consultaByTipoCriteria(0, null, tipoConsulta, campo, pesProfessor).list();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
			fc.addMessage(null, ms);
			}
		return null;
	

	}

	public ClassDao<Professor> getDao() {
		return dao;
	}

	public void setDao(ClassDao<Professor> dao) {
		this.dao = dao;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getResenha() {
		return resenha;
	}

	public void setResenha(String resenha) {
		this.resenha = resenha;
	}

	@Override
	public boolean validarSenhaProfessor(String nomeProfessor, String senha) {
		FacesContext fc = FacesContext.getCurrentInstance();
//		if(nomeProfessor.isEmpty() && senha.isEmpty()){
//			fc.addMessage("login", new FacesMessage("Digite: login e senha."));
//			return false;
//		}
		List<Professor> professores = this.dao.findAll();
		for(int i =  0; i < professores.size(); i++){
			
			if(professores.get(i).getNome().equals(nomeProfessor) && (professores.get(i).getSenha().equals(senha))){
				fc.addMessage("login", new FacesMessage("Logado!"));
				return true;
			}
		}
		fc.addMessage("login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválido.", null));
		return false;
	}
	
	


}
