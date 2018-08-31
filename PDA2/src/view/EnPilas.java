package view;

import java.awt.GridLayout;

import java.util.Stack;

import javax.swing.JPanel;

import entity.Pila;



public class EnPilas extends JPanel {
	int tamano;

	Stack<EnPila> pilass= new Stack<EnPila>();
	//Stack <EnPila>auxiliar=new Stack<EnPila>();
	Pila auxiliar;

		public EnPilas(Pila pila) {
			//this.tamano=tamano;
			auxiliar=pila;
			tamano= pila.size();
			setLayout(new GridLayout(tamano, 0));
			
			
			
			

			for (int row = 0; row < tamano; row++) {
				if(row== 0) {
					EnPila j = new EnPila(false, row,auxiliar.peek());
					pilass.push(setpuntero(j));	
					//pilas.add(j);
					add(pilass.peek());
				}
				
			
				else {
					
			        EnPila j = new EnPila(false, row,auxiliar.peek());
					pilass.push(j);
					add(pilass.peek());
					
					}
					
					
					
					
			}
			
			
			
			
		
			
			
			
			

		}
		
		public void pilachange() {
			pilass.pop();
			
			
		}
		
		
		
		
		
		public EnPila setpuntero(EnPila enpila) {
			
			if(enpila.puntero) {
				enpila = new EnPila(true, enpila.pos,enpila.text+" <-");
			}
			//if (enpila.pos== pilas.size()-1) {
				
				return enpila;
			//}
			
		}


	}



