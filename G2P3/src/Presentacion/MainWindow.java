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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
import Individuo.TJardin;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class MainWindow extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea solTXT;
	private JTextField TamGentextField;
	private JTextField nGentextField;
	private JTextField ProbCrucetextField;
	private JTextField ProbMutaciontextField;
	private JTextField ElitismotextField;
	private JTextField WrapstextField;

	private JTextField VuelostextField;
	private JTextField txtTeltxt;
	private Plot2DPanel plot;
	//private final String[] tiposDeFuncion=  {"vuelos1.txt", "vuelos2.txt"};
	private final String[] tiposDeCruzadorArboles= {"Normal"};
	private final String[] tiposDeCruzadorGramaticas= {"Mono Punto","Uniforme"};

	private final String[] tiposDeMutadorArboles= {"Terminal","Funcional", "Arbol-SubArbol", "Inicializacion"};
	private final String[] tiposDeMutadorGramaticas= {"Basico"};

	private final String[] tiposIniciadoresArboles= {"Completo","Creciente", "Ramped-Half", "Inicializacion"};
	private final String[] tiposIniciadoresGramaticas= {"Normal"};

	private final String[] tiposDeSelector= {"Ruleta", "Estocastico", "Truncamiento", "Torneo Det", "Torneo Pro", "Restos", "Ranking"};
	private final String[] tiposIndividuos= {"Programacion Genetica","Gramaticas Evolutivas"};

	JComboBox MutacioncomboBox;
	JComboBox CrucecomboBox;
	JComboBox SelecomboBox;
	private Interfaz interfaz;
	private JComboBox inicomboBox;
	private JTextArea textArea;
	private JPanel IndividuoPanel;
	private JComboBox IndividuoComboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		Controller ctr=new ControllerIMP();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 787, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		//SolPanel.setMaximumSize(new Dimension(700, 400));
		
		
		this.interfaz=new Interfaz(this);
		
       
        
		JButton EjecutarButton = new JButton("Ejecutar");
		
		
		JPanel ParametersPanel = new JPanel();
		ParametersPanel.setBackground(new Color(224, 224, 224));
		contentPane.add(ParametersPanel, BorderLayout.NORTH);
		ParametersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Dimension preferredSize = ParametersPanel.getPreferredSize();
		preferredSize.height += 60; // Aumentar en 50 píxeles la altura actual
		ParametersPanel.setPreferredSize(preferredSize);
		
		JLabel TamGenLabel = new JLabel("Tam Generaci\u00F3n");
		ParametersPanel.add(TamGenLabel);
		
		TamGentextField = new JTextField();
		TamGentextField.setText("5");
		ParametersPanel.add(TamGentextField);
		TamGentextField.setColumns(3);
		
		JLabel nGenLabel = new JLabel("n\u00BAGeneraciones");
		ParametersPanel.add(nGenLabel);
		
		nGentextField = new JTextField();
		nGentextField.setText("5");
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
		CrucecomboBox.setModel(new DefaultComboBoxModel(tiposDeCruzadorArboles));
		ParametersPanel.add(CrucecomboBox);
		
		JLabel MutacionLabel = new JLabel("Mutacion");
		ParametersPanel.add(MutacionLabel);
		
		MutacioncomboBox = new JComboBox();
		MutacioncomboBox.setModel(new DefaultComboBoxModel(tiposDeMutadorArboles));
		ParametersPanel.add(MutacioncomboBox);
		
		
		
		JLabel inicializadotrs = new JLabel("Iniciadores");
		ParametersPanel.add(inicializadotrs);
		 inicomboBox = new JComboBox();
		inicomboBox.setModel(new DefaultComboBoxModel(tiposIniciadoresArboles));
		ParametersPanel.add(inicomboBox);
		
		
		JLabel ElitismoLabel = new JLabel("% Elitismo");
		ParametersPanel.add(ElitismoLabel);
		
		ElitismotextField = new JTextField();
		ElitismotextField.setText("0");
		ParametersPanel.add(ElitismotextField);
		ElitismotextField.setColumns(2);
		
		
		JLabel MaxWrapsLabel = new JLabel("Wraps");
		ParametersPanel.add(MaxWrapsLabel);
		
		
		WrapstextField = new JTextField();
		WrapstextField.setText("20");
		ParametersPanel.add(WrapstextField);
		WrapstextField.setColumns(2);
		
		MaxWrapsLabel.setVisible(false);
		WrapstextField.setVisible(false);
		
		ParametersPanel.add(EjecutarButton);
		
		JPanel Graficapanel = new JPanel();
		contentPane.add(Graficapanel, BorderLayout.CENTER);
		
		Graficapanel.setLayout(new BorderLayout(0, 0));
		
		plot = new Plot2DPanel();
		Graficapanel.add(plot);
		JLabel LabelSol = new JLabel("Solucion:");
		
		textArea = new JTextArea();
		textArea.setRows(5); // Establecer el número de filas (altura) del área de texto

		// Agregar el JTextArea al contenedor principal (contentPane) debajo de ParametersPanel
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		IndividuoPanel = new JPanel();
		scrollPane.setRowHeaderView(IndividuoPanel);
		
		IndividuoComboBox = new JComboBox();
		IndividuoPanel.add(IndividuoComboBox);
		IndividuoComboBox.setModel(new DefaultComboBoxModel(tiposIndividuos));
		IndividuoComboBox.addActionListener(e -> {
			if(IndividuoComboBox.getSelectedItem() == "Programacion Genetica")
			{

				MaxWrapsLabel.setVisible(false);
				WrapstextField.setVisible(false);
				
				inicomboBox.setModel(new DefaultComboBoxModel(tiposIniciadoresArboles));
				CrucecomboBox.setModel(new DefaultComboBoxModel(tiposDeCruzadorArboles));
				MutacioncomboBox.setModel(new DefaultComboBoxModel(tiposDeMutadorArboles));

			}
			else
			{

				MaxWrapsLabel.setVisible(true);
				WrapstextField.setVisible(true);
				
				inicomboBox.setModel(new DefaultComboBoxModel(tiposIniciadoresGramaticas));
				CrucecomboBox.setModel(new DefaultComboBoxModel(tiposDeCruzadorGramaticas));
				MutacioncomboBox.setModel(new DefaultComboBoxModel(tiposDeMutadorGramaticas));
			}
        });
		
		EjecutarButton.addActionListener(e -> {
            // Manejar la acción del botón aquí
            reiniciarGrafica();
            try{
            	ctr.run(this, camposToRun());
            }
            catch(Exception ex) {
            	//JOptionPane.showMessageDialog(null, "No se ha podido ejecutar el algoritmo, introduzca los datos correctamente");
            	JOptionPane.showMessageDialog(null, ex.getMessage());
            	ex.printStackTrace();
            }
        });
		this.interfaz.setVisible(true);
	}


	private TParametros camposToRun() throws CamposException {


		try {
		String selector =  (String) SelecomboBox.getSelectedItem();
		String mutador = (String) MutacioncomboBox.getSelectedItem();
		String cruzador = (String) CrucecomboBox.getSelectedItem();
		String ini = (String) inicomboBox.getSelectedItem();
		String tIndividuo =(String) this.IndividuoComboBox.getSelectedItem();

		
		double probMuta = Double.parseDouble(ProbMutaciontextField.getText());
		double probCruce = Double.parseDouble(ProbCrucetextField.getText());
		double elitismo =  Double.parseDouble(ElitismotextField.getText());

		int generaciones = Integer.parseInt(nGentextField.getText());
		int tamPobla = Integer.parseInt(TamGentextField.getText());
		int wraps = 0;

		if (IndividuoComboBox.getSelectedItem() == "Gramaticas Evolutivas")
			wraps=Integer.parseInt(WrapstextField.getText());
		
		Color[][] sol=this.interfaz.getColores();
		
		return new TParametros(selector,mutador,cruzador,probMuta/100,generaciones,tamPobla,probCruce/100,elitismo/100,sol,ini,tIndividuo,wraps);
		}
		catch(Exception e){
			throw new CamposException("No se han podido analizar los datos introducidos, asegurese de que ha rellenado correctamente todos los campos");
		}

	}

	private void reiniciarGrafica() {
		// TODO Auto-generated method stub
		plot.removeAllPlots();
        plot.repaint();
        this.interfaz.reset();
      //  solTXT.setText("");
	}

	@Override
	public void update(TResultStatistics trs) {
		// TODO Auto-generated method stub
		plot.addLegend("SOUTH");
		plot.addLinePlot("Mejores Absolutos",trs.getGenreaciones(),trs.getMejoresAbsolutos());
		plot.addLinePlot("Mejores Generacionales",trs.getGenreaciones(),trs.getMejorLocal());
		plot.addLinePlot("Media Generacional",trs.getGenreaciones(),trs.getMedio());
		plot.addLinePlot("Presion Generacional",trs.getGenreaciones(),trs.getPresion());
		textArea.setText("Durante la generacion: " + trs.getPosicion()+" "+trs.getElMejor());
		this.interfaz.colorear(trs.getColors());
	}

}
