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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import control.ControlPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;

public class FConjuntos extends JFrame {
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	public JTextField conjunto;
	private JCheckBox einicial= new JCheckBox();
	private JCheckBox efinal= new JCheckBox();
	 private JButton saveButton = new JButton("Save");
	 private JButton addButton = new JButton("Add");
	 public boolean eeinicial=false;
	 public boolean eefinal=false;
	 ControlPDA control= new ControlPDA();
	 PDA pda;
	 Estado estado;
	 

	   public FConjuntos(PDA pda) {
		   this.pda=pda;
		   pda.setNombre("Ejemplo1");
		   Pila pila = new Pila();
		   pda.setPila(pila);
		   
		   System.out.println("entre");
		   JPanel conjuntos= new JPanel();
	      conjunto = new JTextField("Inserte Conjuntos");
	      conjunto.setFont(new Font("Serif", Font.BOLD, 20));
	      conjunto.setPreferredSize(new Dimension(300, 50));
	     
	      
	      saveButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 control.crearEstados(pda);
	        	 //timer.start();
	        	 new FReglas(pda);
	        	  setVisible(false); 
	        	  dispose();
	        	
	          }
	       });
	      
	      
	      addButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  
	        	  if (einicial.isSelected()) {
	        		  eeinicial=true;
			        	eefinal=false;
	        } else if(efinal.isSelected()){
	        	eeinicial=false;
	        	eefinal=true;
	        }else {eeinicial=false;
        	eefinal=false;}
	        	
	        	 estado=new Estado(conjunto.getText(),eeinicial,eefinal);
	        	 
	        	 String soy="";
	        	 if (estado.isInicial()==true) {
	        		 soy="inicial";
	        	 }
	        	 else if(estado.isAcept()==true) {
	        		 soy="final";
	        	 }else if(estado.isAcept()==false&&estado.isInicial()==false){
	        		 soy="nada";
	        	 }
	        	 
	        	 System.out.println("soy estado"+ estado.getEstado()+" Soy "+soy);
	        	 control.estados.add(estado);
	        	  
	          }
	       });
	      
	      //addButton.addActionListener(  new UnCheckAllAction());
	      
	      
	      conjunto.addMouseListener(new MouseAdapter() {
	    	  @Override
	    	  public void mouseClicked(MouseEvent e) {
	    	    conjunto.setText("");
	    	    einicial.setSelected(false);
	    	    efinal.setSelected(false);
	    	  }
	    	});
	      
	     
	      
	      
	      
	      
	      conjuntos.add(conjunto);
	      conjuntos.add(einicial);
	      conjuntos.add(efinal);
	      conjuntos.add(addButton);
	      conjuntos.add(saveButton);
	      
	    
	      
	     getContentPane().add(conjuntos);
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	   }

	 
	   
	   
	  

}


