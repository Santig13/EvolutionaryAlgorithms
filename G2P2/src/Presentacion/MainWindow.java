package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.math.plot.Plot2DPanel;

import Controlador.Controller;
import Controlador.ControllerIMP;
import Controlador.TParametros;
import Controlador.TResultStatistics;

public class MainWindow extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String[] tiposDeFuncion= {"Problema 1","Problema 2"};
	private final String[] tiposDeCruzador= {"PMX","OX","OX con pos prioritarias", "CX", "CO", "Metodo Propio"};
	private final String[] tiposDeMutador= {"Inserccion","Intercambio","Inversion","Heuristica","Metodo Propio"};
	private final String[] tiposDeSelector= {"Ruleta","Estocastico","Truncamiento","Torneo Deterministico","Torneo Probabilistico", "Restos", "Ranking"};
	private JPanel contentPane;
	private JTextField textFieldTamGener;
	private JTextField textFieldNGener;
	private JTextField textFieldProbCruc;
	private JTextField textFieldProbMut;
	private JTextField textFieldProbElitis;
	private JComboBox<String> comboBoxFunc;
	private JComboBox<String> comboBoxMetSel;
	private JComboBox<String> comboBoxMetCruce;
	private JComboBox<String> comboBoxMetMut;
	private Plot2DPanel plot;
	private JTextArea textAreaSol;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Controller ctr=new ControllerIMP();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelParametros = new JPanel();
		contentPane.add(panelParametros, BorderLayout.WEST);
		GridBagLayout gbl_panelParametros = new GridBagLayout();
		gbl_panelParametros.columnWidths = new int[]{145, 0};
		gbl_panelParametros.rowHeights = new int[]{0, 0, 0, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelParametros.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelParametros.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParametros.setLayout(gbl_panelParametros);

		JLabel LabelFuncion = new JLabel("Funcion a Resolver");
		GridBagConstraints gbc_LabelFuncion = new GridBagConstraints();
		gbc_LabelFuncion.insets = new Insets(0, 0, 5, 0);
		gbc_LabelFuncion.gridx = 0;
		gbc_LabelFuncion.gridy = 1;
		panelParametros.add(LabelFuncion, gbc_LabelFuncion);

		comboBoxFunc = new JComboBox<>(this.tiposDeFuncion);
		/*
		comboBoxFunc.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        String selected = (String) comboBoxFunc.getSelectedItem();
		        switch(selected) {
		        case "Funcion 5":
		        	comboBoxMetCruce.setModel(new DefaultComboBoxModel<>(tiposDeCruzador5));
		        	LabelNDim.setVisible(true);
		        	textFieldNDim.setVisible(true);
		        	textFieldPrecision.setVisible(false);
		        	LabelPrecision.setVisible(false);
		        	break;
		        case "Funcion 4":
		        	comboBoxMetCruce.setModel(new DefaultComboBoxModel<>(tiposDeCruzador));
		        	LabelNDim.setVisible(true);
		        	textFieldNDim.setVisible(true);
		        	textFieldPrecision.setVisible(true);
		        	LabelPrecision.setVisible(true);
		        	break;
		        default:
		        	comboBoxMetCruce.setModel(new DefaultComboBoxModel<>(tiposDeCruzador));
		        	LabelNDim.setVisible(false);
		        	textFieldNDim.setVisible(false);
		        	textFieldPrecision.setVisible(true);
		        	LabelPrecision.setVisible(true);
		        	break;
		        }
		    }
		});
		*/
		GridBagConstraints gbc_comboBoxFunc = new GridBagConstraints();
		gbc_comboBoxFunc.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxFunc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFunc.gridx = 0;
		gbc_comboBoxFunc.gridy = 2;
		panelParametros.add(comboBoxFunc, gbc_comboBoxFunc);

		JLabel LabelTamGener = new JLabel("Tama\u00F1o Generacion");
		GridBagConstraints gbc_LabelTamGener = new GridBagConstraints();
		gbc_LabelTamGener.insets = new Insets(0, 0, 5, 0);
		gbc_LabelTamGener.gridx = 0;
		gbc_LabelTamGener.gridy = 3;
		panelParametros.add(LabelTamGener, gbc_LabelTamGener);

		textFieldTamGener = new JTextField();
		textFieldTamGener.setText("100");
		GridBagConstraints gbc_textFieldTamGener = new GridBagConstraints();
		gbc_textFieldTamGener.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTamGener.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTamGener.gridx = 0;
		gbc_textFieldTamGener.gridy = 4;
		panelParametros.add(textFieldTamGener, gbc_textFieldTamGener);
		textFieldTamGener.setColumns(10);

		JLabel LabelNGener = new JLabel("Numero Generaciones");
		GridBagConstraints gbc_LabelNGener = new GridBagConstraints();
		gbc_LabelNGener.insets = new Insets(0, 0, 5, 0);
		gbc_LabelNGener.gridx = 0;
		gbc_LabelNGener.gridy = 5;
		panelParametros.add(LabelNGener, gbc_LabelNGener);

		textFieldNGener = new JTextField();
		textFieldNGener.setText("100");
		GridBagConstraints gbc_textFieldNGener = new GridBagConstraints();
		gbc_textFieldNGener.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNGener.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNGener.gridx = 0;
		gbc_textFieldNGener.gridy = 6;
		panelParametros.add(textFieldNGener, gbc_textFieldNGener);
		textFieldNGener.setColumns(10);

		JLabel LabelProbCruce = new JLabel("Probabilidad Cruce");
		GridBagConstraints gbc_LabelProbCruce = new GridBagConstraints();
		gbc_LabelProbCruce.insets = new Insets(0, 0, 5, 0);
		gbc_LabelProbCruce.gridx = 0;
		gbc_LabelProbCruce.gridy = 7;
		panelParametros.add(LabelProbCruce, gbc_LabelProbCruce);

		textFieldProbCruc = new JTextField();
		textFieldProbCruc.setText("60");
		GridBagConstraints gbc_textFieldProbCruc = new GridBagConstraints();
		gbc_textFieldProbCruc.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProbCruc.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProbCruc.gridx = 0;
		gbc_textFieldProbCruc.gridy = 8;
		panelParametros.add(textFieldProbCruc, gbc_textFieldProbCruc);
		textFieldProbCruc.setColumns(10);

		JLabel LabelProbMut = new JLabel("Porcentaje de  Mutacion");
		GridBagConstraints gbc_LabelProbMut = new GridBagConstraints();
		gbc_LabelProbMut.insets = new Insets(0, 0, 5, 0);
		gbc_LabelProbMut.gridx = 0;
		gbc_LabelProbMut.gridy = 9;
		panelParametros.add(LabelProbMut, gbc_LabelProbMut);

		textFieldProbMut = new JTextField();
		textFieldProbMut.setText("5");
		GridBagConstraints gbc_textFieldProbMut = new GridBagConstraints();
		gbc_textFieldProbMut.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProbMut.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProbMut.gridx = 0;
		gbc_textFieldProbMut.gridy = 10;
		panelParametros.add(textFieldProbMut, gbc_textFieldProbMut);
		textFieldProbMut.setColumns(10);

		JLabel LabelMetSelec = new JLabel("Metodo Seleccion");
		GridBagConstraints gbc_LabelMetSelec = new GridBagConstraints();
		gbc_LabelMetSelec.anchor = GridBagConstraints.BASELINE;
		gbc_LabelMetSelec.insets = new Insets(0, 0, 5, 0);
		gbc_LabelMetSelec.gridx = 0;
		gbc_LabelMetSelec.gridy = 13;
		panelParametros.add(LabelMetSelec, gbc_LabelMetSelec);

		comboBoxMetSel = new JComboBox<>(this.tiposDeSelector);
		GridBagConstraints gbc_comboBoxMetSel = new GridBagConstraints();
		gbc_comboBoxMetSel.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxMetSel.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMetSel.gridx = 0;
		gbc_comboBoxMetSel.gridy = 14;
		panelParametros.add(comboBoxMetSel, gbc_comboBoxMetSel);

		JLabel LabelMetCruce = new JLabel("Metodo Cruce");
		GridBagConstraints gbc_LabelMetCruce = new GridBagConstraints();
		gbc_LabelMetCruce.insets = new Insets(0, 0, 5, 0);
		gbc_LabelMetCruce.gridx = 0;
		gbc_LabelMetCruce.gridy = 15;
		panelParametros.add(LabelMetCruce, gbc_LabelMetCruce);

		comboBoxMetCruce = new JComboBox<>(this.tiposDeCruzador);
		GridBagConstraints gbc_comboBoxMetCruce = new GridBagConstraints();
		gbc_comboBoxMetCruce.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxMetCruce.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMetCruce.gridx = 0;
		gbc_comboBoxMetCruce.gridy = 16;
		panelParametros.add(comboBoxMetCruce, gbc_comboBoxMetCruce);

		JLabel LabelMetMut = new JLabel("Metodo Mutacion");
		GridBagConstraints gbc_LabelMetMut = new GridBagConstraints();
		gbc_LabelMetMut.insets = new Insets(0, 0, 5, 0);
		gbc_LabelMetMut.gridx = 0;
		gbc_LabelMetMut.gridy = 17;
		panelParametros.add(LabelMetMut, gbc_LabelMetMut);

		comboBoxMetMut = new JComboBox<>(this.tiposDeMutador);
		GridBagConstraints gbc_comboBoxMetMut = new GridBagConstraints();
		gbc_comboBoxMetMut.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxMetMut.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMetMut.gridx = 0;
		gbc_comboBoxMetMut.gridy = 18;
		panelParametros.add(comboBoxMetMut, gbc_comboBoxMetMut);

		JLabel LabelProbElitis = new JLabel("Porcentaje Elitismo");
		GridBagConstraints gbc_LabelProbElitis = new GridBagConstraints();
		gbc_LabelProbElitis.insets = new Insets(0, 0, 5, 0);
		gbc_LabelProbElitis.gridx = 0;
		gbc_LabelProbElitis.gridy = 19;
		panelParametros.add(LabelProbElitis, gbc_LabelProbElitis);

		textFieldProbElitis = new JTextField();
		textFieldProbElitis.setText("0");
		GridBagConstraints gbc_textFieldProbElitis = new GridBagConstraints();
		gbc_textFieldProbElitis.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProbElitis.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProbElitis.gridx = 0;
		gbc_textFieldProbElitis.gridy = 20;
		panelParametros.add(textFieldProbElitis, gbc_textFieldProbElitis);
		textFieldProbElitis.setColumns(10);

		JButton ButtonEjecutar = new JButton("Ejectutar");
		ButtonEjecutar.addActionListener(e -> {
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
		GridBagConstraints gbc_ButtonEjecutar = new GridBagConstraints();
		gbc_ButtonEjecutar.insets = new Insets(0, 0, 5, 0);
		gbc_ButtonEjecutar.gridx = 0;
		gbc_ButtonEjecutar.gridy = 24;
		panelParametros.add(ButtonEjecutar, gbc_ButtonEjecutar);

		JPanel panelGraficaSol = new JPanel();
		panelGraficaSol.setBackground(new Color(192, 192, 192));
		contentPane.add(panelGraficaSol, BorderLayout.CENTER);
		panelGraficaSol.setLayout(new BorderLayout(0, 0));

		JPanel panelSol = new JPanel();
		panelGraficaSol.add(panelSol, BorderLayout.SOUTH);
		panelSol.setSize(new Dimension(100, 200));
		panelSol.setLayout(new BoxLayout(panelSol, BoxLayout.X_AXIS));
		//Representacion
		plot = new Plot2DPanel();
		panelGraficaSol.add(plot);
		JLabel LabelSol = new JLabel("Solucion:");
		panelSol.add(LabelSol);


		textAreaSol = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textAreaSol);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelSol.add(scrollPane);
	}



	private TParametros camposToRun() throws CamposException {


		try {
		String selector =  (String) comboBoxMetSel.getSelectedItem();
		String mutador = (String) comboBoxMetMut.getSelectedItem();
		String cruzador = (String) comboBoxMetCruce.getSelectedItem();
		String funcion = (String) comboBoxFunc.getSelectedItem();

		double probMuta = Double.parseDouble(textFieldProbMut.getText());
		double probCruce = Double.parseDouble(textFieldProbCruc.getText());
		double elitismo =  Double.parseDouble(textFieldProbElitis.getText());

		int generaciones = Integer.parseInt(textFieldNGener.getText());
		int tamPobla = Integer.parseInt(textFieldTamGener.getText());


		return new TParametros(selector,mutador,cruzador,funcion,probMuta/100,generaciones,tamPobla,probCruce/100,elitismo/100);
		}
		catch(Exception e){
			throw new CamposException("No se han podido analizar los datos introducidos, asegurese de que ha rellenado correctamente todos los campos");
		}

	}

	private void reiniciarGrafica() {
		// TODO Auto-generated method stub
		plot.removeAllPlots();
        plot.repaint();
        textAreaSol.setText("");
	}

	@Override
	public void update(TResultStatistics trs) {
		// TODO Auto-generated method stub
		plot.addLegend("SOUTH");
		plot.addLinePlot("Mejores Absolutos",trs.getGenreaciones(),trs.getMejoresAbsolutos());
		plot.addLinePlot("Mejores Generacionales",trs.getGenreaciones(),trs.getMejorLocal());
		plot.addLinePlot("Media Generacional",trs.getGenreaciones(),trs.getMedio());
		plot.addLinePlot("Presion Generacional",trs.getGenreaciones(),trs.getPresion());
		textAreaSol.setText(trs.getElMejor()+"Durante la generacion: " + trs.getPosicion());
	}

}
