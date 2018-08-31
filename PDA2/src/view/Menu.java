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
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class Menu extends JFrame {
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	
	 private JButton nuevoButton = new JButton("Nuevo");
	 private JButton antiguoButton = new JButton("Antiguo");
	 
	 ControlPDA control= new ControlPDA();
	 PDA pda;
	 Estado estado;
	 

	   public Menu() {
		  
		   System.out.println("entre");
		   JPanel menu= new JPanel();
		   JLabel label= new JLabel("BIENVENIDO");
	      
	      menu.setFont(new Font("Serif", Font.BOLD, 20));
	      menu.setPreferredSize(new Dimension(300, 50));
	      /*Icon iconB = new ImageIcon(getClass().getResource("cargando.gif"));
	      JLabel label = new JLabel(iconB);*/
	      
	      nuevoButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 pda=new PDA();
	        	 
	        	 
	        	  setVisible(false); 
	        	  dispose();
	        	  new FConjuntos(pda);
	          }
	       });
	      
	      
	    antiguoButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  
	        	  //buscar!!
	        	  
	          }
	       });
	      
	      
	      
	      
	     
	     
	      
	      


menu.add(label);
	      
	      menu.add(nuevoButton);
	      menu.add(antiguoButton);
	      
	    
	      
	     getContentPane().add(menu);
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	   }

	 
	   
	   
	  

}
