package br.com.cadei.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import br.com.cadei.entidade.Aluno;


@Entity(name = "aluno")
public class Turma {
	
	@Id
	@SequenceGenerator(sequenceName = "seq_objref_turma", initialValue = 1, allocationSize = 1, name = "objref_turma")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_turma")
	private Integer objref;
	
	@ManyToMany
	@JoinTable(name="turma_aluno",joinColumns={@JoinColumn(name="objref_turma")},inverseJoinColumns={@JoinColumn(name="objref_aluno")})
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Turma(Integer objref, List<Aluno> alunos) {
		super();
		this.objref = objref;
		this.alunos = alunos;
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref) {
		this.objref = objref;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	

}
