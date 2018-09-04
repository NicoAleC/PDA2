package entity;

import java.util.Stack;

public class Pila extends Stack<String>{
	
	private static final long serialVersionUID = 1L;
	public Pila() {
		super();
		this.add("Z0");
	}
	
	public boolean vacio() {
		if(this.lastElement().equals("Z0")) {
			return true;
		} else {
			return false;
		}
	}

}
