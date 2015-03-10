package br.com.cadei.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "frequencia")
public class Frequencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "seq_objref_frequencia", initialValue = 1, allocationSize = 1, name = "objref_frequencia")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_frequencia")
	private Integer objref;
	
	@Column
	private String janeiro;
	
	@Column
	private String fevereiro;
	
	@Column
	private String marco;
	
	@Column
	private String abril;
	
	@Column
	private String maio;
	
	@Column
	private String junho;
	
	@Column
	private String julho;
	
	@Column
	private String agosto;
	
	@Column
	private String setembro;
	
	@Column
	private String outubro;
	
	@Column
	private String novembro;
	
	@Column
	private String dezembro;
	
	public Frequencia(){
		
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref) {
		this.objref = objref;
	}

	public String getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(String janeiro) {
		this.janeiro = janeiro;
	}

	public String getFevereiro() {
		return fevereiro;
	}

	public void setFevereiro(String fevereiro) {
		this.fevereiro = fevereiro;
	}

	public String getMarco() {
		return marco;
	}

	public void setMarco(String marco) {
		this.marco = marco;
	}

	public String getAbril() {
		return abril;
	}

	public void setAbril(String abril) {
		this.abril = abril;
	}

	public String getMaio() {
		return maio;
	}

	public void setMaio(String maio) {
		this.maio = maio;
	}

	public String getJunho() {
		return junho;
	}

	public void setJunho(String junho) {
		this.junho = junho;
	}

	public String getJulho() {
		return julho;
	}

	public void setJulho(String julho) {
		this.julho = julho;
	}

	public String getAgosto() {
		return agosto;
	}

	public void setAgosto(String agosto) {
		this.agosto = agosto;
	}

	public String getSetembro() {
		return setembro;
	}

	public void setSetembro(String setembro) {
		this.setembro = setembro;
	}

	public String getOutubro() {
		return outubro;
	}

	public void setOutubro(String outubro) {
		this.outubro = outubro;
	}

	public String getNovembro() {
		return novembro;
	}

	public void setNovembro(String novembro) {
		this.novembro = novembro;
	}

	public String getDezembro() {
		return dezembro;
	}

	public void setDezembro(String dezembro) {
		this.dezembro = dezembro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

}
