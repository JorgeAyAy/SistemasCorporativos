package br.com.cadei.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import br.com.cadei.dao.ClassDao;
import br.com.cadei.dao.HibernateUtil;
import br.com.cadei.entidade.Constantes;
import br.com.cadei.entidade.Registros;

@ManagedBean(name = "registroBean")
@SessionScoped
public class RegistrosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Registros registro = new Registros();
	private ArrayList<Registros> registroList;
	private ClassDao<Registros> daoRegistro;
	private int tipoConsulta;
	private String campo;
	private String pesRegistro;
	private Constantes constantes = new Constantes();

	public RegistrosBean() {
		daoRegistro = new ClassDao<Registros>(Registros.class);
	}

	public void popularList() {
		registroList = (ArrayList<Registros>) daoRegistro.findAll();
	}

	public String editar() {

		return "registro?faces-redirect=true";

	}

	public String limpar() {
		registro = new Registros();
		return null;
	}

	public String novo() {
		this.registro = new Registros();
		return "registro?faces-redirect=true";
	}

	public Registros getRegistro() {
		return registro;
	}

	public void setRegistro(Registros registro) {
		this.registro = registro;
	}

	public List<Registros> getRegistroList() {
		return registroList;
	}

	public void setRegistroList(ArrayList<Registros> registroList) {
		this.registroList = registroList;
	}

	public ClassDao<Registros> getDaoRegistro() {
		return daoRegistro;
	}

	public void setDaoRegistro(ClassDao<Registros> daoRegistro) {
		this.daoRegistro = daoRegistro;
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

	public String getPesRegistro() {
		return pesRegistro;
	}

	public void setPesRegistro(String pesRegistro) {
		this.pesRegistro = pesRegistro;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public String selecionado() {
		System.out.println("<<<<<<<<<<<<<<<<<<<" + registro.getNumeroAula()
				+ ">>>>>>>>>>>>>.");

		return null;
	}

	public String salvar() {

		FacesContext fc = FacesContext.getCurrentInstance();

		if (registro.getObjref() != 0) {
			try {
				this.daoRegistro.update(registro);
				novo();
				fc.addMessage("home", new FacesMessage(
						"Registro Editado com sucesso!!!"));
				this.registro = new Registros();
				this.registroList = (ArrayList<Registros>) this.daoRegistro
						.findAll();
				novo();
			} catch (Exception e) {
				e.printStackTrace();
				FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"ERROR", e.getMessage());
				fc.addMessage(null, ms);
				return null;
			}
		} else {
			try {
				daoRegistro.create(registro);
				novo();
				fc.addMessage("home", new FacesMessage(
						"Registro Salvo com sucesso!!!"));
				registro = new Registros();
				registroList = (ArrayList<Registros>) daoRegistro.findAll();
				novo();
			} catch (Exception e) {
				e.printStackTrace();
				FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"ERROR", e.getMessage());
				fc.addMessage(null, ms);
				return null;
			}
		}

		return "listaregistro?faces-redirect=true";
	}

	public String delete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			HibernateUtil.getSessionFactory().getCurrentSession()
					.evict(registro);

			registro = daoRegistro.findByCod(registro.getObjref());
			daoRegistro.delete(registro);
			fc.addMessage("consultaProfessor", new FacesMessage(
					"Registro Deletado com sucesso!!!"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		findRegistro();
		return "listaregistro?faces-redirect=true";
	}

	@SuppressWarnings("unchecked")
	public String findRegistro() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if (campo == "objref") {
				Integer pesRegistro1 = Integer.parseInt(pesRegistro);
				registroList = (ArrayList<Registros>) daoRegistro
						.consultaByTipoCriteria(0, null, tipoConsulta, campo,
								pesRegistro1).list();
				return null;
			}
			registroList = (ArrayList<Registros>) daoRegistro
					.consultaByTipoCriteria(0, null, tipoConsulta, campo,
							pesRegistro).list();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		return null;

	}

	public void onTabChange(TabChangeEvent event) {
		FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: "
				+ event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onTabClose(TabCloseEvent event) {
		FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: "
				+ event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
