package entity;

import java.util.Arrays;

public class PDA {
	

	private String nombre;
	private String lectura;
	private int puntero;
	private Estado actual;
	private Estado[] estados;
	private Pila pila;
	private Regla[] reglas;

	public PDA() {
		this.nombre = "";
		this.lectura = "";
		this.puntero = 0;
		this.actual = new Estado();
		this.estados = new Estado[0];
		this.pila = new Pila();
		this.reglas = new Regla[0];
	}

	public PDA(String nombre, Estado[] estados, Pila pila, Regla[] reglas) {
		this.nombre = nombre;
		this.lectura = "";
		this.puntero = 0;
		if (estados[0].isInicial()) {
			this.actual = estados[0];
		}
		this.estados = estados;
		this.pila = pila;
		this.reglas = reglas;
	}

	public String getNombre() {
		return nombre;
	}

	public Estado getActual() {
		return actual;
	}

	public void setActual(Estado actual) {
		this.actual = actual;
	}

	public Estado[] getEstados() {
		return estados;
	}

	public void setEstados(Estado[] estados) {
		this.estados = estados;
	}

	public Pila getPila() {
		return pila;
	}

	public void setPila(Pila pila) {
		this.pila = pila;
	}

	public Regla[] getReglas() {
		return reglas;
	}

	public void setReglas(Regla[] reglas) {
		this.reglas = reglas;
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public int getPuntero() {
		return puntero;
	}

	public void setPuntero(int puntero) {
		this.puntero = puntero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "PDA [actual=" + actual + ", estados=" + Arrays.toString(estados) + ", pila=" + pila + ", reglas="
				+ Arrays.toString(reglas) + "]";
	}


}
