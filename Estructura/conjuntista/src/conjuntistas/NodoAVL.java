package conjuntistas;

public class NodoAVL {

	private Comparable elem;
	private int altura;
	private NodoAVL izq;
	private NodoAVL der;
	
	public NodoAVL(Comparable elem,int alto){
		this.elem=elem;
		this.altura = alto;
		this.der = null;
		this.izq = null;
	}

	public Comparable getElem() {
		return elem;
	}

	public void setElem(Comparable elem) {
		this.elem = elem;
	}

	public int getAltura() {
		return altura;
	}

	public void recalcularAltura() {
		int altIzq,altDer;
		
		if(this.izq!=null){
			altIzq = this.izq.getAltura();
		}else{
			altIzq = -1;
		}
		if(this.der!=null){
			altDer = this.der.getAltura();
		}else{
			altDer = -1;
		}
		
		this.altura = (Math.max(altIzq, altDer))+1;
	}

	public NodoAVL getIzquierdo() {
		return izq;
	}

	public void setIzquierdo(NodoAVL izq) {
		this.izq = izq;
	}

	public NodoAVL getDerecho() {
		return der;
	}

	public void setDerecho(NodoAVL der) {
		this.der = der;
	}
	
}
