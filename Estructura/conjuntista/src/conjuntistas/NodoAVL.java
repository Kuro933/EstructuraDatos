package conjuntistas;

public class NodoAVL {

	private Comparable elem;
	private int altura;
	private NodoAVL izq;
	private NodoAVL der;
	
	public NodoAVL(Comparable elem){
		this.elem=elem;
		this.altura = 0;
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
	
	public int balance(){
		int balance=0,izq=0,der=0;
		
		if(this.izq!=null){
			izq = this.izq.getAltura();
		}else{
			izq = -1;
		}
		if(this.der!=null){
			der = this.der.getAltura();
		}else{
			der = -1;
		}
		
		balance = (izq-der);
		
		return balance;
	}

	public NodoAVL getIzquierdo() {
		return izq;
	}

	public void setIzquierdo(NodoAVL izq) {
		this.izq = izq;
		if(izq!=null){
		izq.recalcularAltura();
		}
		this.recalcularAltura();
	}

	public NodoAVL getDerecho() {
		return der;
	}

	public void setDerecho(NodoAVL der) {
		this.der = der;
		if(der!=null){
		der.recalcularAltura();
		}
		this.recalcularAltura();
	}
	
}
