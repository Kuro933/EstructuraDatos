package lineales.dinamicas;

public class Nodo {

	private Nodo enlace;
	private int elto;
	
	
	public Nodo(int elto){
		this.enlace = null;
		this.elto = elto;
		}
	
	public Nodo(Nodo enlace, int elto){
		this.enlace = enlace;
		this.elto = elto;
	}

	public Nodo getEnlace() {
		return enlace;
	}

	public void setEnlace(Nodo enlace) {
		this.enlace = enlace;
	}

	public int getElto() {
		return elto;
	}

	public void setElto(int elto) {
		this.elto = elto;
	}
}
