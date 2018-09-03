package view;

import control.ControlPDA;
import control.LeerEscribirPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;
import entity.Regla;

public class Principal {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
	         public void run() {
	        	/* PDA pda=new PDA();
	        new FConjuntos(pda);*/
	        		new Menu();
	         }});
		/*// TODO Auto-generated method stub
		Estado[] estados = new Estado[4];
		estados[0] = new Estado("leer_a", true, false);
		estados[1] = new Estado("leer_b", false, false);
		estados[2] = new Estado("leer_c", false, false);
		estados[3] = new Estado("final", false, true);
		
		Regla[] reglas = new Regla[7];
		reglas[0] = new Regla(estados[0], "a", "Z0", estados[3], 0, "");
		reglas[1] = new Regla(estados[0], "a", "A", estados[0], -1, "");
		reglas[2] = new Regla(estados[0], "a", "B", estados[1], 0, "");
		reglas[3] = new Regla(estados[1], "b", "A", estados[1], -1, "");
		reglas[4] = new Regla(estados[1], "c", "Z0", estados[2], 0, "");
		reglas[5] = new Regla(estados[2], "a", "Z0", estados[2], 0, "");
		reglas[6] = new Regla(estados[2], " ", "Z0", estados[3], 0, "");
		
		Pila pila = new Pila();

		PDA pda = new PDA("Ejemplo", estados, pila, reglas);
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
		con.reiniciarPDA(pda);*/
	}

}
