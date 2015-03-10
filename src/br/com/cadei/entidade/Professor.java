package br.com.cadei.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "professor")
public class Professor implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName = "seq_objref_professor", initialValue = 1, allocationSize = 1, name = "objref_professor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_professor")
	private Integer objref;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private String turma;

	public Professor(Integer objref, String nome, String email, String senha, String turma) {
		super();
		this.objref = objref;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.turma = turma;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor() {
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref) {
		this.objref = objref;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setCpf(String senha) {
		this.senha = senha;
	}
	
	
	
}
