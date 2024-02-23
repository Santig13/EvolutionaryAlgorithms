package prueba;
import javax.swing.*;
import org.math.plot.*;

public class nueva {
	
	 public static void main(String[] args) {
	  // define your data
		 int i=2;
	  double[] x = { 1,2, 3, 4, 5, 6 };
	  double[] y = { 45, 89, 6, 32, 63, 12 };
	  double[] y2 = { 20, 60, 20, 40, 10, 20 };
	  // create your PlotPanel (you can use it as a JPanel)
	  Plot2DPanel plot = new Plot2DPanel();
	  // define the legend position
	  plot.addLegend("SOUTH");
	  // add a line plot to the PlotPanel
	  plot.addLinePlot("my plot", x, y);
	  plot.addLinePlot("hola", y2);
	  // put the PlotPanel in a JFrame like a JPanel
	  JFrame frame = new JFrame("a plot panel");
	  frame.setSize(600, 600);
	 
	  JPanel panel=new JPanel();
	  panel.add(plot);
	  frame.setVisible(true);
		JButton ButtonEjecutar = new JButton("Ejectutar");
		ButtonEjecutar.addActionListener(e -> {
            // Manejar la acción del botón aquí
            plot.removeAllPlots();
            plot.repaint();
        });
	 
	  panel.add(ButtonEjecutar);
	  frame.setContentPane(panel);
	 }
 
}
