package br.com.cadei.bean;

import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.hibernate.engine.SessionFactoryImplementor;
import org.primefaces.model.chart.PieChartModel;

import br.com.cadei.dao.ClassDao;
import br.com.cadei.dao.HibernateUtil;
import br.com.cadei.entidade.Aluno;
import br.com.cadei.entidade.Aprendizagem;
import br.com.cadei.entidade.Constantes;
import br.com.cadei.entidade.Folha;
import br.com.cadei.entidade.Frequencia;
import br.com.cadei.entidade.Registros;

@ManagedBean(name = "beanaluno")
@SessionScoped
public class AlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Aluno aluno = new Aluno();
	private List<Aluno> alunoList;
	private ClassDao<Aluno> daoAluno;
	private ClassDao<Folha> daoFolha;
	private int tipoConsulta;
	private String campo;
	private Folha folha; //MODIFICADO
	private String pesAluno;
	private Constantes constantes = new Constantes();
	private FolhaBean beanFolha = new FolhaBean();

	public FolhaBean getBeanFolha() {
		return beanFolha;
	}

	public void setBeanFolha(FolhaBean beanFolha) {
		this.beanFolha = beanFolha;
	}

	public AlunoBean() {
		daoAluno = new ClassDao<Aluno>(Aluno.class);
		daoFolha = new ClassDao<Folha>(Folha.class);
	}
	
	public void popularList(){
		alunoList = daoAluno.findAll();
	}
	
	public String imprimirSalvar() {

		try {
			Connection con = ((SessionFactoryImplementor) HibernateUtil
					.getSessionFactory()).getConnectionProvider()
					.getConnection();
			String arquivo = FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRealPath("relatorios/report1.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(arquivo);
			Map<String, Integer> parameters = new HashMap<String, Integer>();
			parameters.put("cod_aluno", aluno.getObjref());
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
			HttpServletResponse res = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			res.setContentType("application/pdf");
			OutputStream out = res.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jp, out);
			out.flush();
			out.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}
	
	public String imprimirBackup() {

		try {
			Connection con = ((SessionFactoryImplementor) HibernateUtil
					.getSessionFactory()).getConnectionProvider()
					.getConnection();
			String arquivo = FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRealPath("relatorios/report2.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(arquivo);
			Map<String, Integer> parameters = new HashMap<String, Integer>();
			parameters.put("cod_aluno", aluno.getObjref());
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
			HttpServletResponse res = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			res.setContentType("application/pdf");
			OutputStream out = res.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jp, out);
			out.flush();
			out.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}
	
	public String editarFolha(){
		
		beanFolha.setAprendizagem(aluno.getFolha().getAprendizagem());
		beanFolha.setFrequencia(aluno.getFolha().getFrequencia());
		beanFolha.setFolha(aluno.getFolha());
		return beanFolha.editar();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunoList() {
		return alunoList;
	}

	public String editar() {

		return "cadastrofolhaaluno?faces-redirect=true";

	}
	
	public String criarGrafico(){
		createPieModels();
		return "graficofrequencia?faces-redirect=true";
	}

	public String limpar() {
		aluno = new Aluno();
		return null;
	}

	public String novo() {
		this.aluno = new Aluno();
		return "cadastrofolhaaluno?faces-redirect=true";
	}

	public void setAlunoList(List<Aluno> alunoList) {
		this.alunoList = alunoList;
	}

	public ClassDao<Aluno> getDaoAluno() {
		return daoAluno;
	}

	public void setDaoAluno(ClassDao<Aluno> daoAluno) {
		this.daoAluno = daoAluno;
	}

	public int getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(int tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Folha getFolha() {
		return folha;
	}

	public void setFolha(Folha folha) {
		this.folha = folha;
	}

	public String getPesAluno() {
		return pesAluno;
	}

	public void setPesAluno(String pesAluno) {
		this.pesAluno = pesAluno;
	}

	public String selecionado() {
		System.out.println("<<<<<<<<<<<<<<<<<<<" + aluno.getNome()
				+ ">>>>>>>>>>>>>.");

		return null;
	}

	public String salvar() {

		FacesContext fc = FacesContext.getCurrentInstance();
		
		folha = new Folha();
		
		ClassDao<Aprendizagem> daoAprendizagem = new ClassDao<Aprendizagem>(Aprendizagem.class);
		Aprendizagem a = new Aprendizagem();
		daoAprendizagem.save(a);
		
		ClassDao<Frequencia> daoFrequencia = new ClassDao<Frequencia>(Frequencia.class);
		Frequencia f = new Frequencia();
		daoFrequencia.save(f);
 		
		this.folha.setAprendizagem(a);
		this.folha.setFrequencia(f);
		this.aluno.setFolha(folha); //MODIFICADO
		this.daoFolha.save(folha);
		
		
		if (aluno.getObjref() != 0) {
			try {
				daoAluno.update(aluno);
				novo();
				fc.addMessage("home", new FacesMessage(
						"Aluno Salvo com sucesso!!!"));
				aluno = new Aluno();
				alunoList = daoAluno.findAll();
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
			daoAluno.create(aluno);
			novo();
			fc.addMessage("home", new FacesMessage(
					"Aluno Salvo com sucesso!!!"));
			aluno = new Aluno();
			alunoList = daoAluno.findAll();
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

	public String delete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			HibernateUtil.getSessionFactory().getCurrentSession().evict(aluno);

			aluno = daoAluno.findByCod(aluno.getObjref());
			daoAluno.delete(aluno);
			fc.addMessage("home", new FacesMessage(
					"Aluno Deletado com sucesso!!!"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		findAluno();
		return null;
	}

	@SuppressWarnings("unchecked")
	public String findAluno() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if (campo == "objref") {
				Integer pesAluno1 = Integer.parseInt(pesAluno);
				alunoList = (ArrayList<Aluno>) daoAluno.consultaByTipoCriteria(
						0, null, tipoConsulta, campo, pesAluno1).list();
				return null;
			}
			alunoList = (ArrayList<Aluno>) daoAluno.consultaByTipoCriteria(0,
					null, tipoConsulta, campo, pesAluno).list();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		return null;

	}
	

	//*CRIAR GR�FICOS*//
	
    private PieChartModel graficofrequencia;
     
    public PieChartModel getPieModel2() {
        return graficofrequencia;
    }
     
    private void createPieModels() {
        createPieModel2();
    }
 
    private void createPieModel2() {
    	graficofrequencia = new PieChartModel();
    	
//    	aluno.getFolha().setFrequencia(folha.getFrequencia());
    	
//    	graficofrequencia.set("Janeiro", Integer.parseInt(aluno.getFolha().getFrequencia().getJaneiro()));
    	graficofrequencia.set("Janeiro", Integer.parseInt(this.aluno.getFolha().getFrequencia().getJaneiro()));
    	graficofrequencia.set("Fevereiro", Integer.parseInt(this.aluno.getFolha().getFrequencia().getFevereiro()));
    	graficofrequencia.set("Marco", Integer.parseInt(this.aluno.getFolha().getFrequencia().getMarco()));
    	graficofrequencia.set("Abril", Integer.parseInt(this.aluno.getFolha().getFrequencia().getAbril()));
    	graficofrequencia.set("Maio", Integer.parseInt(this.aluno.getFolha().getFrequencia().getMaio()));
    	graficofrequencia.set("Junho", Integer.parseInt(this.aluno.getFolha().getFrequencia().getJunho()));
    	graficofrequencia.set("Julho", Integer.parseInt(this.aluno.getFolha().getFrequencia().getJulho()));
    	graficofrequencia.set("Agosto", Integer.parseInt(this.aluno.getFolha().getFrequencia().getAgosto()));
    	graficofrequencia.set("Setembro", Integer.parseInt(this.aluno.getFolha().getFrequencia().getSetembro()));
    	graficofrequencia.set("Outubro", Integer.parseInt(this.aluno.getFolha().getFrequencia().getOutubro()));
    	graficofrequencia.set("Novembro", Integer.parseInt(this.aluno.getFolha().getFrequencia().getNovembro()));
    	graficofrequencia.set("Dezembro", Integer.parseInt(this.aluno.getFolha().getFrequencia().getDezembro()));
         
    	graficofrequencia.setTitle("Grafico de frequencias");
    	graficofrequencia.setLegendPosition("e");
    	graficofrequencia.setFill(false);
    	graficofrequencia.setShowDataLabels(true);
    	graficofrequencia.setDiameter(200);
    }

}
