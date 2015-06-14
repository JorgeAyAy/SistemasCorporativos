package br.com.cadei.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "seq_objref_aluno", initialValue = 1, allocationSize = 1, name = "objref_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_aluno")
	private Integer objref;

	@Column
	private String nome;

	@Column
	private Long nis;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column
	private Long matricula;

	@Column
	private boolean bolsaFamilia;

	@OneToOne
	private Folha folha;
	
	@Column
	private byte[] imagem;
	
	@Column
	private String nomeArquivo;

	public Aluno(Integer objref, String nome, Long nis,
			Date dataNascimento, Long matricula, boolean bolsaFamilia, byte[] imagem, String nomeArquivo) {
		super();
		this.objref = objref;
		this.nome = nome;
		this.nis = nis;
		this.matricula = matricula;
		this.bolsaFamilia = bolsaFamilia;
		this.dataNascimento = dataNascimento;
		this.imagem = imagem;
		this.nomeArquivo = nomeArquivo;
	}
	
	public Aluno(){
		
	}

	

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objrefaluno) {
		this.objref = objrefaluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNis() {
		return nis;
	}

	public void setNis(Long nis) {
		this.nis = nis;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public boolean isBolsaFamilia() {
		return bolsaFamilia;
	}

	public void setBolsaFamilia(boolean bolsaFamilia) {
		this.bolsaFamilia = bolsaFamilia;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Folha getFolha() {
		return folha;
	}

	public void setFolha(Folha folha) {
		this.folha = folha;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
}