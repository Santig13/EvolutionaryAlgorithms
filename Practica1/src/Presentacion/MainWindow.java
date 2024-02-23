package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JTextPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTamGener;
	private JTextField textFieldNGener;
	private JTextField textFieldProbCruc;
	private JTextField textFieldProbMut;
	private JTextField textFieldPrecision;
	private JTextField textFieldProbElitis;
	private JTextField textFieldNDim;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		JComboBox comboBoxFunc = new JComboBox();
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
		GridBagConstraints gbc_textFieldProbCruc = new GridBagConstraints();
		gbc_textFieldProbCruc.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProbCruc.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProbCruc.gridx = 0;
		gbc_textFieldProbCruc.gridy = 8;
		panelParametros.add(textFieldProbCruc, gbc_textFieldProbCruc);
		textFieldProbCruc.setColumns(10);
		
		JLabel LabelProbMut = new JLabel("Probailidad Mutacion");
		GridBagConstraints gbc_LabelProbMut = new GridBagConstraints();
		gbc_LabelProbMut.insets = new Insets(0, 0, 5, 0);
		gbc_LabelProbMut.gridx = 0;
		gbc_LabelProbMut.gridy = 9;
		panelParametros.add(LabelProbMut, gbc_LabelProbMut);
		
		textFieldProbMut = new JTextField();
		GridBagConstraints gbc_textFieldProbMut = new GridBagConstraints();
		gbc_textFieldProbMut.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProbMut.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProbMut.gridx = 0;
		gbc_textFieldProbMut.gridy = 10;
		panelParametros.add(textFieldProbMut, gbc_textFieldProbMut);
		textFieldProbMut.setColumns(10);
		
		JLabel LabelPrecision = new JLabel("Precision de Representaci\u00F3n");
		GridBagConstraints gbc_LabelPrecision = new GridBagConstraints();
		gbc_LabelPrecision.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPrecision.gridx = 0;
		gbc_LabelPrecision.gridy = 11;
		panelParametros.add(LabelPrecision, gbc_LabelPrecision);
		
		textFieldPrecision = new JTextField();
		GridBagConstraints gbc_textFieldPrecision = new GridBagConstraints();
		gbc_textFieldPrecision.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrecision.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecision.gridx = 0;
		gbc_textFieldPrecision.gridy = 12;
		panelParametros.add(textFieldPrecision, gbc_textFieldPrecision);
		textFieldPrecision.setColumns(10);
		
		JLabel LabelMetSelec = new JLabel("Metodo Seleccion");
		GridBagConstraints gbc_LabelMetSelec = new GridBagConstraints();
		gbc_LabelMetSelec.anchor = GridBagConstraints.BASELINE;
		gbc_LabelMetSelec.insets = new Insets(0, 0, 5, 0);
		gbc_LabelMetSelec.gridx = 0;
		gbc_LabelMetSelec.gridy = 13;
		panelParametros.add(LabelMetSelec, gbc_LabelMetSelec);
		
		JComboBox comboBoxMetSel = new JComboBox();
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
		
		JComboBox comboBoxMetCruce = new JComboBox();
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
		
		JComboBox comboBoxMetMut = new JComboBox();
		GridBagConstraints gbc_comboBoxMetMut = new GridBagConstraints();
		gbc_comboBoxMetMut.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxMetMut.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMetMut.gridx = 0;
		gbc_comboBoxMetMut.gridy = 18;
		panelParametros.add(comboBoxMetMut, gbc_comboBoxMetMut);
		
		JLabel LabelProbElitis = new JLabel("Probabilidad Elitismo");
		GridBagConstraints gbc_LabelProbElitis = new GridBagConstraints();
		gbc_LabelProbElitis.insets = new Insets(0, 0, 5, 0);
		gbc_LabelProbElitis.gridx = 0;
		gbc_LabelProbElitis.gridy = 19;
		panelParametros.add(LabelProbElitis, gbc_LabelProbElitis);
		
		textFieldProbElitis = new JTextField();
		GridBagConstraints gbc_textFieldProbElitis = new GridBagConstraints();
		gbc_textFieldProbElitis.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProbElitis.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProbElitis.gridx = 0;
		gbc_textFieldProbElitis.gridy = 20;
		panelParametros.add(textFieldProbElitis, gbc_textFieldProbElitis);
		textFieldProbElitis.setColumns(10);
		
		JLabel LabelNDim = new JLabel("Dimensiones (Solo funcion 4 y 5)");
		GridBagConstraints gbc_LabelNDim = new GridBagConstraints();
		gbc_LabelNDim.insets = new Insets(0, 0, 5, 0);
		gbc_LabelNDim.gridx = 0;
		gbc_LabelNDim.gridy = 21;
		panelParametros.add(LabelNDim, gbc_LabelNDim);
		
		textFieldNDim = new JTextField();
		GridBagConstraints gbc_textFieldNDim = new GridBagConstraints();
		gbc_textFieldNDim.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNDim.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNDim.gridx = 0;
		gbc_textFieldNDim.gridy = 22;
		panelParametros.add(textFieldNDim, gbc_textFieldNDim);
		textFieldNDim.setColumns(10);
		
		JButton ButtonEjecutar = new JButton("Ejectutar");
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
		
		JLabel LabelSol = new JLabel("Solucion:");
		panelSol.add(LabelSol);
		
		JTextArea textAreaSol = new JTextArea();
		panelSol.add(textAreaSol);
	}

}
