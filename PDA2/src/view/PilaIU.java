package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import control.ControlPDA;
import control.LeerEscribirPDA;
import entity.PDA;

public class PilaIU extends JFrame {
	
	EnPilas pilafunc;
	//Pila auxiliar;
	
	JPanel p;
	 JScrollPane scrollPane;
	 JPanel jp;
	 PDA pda;
	 JPanel preglas;
	 JPanel pestados;
	 protected JTextArea textArea;
	 protected JTextArea textArea2;
	JTextField[] reglass;
	JTextField[] estadoss;
	JLabel[]reglitas;
	JLabel[]estados;
	private static final long serialVersionUID = 1L;
	public JTextField conjunto;
	private JButton editButton = new JButton("Edit");
	private JButton simularButton = new JButton("Simular");
	private JButton guardarButton = new JButton("Guardar");
	
	Box box;

	   public PilaIU(PDA pda) {
		   this.pda=pda;
		   
		   
		   
		   simularButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		        	  
		        	  
		        	
		        	  
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
		    		System.out.println(con.simularAutomata(pda, "a", 0));
		    		con.reiniciarPDA(pda);
		    		
		    		//deberia rechazar
		    		System.out.println(con.simularAutomata(pda, "b", 0));
		    		con.reiniciarPDA(pda);
		    		pilafunc= new EnPilas(pda.getPila());
		    		
		    		
	    			p.remove(scrollPane);
	    			scrollPane = new JScrollPane(pilafunc,

	    					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

	    					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

	    			);
	    			
	    			p.setPreferredSize(new Dimension(400, 400));

	    	        scrollPane.setBounds(30, 50, 300, 300);
	    			
	    			p.add(scrollPane);

	    			

	    			p.revalidate();

	    			p.repaint();
		        	  
		        	  
		          }
		       });
		   editButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		        	  
		        	  
		        	  
		        	  jp.remove(box);
		              
		              reglass=new JTextField[reglitas.length];
		      		   for(int j=0;j<reglitas.length;j++) {
		      			   JTextField text=new JTextField(reglitas[j].getText());
		      			   reglass[j]=text;
		      			   //
		      			  // reglitas[j].addActionListener(this);  
		      			   //System.out.println(pda.getEstados()[j]);
		      	        	  }
		       
		              textArea = new JTextArea(5, 20);
		              textArea.setEditable(false);
		              JScrollPane scrollPane = new JScrollPane(textArea);
		       
		              //Add Components to this panel.
		              GridBagConstraints c = new GridBagConstraints();
		              c.gridwidth = GridBagConstraints.REMAINDER;
		       
		              c.fill = GridBagConstraints.HORIZONTAL;
		              for(int j=0;j<reglitas.length;j++) {
		      			   preglas.add(reglitas[j],c); 
		      			   //System.out.println(pda.getEstados()[j]);
		      	        	  }
		       
		              c.fill = GridBagConstraints.BOTH;
		              c.weightx = 1.0;
		              c.weighty = 1.0;
		            
		             
		             
		             estadoss=new JTextField[estados.length];
		      		   for(int j=0;j<estados.length;j++) {
		      			   JTextField text=new JTextField(estados[j].getText());
		      			   estadoss[j]=text;
		      			   //
		      			  // reglitas[j].addActionListener(this);  
		      			   //System.out.println(pda.getEstados()[j]);
		      	        	  }
		       
		              textArea2 = new JTextArea(5, 20);
		              textArea2.setEditable(false);
		              JScrollPane scrollPane2 = new JScrollPane(textArea2);
		       
		              //Add Components to this panel.
		              GridBagConstraints c2 = new GridBagConstraints();
		              c2.gridwidth = GridBagConstraints.REMAINDER;
		       
		              c2.fill = GridBagConstraints.HORIZONTAL;
		              for(int j=0;j<estados.length;j++) {
		      			   pestados.add(estados[j],c2); 
		      			   //System.out.println(pda.getEstados()[j]);
		      	        	  }
		       
		              c.fill = GridBagConstraints.BOTH;
		              c.weightx = 1.0;
		              c.weighty = 1.0;
		            
		             
		             box = Box.createHorizontalBox();

		 			box.add(Box.createHorizontalGlue());

		 			box.add(preglas);

		 			box.add(Box.createHorizontalStrut(20));
		 			
		 			Box box1 = Box.createVerticalBox();
		 			box1.add(Box.createVerticalGlue());
		 			box1.add(guardarButton);
		 			box1.add(Box.createVerticalStrut(20));
		 			box1.add(simularButton);
		 			box1.add(Box.createVerticalGlue());
		 			box.add(box1);
		 			box.add(Box.createHorizontalStrut(20));

		 			box.add(pestados);

		 			box.add(Box.createHorizontalGlue());



		 			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		 			
		 			jp.add(box);
		             
		             
		             jp.revalidate();

		    		jp.repaint();
		        	  
		          }
		       });
		   
		   
		   
		   
		   
		   
		   jp= new JPanel(); 
		   
		   
		    p= new JPanel(null);
		   
		   
		   
		   
		   scrollPane = new JScrollPane(pilafunc,

					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

			);
			
			p.setPreferredSize(new Dimension(400, 400));

	        scrollPane.setBounds(30, 50, 300, 300);
			
			p.add(scrollPane);
			
			
			preglas= new JPanel();
			  
			   reglitas=new JLabel[pda.getReglas().length];
			   for(int j=0;j<pda.getReglas().length;j++) {
				   reglitas[j]=new JLabel(pda.getReglas()[j].toString());
		        	
		        	  }
			 
			   for(int j=0;j<reglitas.length;j++) {
				   preglas.add(reglitas[j]);
		        	  
		        	  }
			   
			   pestados= new JPanel();
				  
			   estados=new JLabel[pda.getEstados().length];
			   for(int j=0;j<pda.getEstados().length;j++) {
				   estados[j]=new JLabel(pda.getEstados()[j].toString());
		        	  
		        	  }
			
			   for(int j=0;j<estados.length;j++) {
				   pestados.add(estados[j]);
		        	  
		        	  }
			   
			   
			   
			
		    box = Box.createHorizontalBox();

			box.add(Box.createHorizontalGlue());

			box.add(preglas);

			box.add(Box.createHorizontalStrut(20));
			
			Box box1 = Box.createVerticalBox();
			box1.add(Box.createVerticalGlue());
			box1.add(editButton);
			box1.add(Box.createVerticalStrut(20));
			box1.add(simularButton);
			box1.add(Box.createVerticalGlue());
			box.add(box1);
			box.add(Box.createHorizontalStrut(20));

			box.add(pestados);

			box.add(Box.createHorizontalGlue());



			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
			
			jp.add(box);
		   
		   
		   
		 
			
			add(jp, BorderLayout.NORTH);
			add(p, BorderLayout.SOUTH);
	      
			
		    
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	      
	      
	   }

	  
	   
	   
	

}
