package jerarquicas;

class NodoArbol<T> {
	
	private NodoArbol<T> izquierdo;
	private NodoArbol<T> derecho;
	private T elemento;
	
	public NodoArbol(T elem){
		this.izquierdo = null;
		this.derecho = null;
		this.elemento = elem;
	}
	
	public NodoArbol(NodoArbol<T> izq,NodoArbol<T> der, T elem){
		this.izquierdo = izq;
		this.derecho = der;
		this.elemento = elem;
	}
	
	
	public NodoArbol<T> getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(NodoArbol<T> izquierdo) {
		this.izquierdo = izquierdo;
	}
	public NodoArbol<T> getDerecho() {
		return derecho;
	}
	public void setDerecho(NodoArbol<T> derecho) {
		this.derecho = derecho;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
	
	
}
