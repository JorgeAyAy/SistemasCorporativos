package br.com.cadei.grafico;

import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import br.com.cadei.entidade.Aluno;
import br.com.cadei.entidade.Aprendizagem;
import br.com.cadei.entidade.Folha;
import br.com.cadei.entidade.Frequencia;
 
@ManagedBean(name = "graficobean")
@SessionScoped
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1;
    private PieChartModel pieModel2;
       

	@PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
         
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        pieModel2.set("Janeiro", 840);
        pieModel2.set("Fevereiro", 325);
        pieModel2.set("Marco", 702);
        pieModel2.set("Abril", 421);
        pieModel2.set("Maio", 540);
        pieModel2.set("Junho", 999);
        pieModel2.set("Julho", 623);
        pieModel2.set("Agosto", 121);
        pieModel2.set("Setembro", 340);
        pieModel2.set("Outubro", 335);
        pieModel2.set("Novembro", 402);
        pieModel2.set("Dezembro", 821);
         
        pieModel2.setTitle("Grafico de frequencias");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(200);
    }
     
}