package view;
import java.awt.Component;


import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import control.ControlPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;

public class FNombre extends JFrame {
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	public JTextField nombrepda;
	
	 private JButton saveButton = new JButton("Save");
	
	
	 ControlPDA control= new ControlPDA();
	 PDA pda;
	 

	   public FNombre(PDA pda) {
		   this.pda=pda;
		  
		   Pila pila = new Pila();
		   pda.setPila(pila);
		   
		   System.out.println("entre");
		   JPanel nombre= new JPanel();
	      nombrepda = new JTextField("Ingrese nombre PDA para guardar");
	      nombrepda.setFont(new Font("Serif", Font.BOLD, 20));
	      nombrepda.setPreferredSize(new Dimension(300, 50));
	     
	      
	      saveButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  pda.setNombre(nombrepda.getText());
	        	 //timer.start();
	        	 new FConjuntos(pda);
	        	  setVisible(false); 
	        	  dispose();
	        	
	          }
	       });
	      
	      
	    
	  
	      
	      
	      nombrepda.addMouseListener(new MouseAdapter() {
	    	  @Override
	    	  public void mouseClicked(MouseEvent e) {
	    	    nombrepda.setText("");
	    	    
	    	  }
	    	});
	      
	      
	     
	      
	      
	      
	      
	      nombre.add(nombrepda);
	     
	      nombre.add(saveButton);
	      
	    
	      
	     getContentPane().add(nombre);
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	   }

	 
	   
	   
	  

}