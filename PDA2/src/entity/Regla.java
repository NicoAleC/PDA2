package entity;

public class Regla {
	
	private Estado estadoActual;
	private String lectura;
	private String pila;
	private Estado estadoSiguiente;
	private String apilar;
	private int orden;

	public Regla() {
		this.estadoActual = null;
		this.estadoSiguiente = null;
		this.pila = "";
		this.orden = 0;
		this.apilar = "";
		this.lectura = "";
	}

	public Regla(Estado estadoActual, String lectura, String pila, Estado estadoSiguiente, int orden, String apilar) {
		super();
		this.estadoActual = estadoActual;
		this.estadoSiguiente = estadoSiguiente;
		this.pila = pila;
		this.orden = orden;
		if (orden > 0) {
			this.apilar = apilar;
		} else {
			this.apilar = "";
		}
		this.lectura = lectura;
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Estado getEstadoSiguiente() {
		return estadoSiguiente;
	}

	public void setEstadoSiguiente(Estado estadoSiguiente) {
		this.estadoSiguiente = estadoSiguiente;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public String getPila() {
		return pila;
	}

	public void setPila(String pila) {
		this.pila = pila;
	}

	public String getApilar() {
		return apilar;
	}

	public void setApilar(String apilar) {
		this.apilar = apilar;
	}

	public String toString() {
		return "<" + estadoActual.getEstado() + "," + lectura + "," + pila + "," + estadoSiguiente.getEstado() + ","
				+ orden + "(" + apilar + ")" + ">";
	}


}
