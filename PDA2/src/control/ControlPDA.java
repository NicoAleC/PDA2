package control;

import java.util.ArrayList;
import java.util.Stack;

import entity.*;

public class ControlPDA {
	
	public ArrayList<Estado> estados;
	public ArrayList<Regla> reglas;
	public static ArrayList<String> pilas; 
	
	public ControlPDA() {
		estados = new ArrayList<Estado>();
		reglas = new ArrayList<Regla>();
	}
	
	public void agregarPila(PDA pda, int regla) {
		if(pda.getReglas()[regla].getOrden() == 1) {
			pda.getPila().add(pda.getReglas()[regla].getApilar());
		} 
		
		else if (pda.getReglas()[regla].getOrden() == -1){
			pda.getPila().pop();
		}
		
		else if (pda.getReglas()[regla].getOrden() == 0){
		}
	}
	
	public void crearEstados(PDA pda) {
		
		Estado [] stockArr = estados.toArray(new Estado[estados.size()]);
		pda.setEstados(stockArr);
		System.out.println(stockArr[0].getEstado());
	}
	
	public void crearReglas(PDA pda) {
		Regla [] stockArr = reglas.toArray(new Regla[reglas.size()]);
		pda.setReglas(stockArr);
		System.out.println(stockArr[0].toString());
	}
	public boolean simularAutomata(PDA pda, String letra, boolean tieneFinal) {
		String a;
		String nuevaentrada;
				
		/*if (letra.length() == 0 && tieneFinal) {
			System.out.println("TIENE final y esta acabado coñio");
			System.out.println("HABER Si el estado actual de mi automata es joder tio yo flipo "+pda.getActual().getEstado());
			if(pda.getActual().isAcept()) {
				System.out.println("es aceptado y me bota true joder macho");
				return true;
			}
			else
			{
				System.out.println("no es aceptado fua chaval ;'(");
				return false;
			}
			
		} else*/ if(letra.length() == 0){
			if(pda.getPila().lastElement().equals("Z0")) {
				return true;
			} else {
				return false;
			}
		}
			
			
			System.out.println("Tamaño de las reglas: "+pda.getReglas().length);
			for (int i = 0; i < pda.getReglas().length; i++) {
				String estadoinicial = pda.getReglas()[i].getEstadoActual().getEstado();
				String entrada = pda.getReglas()[i].getLectura();
				String topedelapila = pda.getReglas()[i].getPila();
				//pda.getPila().lastElement() == "Z0" ||
				if (pda.getActual().getEstado().equals(estadoinicial)) {
					if (entrada.equals("-")){
						System.out.println("Entre al if para cuando la cadena es epsilon csmr");
						a = "-";
						nuevaentrada=letra;
						//nuevaentrada = letra.substring(1);
					} else {
						a = String.valueOf(letra.charAt(0));
						nuevaentrada = letra.substring(1);
						System.out.println("El valor para mi caracter a es: "+a);
						System.out.println("estoy evaluando la regla"+pda.getReglas()[i].toString());
						System.out.println("Mi nueva entrada es: "+nuevaentrada);
					}
					if (entrada.equals(a)) {
						if (topedelapila.equals(pda.getPila().elementAt((pda.getPila().size()-1)))) {
							System.out.println("entro al if porque el tope de la pila y mi regla coinciden");
							pda.setActual(pda.getReglas()[i].getEstadoSiguiente());
							System.out.println("Mi nuevo estado final es: "+pda.getActual().getEstado());
							agregarPila(pda, i);
							PDA.pilas.add(pda.getPila().toString());
							System.out.println("la instruccion que le estoy enviando a la pila es: "+pda.getReglas()[i].getOrden());
							System.out.println("En la puta pila hay: "+pda.getPila().toString());
							System.out.println("------------------------------");
							if (simularAutomata(pda, nuevaentrada, tieneFinal))return true;
						}
					}
				}
			}
			return false;
		}
	
	public void reiniciarPDA(PDA pda) {
		for (int i = 0; i < pda.getEstados().length; i++) {
			if(pda.getEstados()[i].isInicial()) {
				pda.setActual(pda.getEstados()[i]);
			}
		}
	}

}
