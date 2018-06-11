package Estructuras;

public class NodoGene {

	private Object elem;
	private NodoGene hijoIzquierdo;
	private NodoGene HermanoDerecho;
	
	
	public NodoGene(Object elem){
		this.elem = elem;
		this.hijoIzquierdo = null;
		this.HermanoDerecho = null;
	}
	public NodoGene(NodoGene izq, NodoGene der, Object elem){
		this.elem = elem;
		this.hijoIzquierdo = izq;
		this.HermanoDerecho = der;
	}


	public Object getElem() {
		return elem;
	}


	public void setElem(Object elem) {
		this.elem = elem;
	}


	public NodoGene getHijoIzquierdo() {
		return hijoIzquierdo;
	}


	public void setHijoIzquierdo(NodoGene hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}


	public NodoGene getHermanoDerecho() {
		return HermanoDerecho;
	}


	public void setHermanoDerecho(NodoGene hermanoDerecho) {
		HermanoDerecho = hermanoDerecho;
	}
	
	
}
