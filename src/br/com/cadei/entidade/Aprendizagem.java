package br.com.cadei.entidade;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "aprendizagem")
public class Aprendizagem {

	@Id
	@SequenceGenerator(sequenceName = "seq_objref_aprendizagem", initialValue = 1, allocationSize = 1, name = "objref_aprendizagem")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objref_aprendizagem")
	private Integer objref;

	@Column
	private String opcao1;

	@Column
	private String opcao2;

	@Column
	private String opcao3;

	@Column
	private String opcao4;

	@Column
	private String opcao5;

	@Column
	private String opcao6;

	@Column
	private String opcao7;

	@Column
	private String opcao8;

	@Column
	private String opcao9;

	@Column
	private String opcao10;

	@Column
	private String opcao11;

	@Column
	private String opcao12;

	@Column
	private String opcao13;

	@Column
	private String opcao14;

	@Column
	private String opcao15;

	@Column
	private String opcao16;

	@Column
	private String opcao17;

	@Column
	private String opcao18;

	@Column
	private String opcao19;

	@Column
	private String opcao20;

	public Aprendizagem() {

		this.opcao1 = "";
		this.opcao2 = "";
		this.opcao3 = "";
		this.opcao4 = "";
		this.opcao5 = "";
		this.opcao6 = "";
		this.opcao7 = "";
		this.opcao8 = "";
		this.opcao9 = "";
		this.opcao10 = "";
		this.opcao11 = "";
		this.opcao12 = "";
		this.opcao13 = "";
		this.opcao14 = "";
		this.opcao15 = "";
		this.opcao16 = "";
		this.opcao17 = "";
		this.opcao18 = "";
		this.opcao19 = "";
		this.opcao20 = "";
		
	}

	public Integer getObjref() {
		return objref;
	}

	public void setObjref(Integer objref) {
		this.objref = objref;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}

	public String getOpcao3() {
		return opcao3;
	}

	public void setOpcao3(String opcao3) {
		this.opcao3 = opcao3;
	}

	public String getOpcao4() {
		return opcao4;
	}

	public void setOpcao4(String opcao4) {
		this.opcao4 = opcao4;
	}

	public String getOpcao5() {
		return opcao5;
	}

	public void setOpcao5(String opcao5) {
		this.opcao5 = opcao5;
	}

	public String getOpcao6() {
		return opcao6;
	}

	public void setOpcao6(String opcao6) {
		this.opcao6 = opcao6;
	}

	public String getOpcao7() {
		return opcao7;
	}

	public void setOpcao7(String opcao7) {
		this.opcao7 = opcao7;
	}

	public String getOpcao8() {
		return opcao8;
	}

	public void setOpcao8(String opcao8) {
		this.opcao8 = opcao8;
	}

	public String getOpcao9() {
		return opcao9;
	}

	public void setOpcao9(String opcao9) {
		this.opcao9 = opcao9;
	}

	public String getOpcao10() {
		return opcao10;
	}

	public void setOpcao10(String opcao10) {
		this.opcao10 = opcao10;
	}

	public String getOpcao11() {
		return opcao11;
	}

	public void setOpcao11(String opcao11) {
		this.opcao11 = opcao11;
	}

	public String getOpcao12() {
		return opcao12;
	}

	public void setOpcao12(String opcao12) {
		this.opcao12 = opcao12;
	}

	public String getOpcao13() {
		return opcao13;
	}

	public void setOpcao13(String opcao13) {
		this.opcao13 = opcao13;
	}

	public String getOpcao14() {
		return opcao14;
	}

	public void setOpcao14(String opcao14) {
		this.opcao14 = opcao14;
	}

	public String getOpcao15() {
		return opcao15;
	}

	public void setOpcao15(String opcao15) {
		this.opcao15 = opcao15;
	}

	public String getOpcao16() {
		return opcao16;
	}

	public void setOpcao16(String opcao16) {
		this.opcao16 = opcao16;
	}

	public String getOpcao17() {
		return opcao17;
	}

	public void setOpcao17(String opcao17) {
		this.opcao17 = opcao17;
	}

	public String getOpcao18() {
		return opcao18;
	}

	public void setOpcao18(String opcao18) {
		this.opcao18 = opcao18;
	}

	public String getOpcao19() {
		return opcao19;
	}

	public void setOpcao19(String opcao19) {
		this.opcao19 = opcao19;
	}

	public String getOpcao20() {
		return opcao20;
	}

	public void setOpcao20(String opcao20) {
		this.opcao20 = opcao20;
	}

}
