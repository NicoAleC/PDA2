package view;

import java.awt.GridLayout;

import java.util.Stack;

import javax.swing.JPanel;

import entity.Pila;
import entity.Regla;



public class EnPilas extends JPanel {


	String pilass;
	Stack<String> stack;
	
	

		public EnPilas(String pilass) {
			this.pilass=pilass;
			
			String dividido=pilass.substring(1, pilass.length()-1);
			  stack = new Stack<String>();
			  
			  
            String[] parts = dividido.split(",");
            for (int i=0; i<parts.length;i++) {
            	
            	stack.push(parts[i]);
            	System.out.println(parts[i]);
            }
            
          
        	



			
			
			
			
			
			setLayout(new GridLayout(parts.length,0));
			
			
			
			

			for (int row = 0; row < parts.length; row++) {
				if(row== 0) {
					System.out.println("hay"+ stack.peek());
					EnPila j = new EnPila(true, stack.peek());
					setpuntero(j);	
					//pilas.add(j);
					add(j);
					stack.pop();
				}
				
			
				else {
					System.out.println("hay"+ stack.peek());
			        EnPila j = new EnPila(false, stack.peek());
					
					add(j);
					stack.pop();
					
					}
					
					
					
					
			}
			
			
			
			
		
			
			
			
			

		}
		
	
		
		
		
		
		public EnPila setpuntero(EnPila enpila) {
			
			if(enpila.puntero==true) {
				enpila = new EnPila(true,enpila.text+" <-");
			}
			//if (enpila.pos== pilas.size()-1) {
				
				return enpila;
			//}
			
		}


	}



