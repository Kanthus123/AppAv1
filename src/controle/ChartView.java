package controle;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
	
	private static final long serialVersionUID = -1430254026613783355L;
	
    private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
   
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Lançamentos Durante os Anos por Genero");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries acao = new ChartSeries();
        acao.setLabel("Açao");
        acao.set("2012", 12);
        acao.set("2013", 10);
        acao.set("2014", 4);
        acao.set("2015", 15);
        acao.set("2016", 2);
 
        ChartSeries animacao = new ChartSeries();
        animacao.setLabel("Animaçao");
        animacao.set("2012", 5);
        animacao.set("2013", 6);
        animacao.set("2014", 11);
        animacao.set("2015", 13);
        animacao.set("2016", 12);
        
        ChartSeries aventura = new ChartSeries();
        aventura.setLabel("Aventura");
        aventura.set("2012", 5);
        aventura.set("2013", 7);
        aventura.set("2014", 11);
        aventura.set("2015", 31);
        aventura.set("2016", 21);
        
        ChartSeries biografia = new ChartSeries();
        biografia.setLabel("Biografia");
        biografia.set("2012", 2);
        biografia.set("2013", 8);
        biografia.set("2014", 10);
        biografia.set("2015", 35);
        biografia.set("2016", 20);
        
        ChartSeries comedia = new ChartSeries();
        comedia.setLabel("Comedia");
        comedia.set("2012", 5);
        comedia.set("2013", 20);
        comedia.set("2014", 9);
        comedia.set("2015", 15);
        comedia.set("2016", 10);
        
        ChartSeries drama = new ChartSeries();
        drama.setLabel("Drama");
        drama.set("2012", 20);
        drama.set("2013", 3);
        drama.set("2014", 9);
        drama.set("2015", 2);
        drama.set("2016", 7);
        
        ChartSeries terror = new ChartSeries();
        terror.setLabel("Terror");
        terror.set("2012", 22);
        terror.set("2013", 10);
        terror.set("2014", 11);
        terror.set("2015", 13);
        terror.set("2016", 12);
        
        model.addSeries(acao);
        model.addSeries(animacao);
        model.addSeries(aventura);
        model.addSeries(biografia);
        model.addSeries(comedia);
        model.addSeries(drama);
        model.addSeries(terror);
        
        return model;
    }
    
}