package Presentacion;



import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Individuo.TJardin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Interfaz extends JFrame {

    private JComboBox<String> comboBox;
    private JButton cambiarCasillasButton;
    private JPanel panelSuperior;
    private JPanel panelJardin;
    private JPanel[][] casillas;
   // private static final String[] opciones = {"8x8", "16x16", "32x32"};
    
  //private final String[] tiposDeFuncion=  {"vuelos1.txt", "vuelos2.txt"};

  	JComboBox MutacioncomboBox;
  	JComboBox CrucecomboBox;
  	JComboBox SelecomboBox;
	private JTextField TamGentextField;
	private JTextField nGentextField;
	private JTextField ProbCrucetextField;
	private JTextField ProbMutaciontextField;
	private JTextField ElitismotextField;
  	private JFrame parent;
	private int tamaño;
    public Interfaz(JFrame parent) {
    	 parent=parent;
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	
        setBounds(10,100, 700, parent.getHeight()); // Ajustar posición
        // Panel principal inicial con tabla de 8x8 casillas pintadas de verde
        panelJardin = new JPanel();
        panelJardin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        crearCasillas(8);
        tamaño=8;
         // Agregar paneles al JFrame
        JPanel ParametersPanel = new JPanel();
 		ParametersPanel.setBackground(new Color(224, 224, 224));
 		getContentPane().add(ParametersPanel, BorderLayout.NORTH);
 		ParametersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
 		
 		String[] opciones = {"8x8", "12x12", "16x16"};
         comboBox = new JComboBox<>(opciones);
	    ParametersPanel.add(comboBox);
	
  		
          // Agregar ActionListener al JComboBox
          comboBox.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
             	  String seleccion = (String) comboBox.getSelectedItem();
             	 cambiarTamañoTabla(seleccion);
              }
          });
        
          JButton reiniciar=new JButton("RESETEAR");
          reiniciar.addActionListener(e -> {
          // Manejar la acción del botón aquí
        	reset();  
         
          });
		  ParametersPanel.add(reiniciar);
		  getContentPane().setLayout(new BorderLayout());
		  getContentPane().add(ParametersPanel, BorderLayout.NORTH);
		  getContentPane().add(panelJardin, BorderLayout.CENTER);
        
     }

     public  void reset() {
		// TODO Auto-generated method stub
    	String seleccion = (String) comboBox.getSelectedItem();
   	  	cambiarTamañoTabla(seleccion);
	}

	// Método para cambiar el tamaño de la tabla según la opción seleccionada en el JComboBox
     public void cambiarTamañoTabla(String seleccion) {
       
          tamaño = Integer.parseInt(seleccion.substring(0, seleccion.indexOf('x')));

         crearCasillas(tamaño);
     }

     // Método para crear las casillas iniciales de la tabla
     private void crearCasillas(int tamaño) {
         panelJardin.removeAll();
         panelJardin.setLayout(new GridLayout(tamaño, tamaño));

         casillas = new JPanel[tamaño][tamaño];
         Dimension dim = new Dimension(panelJardin.getWidth() / tamaño, panelJardin.getHeight() / tamaño);

         Random rand = new Random();
         for (int i = 0; i < tamaño; i++) {
             for (int j = 0; j < tamaño; j++) {
                 casillas[i][j] = new JPanel();
                 //if(rand.nextDouble() < 0.9)
                     casillas[i][j].setBackground(Color.GREEN);
                 //else
                  //   casillas[i][j].setBackground(Color.RED);
                 
                 casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                 casillas[i][j].setPreferredSize(dim);
                 panelJardin.add(casillas[i][j]);
             }
         }
         
         panelJardin.revalidate();
         panelJardin.repaint();
     }

	

	public Color[][] getColores() {
        Color[][] sol= new  Color[tamaño][tamaño];
		
         for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
              sol[i][j] =casillas[i][j].getBackground();
            }
        }
         return sol;
	}

	public void colorear(Color[][] colors) {
		// TODO Auto-generated method stub
		 
		
	      
	         for (int i = 0; i < tamaño; i++) {
	             for (int j = 0; j < tamaño; j++) {
	                 
	                 casillas[i][j].setBackground(colors[i][j]);
	             }
	         }
	         
	         panelJardin.revalidate();
	         panelJardin.repaint();
	}

    

}