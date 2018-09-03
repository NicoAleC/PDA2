package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.LeerEscribirPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;

public class FAntiguo extends JFrame{

	String nombre;

	JTextField buscar;
	private JButton buscarButton = new JButton("Buscar");
	
	 public FAntiguo() {
			
		   
		   System.out.println("entre");
		   JPanel antiguos= new JPanel();
	      buscar = new JTextField("Inserte nombre PDA");
	      buscar.setFont(new Font("Serif", Font.BOLD, 20));
	      buscar.setPreferredSize(new Dimension(300, 50));
	     
	      
	      buscarButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  nombre=buscar.getText();
	        	  LeerEscribirPDA c = new LeerEscribirPDA();
	        	  
	        	 
	  			PDA nuevo = c.leerPDA(nombre);
	  			new PilaIU(nuevo);
	        	
	        		 
	        		
	        	 //timer.start();
	        	 
	        	  setVisible(false); 
	        	  dispose();
	        	
	          }
	       });
	      
	      
	      
	      
	      buscar.addMouseListener(new MouseAdapter() {
	    	  @Override
	    	  public void mouseClicked(MouseEvent e) {
	    	    buscar.setText("");
	    	   
	    	  }
	    	});
	      
	     
	      
	      
	      
	      
	      antiguos.add(buscar);
	      antiguos.add(buscarButton);
	     
	    
	      
	     getContentPane().add(antiguos);
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	   }

	 
	   
	   
}
