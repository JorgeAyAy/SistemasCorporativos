package br.com.cadei.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "registros")
public class Registros implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "seq_objref_registro", initialValue = 1, allocationSize = 1, name = "objref_registro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_registro")
	private Integer objref;
	
	@Column
	private String numeroAula;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column
	private String descricao;
	
	public Registros(){
		
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref_registro) {
		this.objref = objref_registro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(String numeroAula) {
		this.numeroAula = numeroAula;
	}

	
}
