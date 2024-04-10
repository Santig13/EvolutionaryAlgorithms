package Presentacion;



import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    private JComboBox<String> comboBox;
    private JButton cambiarCasillasButton;
    private JPanel panelSuperior;
    private JPanel panelJardin;
    private JPanel[][] casillas;
   // private static final String[] opciones = {"8x8", "16x16", "32x32"};
    
  //private final String[] tiposDeFuncion=  {"vuelos1.txt", "vuelos2.txt"};
  	private final String[] tiposDeCruzador= {"PMX", "OX", "OXPP","OXOP", "CX", "CO", "ZigZag"};
  	private final String[] tiposDeMutador= { "Intercambio","Insercion", "Inversion", "Heuristica", "Fibonacci"};
  	private final String[] tiposDeSelector= {"Ruleta", "Estocastico", "Truncamiento", "Torneo Det", "Torneo Pro", "Restos", "Ranking"};
  	
  	JComboBox MutacioncomboBox;
  	JComboBox CrucecomboBox;
  	JComboBox SelecomboBox;
	private JTextField TamGentextField;
	private JTextField nGentextField;
	private JTextField ProbCrucetextField;
	private JTextField ProbMutaciontextField;
	private JTextField ElitismotextField;
  	
    public Interfaz() {
    	 setTitle("Aplicación con Tabla y Panel Superior");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(700, 700);
        
         // Panel principal inicial con tabla de 8x8 casillas pintadas de verde
         panelJardin = new JPanel();
         panelJardin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         crearCasillas(8);
         // Agregar paneles al JFrame
         
         
         JPanel ParametersPanel = new JPanel();
 		ParametersPanel.setBackground(new Color(224, 224, 224));
 		ParametersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
 		
 		String[] opciones = {"8x8", "12x12", "16x16"};
        comboBox = new JComboBox<>(opciones);
        ParametersPanel.add(comboBox);
 		
 		
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
 		
         // Agregar ActionListener al JComboBox
         comboBox.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cambiarTamañoTabla();
             }
         });
         getContentPane().setLayout(new BorderLayout());
         getContentPane().add(ParametersPanel, BorderLayout.NORTH);
         getContentPane().add(panelJardin, BorderLayout.CENTER);
     }

     // Método para cambiar el tamaño de la tabla según la opción seleccionada en el JComboBox
     private void cambiarTamañoTabla() {
         String seleccion = (String) comboBox.getSelectedItem();
         int tamaño = Integer.parseInt(seleccion.substring(0, seleccion.indexOf('x')));

         crearCasillas(tamaño);
     }

     // Método para crear las casillas iniciales de la tabla
     private void crearCasillas(int tamaño) {
         panelJardin.removeAll();
         panelJardin.setLayout(new GridLayout(tamaño, tamaño));

         casillas = new JPanel[tamaño][tamaño];
         Dimension dim = new Dimension(panelJardin.getWidth() / tamaño, panelJardin.getHeight() / tamaño);

         for (int i = 0; i < tamaño; i++) {
             for (int j = 0; j < tamaño; j++) {
                 casillas[i][j] = new JPanel();
                 casillas[i][j].setBackground(Color.GREEN);
                 casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                 casillas[i][j].setPreferredSize(dim);
                 panelJardin.add(casillas[i][j]);
             }
         }

         panelJardin.revalidate();
         panelJardin.repaint();
     }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interfaz frame = new Interfaz();
                frame.setVisible(true);
            }
        });
    }
}