package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;

import org.math.plot.Plot2DPanel;

import Controlador.Controller;
import Controlador.ControllerIMP;
import Controlador.TParametros;
import Controlador.TResultStatistics;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class MainWindowP2 extends JFrame implements GUI {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea solTXT;
	private JTextField TamGentextField;
	private JTextField nGentextField;
	private JTextField ProbCrucetextField;
	private JTextField ProbMutaciontextField;
	private JTextField ElitismotextField;
	private JTextField VuelostextField;
	private JTextField txtTeltxt;
	private Plot2DPanel plot;
	//private final String[] tiposDeFuncion=  {"vuelos1.txt", "vuelos2.txt"};
	private final String[] tiposDeCruzador= {"PMX", "OX", "OXPosPrio", "CX", "CO", "Propio"};
	private final String[] tiposDeMutador= { "Intercambio","Insercion", "Inversion", "Heuristica", "Propio"};
	private final String[] tiposDeSelector= {"Ruleta", "Estocastico", "Truncamiento", "Torneo Det", "Torneo Pro", "Restos", "Ranking"};
	
	JComboBox MutacioncomboBox;
	JComboBox CrucecomboBox;
	JComboBox SelecomboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowP2 frame = new MainWindowP2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindowP2() {
		Controller ctr=new ControllerIMP();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 100, 1433, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel SolPanel = new JPanel();
		SolPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SolPanel.setBackground(new Color(224, 224, 224));
		contentPane.add(SolPanel, BorderLayout.WEST);
		SolPanel.setLayout(new BoxLayout(SolPanel, BoxLayout.Y_AXIS));
		//SolPanel.setMaximumSize(new Dimension(700, 400));
		JLabel SolucionLabel = new JLabel("Solucion");
		SolPanel.add(SolucionLabel);
		
		solTXT = new JTextArea();
		
		solTXT.setColumns(10);
		JScrollPane scrollPane = new JScrollPane(solTXT);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        SolPanel.add(scrollPane);

        
		JButton EjecutarButton = new JButton("Ejecutar");
		SolPanel.add(EjecutarButton);
		
		JPanel ParametersPanel = new JPanel();
		ParametersPanel.setBackground(new Color(224, 224, 224));
		contentPane.add(ParametersPanel, BorderLayout.NORTH);
		ParametersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel VuelosLabel = new JLabel("Vuelos");
		ParametersPanel.add(VuelosLabel);
		
		VuelostextField = new JTextField();
		VuelostextField.setText("vuelos1.txt");
		ParametersPanel.add(VuelostextField);
		VuelostextField.setColumns(8);
		
		JLabel TELLabel = new JLabel("TEL");
		ParametersPanel.add(TELLabel);
		
		txtTeltxt = new JTextField();
		txtTeltxt.setText("TEL1.txt");
		ParametersPanel.add(txtTeltxt);
		txtTeltxt.setColumns(6);
		
		JLabel TamGenLabel = new JLabel("Tam Generaci\u00F3n");
		ParametersPanel.add(TamGenLabel);
		
		TamGentextField = new JTextField();
		TamGentextField.setText("100");
		ParametersPanel.add(TamGentextField);
		TamGentextField.setColumns(3);
		
		JLabel nGenLabel = new JLabel("n\u00BAGeneraciones");
		ParametersPanel.add(nGenLabel);
		
		nGentextField = new JTextField();
		nGentextField.setText("400");
		ParametersPanel.add(nGentextField);
		nGentextField.setColumns(3);
		
		JLabel ProbCruceLabel = new JLabel("% Cruce");
		ParametersPanel.add(ProbCruceLabel);
		
		ProbCrucetextField = new JTextField();
		ProbCrucetextField.setText("50");
		ParametersPanel.add(ProbCrucetextField);
		ProbCrucetextField.setColumns(2);
		
		JLabel ProbMutacionLabel = new JLabel("% Mutacion");
		ParametersPanel.add(ProbMutacionLabel);
		
		ProbMutaciontextField = new JTextField();
		ProbMutaciontextField.setText("10");
		ParametersPanel.add(ProbMutaciontextField);
		ProbMutaciontextField.setColumns(2);
		
		JLabel SelecLabel = new JLabel("Seleccion");
		ParametersPanel.add(SelecLabel);
		
		SelecomboBox = new JComboBox();
		SelecomboBox.setModel(new DefaultComboBoxModel(tiposDeSelector));
		ParametersPanel.add(SelecomboBox);
		
		JLabel CruceLabel = new JLabel("Cruce");
		ParametersPanel.add(CruceLabel);
		
		CrucecomboBox = new JComboBox();
		CrucecomboBox.setModel(new DefaultComboBoxModel(tiposDeCruzador));
		ParametersPanel.add(CrucecomboBox);
		
		JLabel MutacionLabel = new JLabel("Mutacion");
		ParametersPanel.add(MutacionLabel);
		
		MutacioncomboBox = new JComboBox();
		MutacioncomboBox.setModel(new DefaultComboBoxModel(tiposDeMutador));
		ParametersPanel.add(MutacioncomboBox);
		
		JLabel ElitismoLabel = new JLabel("% Elitismo");
		ParametersPanel.add(ElitismoLabel);
		
		ElitismotextField = new JTextField();
		ElitismotextField.setText("0");
		ParametersPanel.add(ElitismotextField);
		ElitismotextField.setColumns(2);
		
		JPanel Graficapanel = new JPanel();
		contentPane.add(Graficapanel, BorderLayout.CENTER);
		Graficapanel.setLayout(new BorderLayout(0, 0));
		
		plot = new Plot2DPanel();
		Graficapanel.add(plot);
		JLabel LabelSol = new JLabel("Solucion:");
		
		
		
		EjecutarButton.addActionListener(e -> {
            // Manejar la acción del botón aquí
            reiniciarGrafica();
            try{
            ctr.run(this, camposToRun());
            }
            catch(Exception ex) {
            	//JOptionPane.showMessageDialog(null, "No se ha podido ejecutar el algoritmo, introduzca los datos correctamente");
            	JOptionPane.showMessageDialog(null, ex.getMessage());
            	// ex.printStackTrace();
            }
        });
	}
	
	private TParametros camposToRun() throws CamposException {


		try {
		String selector =  (String) SelecomboBox.getSelectedItem();
		String mutador = (String) MutacioncomboBox.getSelectedItem();
		String cruzador = (String) CrucecomboBox.getSelectedItem();
		
		String Vuelostxt = VuelostextField.getText();
		String TELtxt = txtTeltxt.getText();
		
		double probMuta = Double.parseDouble(ProbMutaciontextField.getText());
		double probCruce = Double.parseDouble(ProbCrucetextField.getText());
		double elitismo =  Double.parseDouble(ElitismotextField.getText());

		int generaciones = Integer.parseInt(nGentextField.getText());
		int tamPobla = Integer.parseInt(TamGentextField.getText());


		return new TParametros(selector,mutador,cruzador,Vuelostxt,TELtxt,probMuta/100,generaciones,tamPobla,probCruce/100,elitismo/100);
		}
		catch(Exception e){
			throw new CamposException("No se han podido analizar los datos introducidos, asegurese de que ha rellenado correctamente todos los campos");
		}

	}

	private void reiniciarGrafica() {
		// TODO Auto-generated method stub
		plot.removeAllPlots();
        plot.repaint();
        solTXT.setText("");
	}

	@Override
	public void update(TResultStatistics trs) {
		// TODO Auto-generated method stub
		plot.addLegend("SOUTH");
		plot.addLinePlot("Mejores Absolutos",trs.getGenreaciones(),trs.getMejoresAbsolutos());
		plot.addLinePlot("Mejores Generacionales",trs.getGenreaciones(),trs.getMejorLocal());
		plot.addLinePlot("Media Generacional",trs.getGenreaciones(),trs.getMedio());
		plot.addLinePlot("Presion Generacional",trs.getGenreaciones(),trs.getPresion());
		solTXT.setText(trs.getElMejor()+"Durante la generacion: " + trs.getPosicion());
	}


}
