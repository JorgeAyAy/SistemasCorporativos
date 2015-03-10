package br.com.cadei.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity(name = "folha")
public class Folha implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "seq_objref_folha", initialValue = 1, allocationSize = 1, name = "objref_folha")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_folha")
	private Integer objref;
	
	@OneToOne
	private Frequencia frequencia;
	
	@OneToOne
	private Aprendizagem aprendizagem;
	
	public Folha(Integer objref) {
		super();
		this.objref = objref;
	}
	
	public Folha(){
		
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref) {
		this.objref = objref;
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
	
	

	
	
}
