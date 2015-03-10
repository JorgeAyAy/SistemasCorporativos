package br.com.cadei.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.PieChartModel;

import br.com.cadei.dao.ClassDao;
import br.com.cadei.entidade.Aluno;
import br.com.cadei.entidade.Aprendizagem;
import br.com.cadei.entidade.Folha;
import br.com.cadei.entidade.Frequencia;

@ManagedBean(name = "folhaBean")
@SessionScoped
public class FolhaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Frequencia frequencia = new Frequencia();
	Aprendizagem aprendizagem = new Aprendizagem();
	Aluno aluno = new Aluno();
	Folha folha = new Folha();
	private List<Folha> folhaList;
	private ClassDao<Folha> daoFolha;
	private ClassDao<Aluno> daoAluno;
	private ClassDao<Aprendizagem> daoAprendizagem;
	private ClassDao<Frequencia> daoFrequencia;
	private String campo;
	private List<Aprendizagem> aprendizagens;
	private List<Frequencia> frequencias;
	private String teste;
	

	public FolhaBean() {
		daoFolha = new ClassDao<Folha>(Folha.class);
		daoAprendizagem = new ClassDao<Aprendizagem>(Aprendizagem.class);
		daoFrequencia = new ClassDao<Frequencia>(Frequencia.class);
	}

	public void popularList() {
		folhaList = daoFolha.findAll();
	}

	public String editar() {
		
		return "folhaaluno?faces-redirect=true";

	}
	
	
	public ClassDao<Aprendizagem> getDaoAprendizagem() {
		return daoAprendizagem;
	}

	public void setDaoAprendizagem(ClassDao<Aprendizagem> daoAprendizagem) {
		this.daoAprendizagem = daoAprendizagem;
	}

	public ClassDao<Frequencia> getDaoFrequencia() {
		return daoFrequencia;
	}

	public void setDaoFrequencia(ClassDao<Frequencia> daoFrequencia) {
		this.daoFrequencia = daoFrequencia;
	}
	
	
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ClassDao<Aluno> getDaoAluno() {
		return daoAluno;
	}

	public void setDaoAluno(ClassDao<Aluno> daoAluno) {
		this.daoAluno = daoAluno;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public String limpar() {
		folha = new Folha();
		return null;
	}

	public String novo() {
		this.folha = new Folha();
		this.frequencia = new Frequencia();
		this.aprendizagem = new Aprendizagem();
		return "folhaaluno?faces-redirect=true";
	}

	public String selecionado() {
		System.out.println("<<<<<<<<<<<<<<<<<<<" + folha.getObjref()
				+ ">>>>>>>>>>>>>.");

		return null;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public Aprendizagem getAprendizagem() {
		return aprendizagem;
	}

	public void setAprendizagem(Aprendizagem aprendizagem) {
		this.aprendizagem = aprendizagem;
	}

	public List<Folha> getFolhaList() {
		return folhaList;
	}

	public void setFolhaList(List<Folha> folhaList) {
		this.folhaList = folhaList;
	}

	public Folha getFolha() {
		return folha;
	}

	public List<Aprendizagem> getAprendizagens() {
		return aprendizagens;
	}

	public void setAprendizagens(List<Aprendizagem> aprendizagens) {
		this.aprendizagens = aprendizagens;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public void setFolha(Folha folha) {
		this.folha = folha;
	}

	public ClassDao<Folha> getDaoFolha() {
		return daoFolha;
	}

	public void setDaoFolha(ClassDao<Folha> daoFolha) {
		this.daoFolha = daoFolha;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String salvar() {

		FacesContext fc = FacesContext.getCurrentInstance();
		
		this.aluno = new Aluno();
		this.frequencia = new Frequencia();
		this.aprendizagem = new Aprendizagem();
 		
//		this.folha.setAprendizagem(this.aprendizagem);
//		this.folha.setFrequencia(this.frequencia);
		
		
		if (folha.getObjref() != 0) {
			try {
				daoFolha.update(folha);
				daoAprendizagem.update(this.folha.getAprendizagem());
				daoFrequencia.update(this.folha.getFrequencia());
				novo();
				fc.addMessage("home", new FacesMessage(
						"Folha Salvo com sucesso!!!"));
				this.folha = new Folha();
				folhaList = daoFolha.findAll();
				novo();
			} catch (Exception e) {
				e.printStackTrace();
				FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"ERROR", e.getMessage());
				fc.addMessage(null, ms);
				return null;
			}

		}

		try {
			daoFolha.create(this.folha);
			novo();
			fc.addMessage("home",
					new FacesMessage("Folha Salvo com sucesso!!!"));
			folha = new Folha();
			folhaList = daoFolha.findAll();
			novo();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERROR", e.getMessage());
			fc.addMessage(null, ms);
			return null;
		}

		return "home";
	}

}
