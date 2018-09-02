package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlPDA;
import control.LeerEscribirPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;
import entity.Regla;

public class FPalabra extends JFrame {
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	public JTextField palabra;
	
	 private JButton simularButton = new JButton("Simulador");
	 
	PDA pda;
	 

	   public FPalabra(PDA pda) {
		   this.pda=pda;
		   System.out.println("entre");
		   JPanel panelpalabra= new JPanel();
	      palabra = new JTextField("Inserte Palabra");
	      palabra.setFont(new Font("Serif", Font.BOLD, 20));
	      palabra.setPreferredSize(new Dimension(300, 50));
	      
	      
	      
	      //enviar palabra!!
	      
	      simularButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  char[] charpalabra= palabra.getText().toCharArray();
	     	   
	        	  String[] stringarr = new String[charpalabra.length]; 
	        	  int i=0;
	        	  for (char d : charpalabra) {

	                  stringarr[i]=Character.toString(d);
	                  i++;
	              }
	        	  for (String string : stringarr) {
	                  System.out.println(string);
	              }
	        	  
	        	  
	        	
	        	  
	        	  System.out.println("imprimir estados pda");
	        	  for(int j=0;j<pda.getEstados().length;j++) {
	        	  System.out.println(pda.getEstados()[j]);
	        	  }
	        	  
	        	  System.out.println("imprimir reglas pda");
	        	  for(int j=0;j<pda.getReglas().length;j++) {
	        	  System.out.println(pda.getReglas()[j]);
	        	  }
	      		LeerEscribirPDA c = new LeerEscribirPDA();
	      		c.crearPDA(pda);
	        	  
	      		System.out.println("\nleemos el archivo creado");
	    		
	    		PDA nuevo = c.leerPDA(pda.getNombre());
	    		System.out.println(nuevo.toString() + "\n" + pda.toString());
	    		System.out.println(nuevo.toString().equals(pda.toString()));
	    		ControlPDA con = new ControlPDA();
	    		System.out.println("recursividad:");
	    		
	    		//deberia aceptar
	    		con.reiniciarPDA(pda);
	    		System.out.println(con.simularAutomata(pda, "abc"));
	    		con.reiniciarPDA(pda);
	    		
	    		//deberia rechazar
	    		System.out.println(con.simularAutomata(pda, "aabc"));
	    		con.reiniciarPDA(pda);

	        	  
	        	  setVisible(false); 
	        	  dispose();
	        	  new PilaIU(pda);
	          }
	       });
	    
	      palabra.addMouseListener(new MouseAdapter() {
	    	  @Override
	    	  public void mouseClicked(MouseEvent e) {
	    	    palabra.setText("");
	    	  }
	    	});
	      
	      
	      
	      
	      
	      
	     
	    
	      panelpalabra.add(palabra);
	      panelpalabra.add(simularButton);
	     getContentPane().add(panelpalabra);
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	   }

	  
	   

}