package control;

import java.util.ArrayList;

import entity.Estado;
import entity.PDA;
import entity.Regla;

public class ControlPDA {
	

	ArrayList estados;
	ArrayList reglas;

	public ControlPDA() {
		estados = new ArrayList();
		reglas = new ArrayList();
	}

	public void agregarPila(PDA pda, int regla) {
		if (pda.getReglas()[regla].getOrden() > 0) {
			pda.getPila().add(pda.getReglas()[regla].getApilar());
		}
	}

	public void crearEstados(PDA pda) {
		pda.setEstados((Estado[]) estados.toArray());
	}

	public void crearReglas(PDA pda) {
		pda.setReglas((Regla[]) reglas.toArray());
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
