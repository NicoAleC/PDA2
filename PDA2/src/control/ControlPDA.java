package control;

import java.util.ArrayList;

import entity.*;

public class ControlPDA {
	
	public ArrayList<Estado> estados;
	public ArrayList<Regla> reglas;
	
	public ControlPDA() {
		estados = new ArrayList<Estado>();
		reglas = new ArrayList<Regla>();
	}
	
	public void agregarPila(PDA pda, int regla) {
		if(pda.getReglas()[regla].getOrden() > 0) {
			pda.getPila().add(pda.getReglas()[regla].getApilar());
		} 
	}
	
	public void crearEstados(PDA pda) {
		
		Estado [] stockArr = estados.toArray(new Estado[estados.size()]);
		pda.setEstados(stockArr);
		System.out.println(stockArr[0].getEstado());
		//pda.setEstados((Estado[]) estados.toArray());
		
	}
	
	public void crearReglas(PDA pda) {
		Regla [] stockArr = reglas.toArray(new Regla[reglas.size()]);
		pda.setReglas(stockArr);
		System.out.println(stockArr[0].toString());
		
		//pda.setReglas((Regla[]) reglas.toArray());
	}
	public boolean simularAutomata(PDA pda, String letra, int cont) {
		if (pda.getActual().isAcept()) {
			return true;
		} else if (pda.getActual() == pda.getReglas()[cont].getEstadoActual() && letra.equals(pda.getReglas()[cont].getLectura())
				&& pda.getPila().lastElement().equals(pda.getReglas()[cont].getPila())) {
			for (int i = 0; i < pda.getEstados().length; i++) {
				if (pda.getEstados()[i] == pda.getReglas()[cont].getEstadoSiguiente()) {
					pda.setActual(pda.getEstados()[i]);
				}
			}
			return simularAutomata(pda, letra, cont+1);
		}
		return false;

	}

	public void reiniciarPDA(PDA pda) {
		pda.setLectura("");
		for (int i = 0; i < pda.getEstados().length; i++) {
			if(pda.getEstados()[i].isInicial()) {
				pda.setActual(pda.getEstados()[i]);
			}
		}
	}

}
