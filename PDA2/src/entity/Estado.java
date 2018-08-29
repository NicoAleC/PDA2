package entity;

public class Estado {

	private String estado;
	private boolean inicial;
	private boolean acept;
	
	public Estado() {
		this.estado = "";
		this.inicial = false;
		this.acept = false;
	}
	
	public Estado(String nombre, boolean inicial, boolean acept) {
		this.estado = nombre;
		this.inicial = inicial;
		this.acept = acept;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public boolean isInicial() {
		return inicial;
	}

	public boolean isAcept() {
		return acept;
	}

	@Override
	public String toString() {
		return "Estado [estado=" + estado + ", inicial=" + inicial + ", acept=" + acept + "]";
	}


}
