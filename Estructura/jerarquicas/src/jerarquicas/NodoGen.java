package jerarquicas;

public class NodoGen {

	private Object elem;
	private NodoGen hijoIzquierdo;
	private NodoGen HermanoDerecho;
	
	
	public NodoGen(Object elem){
		this.elem = elem;
		this.hijoIzquierdo = null;
		this.HermanoDerecho = null;
	}


	public Object getElem() {
		return elem;
	}


	public void setElem(Object elem) {
		this.elem = elem;
	}


	public NodoGen getHijoIzquierdo() {
		return hijoIzquierdo;
	}


	public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}


	public NodoGen getHermanoDerecho() {
		return HermanoDerecho;
	}


	public void setHermanoDerecho(NodoGen hermanoDerecho) {
		HermanoDerecho = hermanoDerecho;
	}
	
	
}
