package jerarquicas;
import jerarquicas.NodoArbol;
public class ArbolBinario<T> {
	private NodoArbol<T> raiz;

	public ArbolBinario() {
		this.raiz = null;
	}

	public boolean insertar(T elem, T padre, char lugar) {
		boolean resu = true;
		NodoArbol<T> nuevo = new NodoArbol<T>(elem);

		if (this.raiz == null) {
			this.raiz = nuevo;
		} else {
			NodoArbol<T> nodoPadre = obtenerNodo(this.raiz, padre);
			if (nodoPadre != null) {
				if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
					nodoPadre.setIzquierdo(nuevo);
				} else if (lugar == 'D' && nodoPadre.getDerecho() == null) {
					nodoPadre.setDerecho(nuevo);
				} else {
					resu = false;
				}
				resu = false;
			}
		}

		return resu;
	}

	public void vaciar() {
		this.raiz = null;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	private NodoArbol<T> obtenerNodo(NodoArbol<T> nodo, T elto) {
		NodoArbol<T> resultado = null;
		if (nodo != null) {
			if (nodo.getElemento() == elto) {
				resultado = nodo;
			} else {
				resultado = obtenerNodo(nodo.getIzquierdo(), elto);
			}
			if (resultado == null) {
				resultado = obtenerNodo(nodo.getDerecho(), elto);
			}
		}
		return resultado;
	}

	public void preOrden() {
		preOrdenAux(this.raiz);
	}

	private void preOrdenAux(NodoArbol<T> nodo) {

		if (nodo != null) {
			System.out.println(nodo.getElemento());

			preOrdenAux(nodo.getIzquierdo());
			preOrdenAux(nodo.getDerecho());
		}
	}

	public ArbolBinario<T> clone() {
		ArbolBinario<T> clon = new ArbolBinario<T>();

		if (this.raiz != null)
			clon.raiz = clonar(this.raiz);

		return clon;
	}

	private NodoArbol<T> clonar(NodoArbol<T> nodo) {
		NodoArbol<T> nuevo = null;
		if (nodo != null) {

			nuevo = new NodoArbol<T>(clonar(nodo.getIzquierdo()), clonar(nodo.getDerecho()), nodo.getElemento());

		}

		return nuevo;
	}

	public ArbolBinario<T> clonarInvertido() {
		ArbolBinario<T> clon = new ArbolBinario<T>();

		if (this.raiz != null)
			clon.raiz = clonarAux(this.raiz);

		return clon;
	}

	private NodoArbol<T> clonarAux(NodoArbol<T> nodo) {
		NodoArbol<T> nuevo = null;
		if (nodo != null) {

			nuevo = new NodoArbol<T>(clonarAux(nodo.getDerecho()), clonarAux(nodo.getIzquierdo()), nodo.getElemento());

		}

		return nuevo;
	}

	public String toString() {
		String arbol = "";

		if (this.raiz != null) {
			arbol += toStringAux(this.raiz);
		} else {
			arbol = "Arbol vacio";
		}

		return arbol;
	}

	private String toStringAux(NodoArbol<T> nodo) {
		String listado = "";

		if (nodo != null) {
			listado += "Padre: " + nodo.getElemento();
			listado += "\n";
			if (nodo.getIzquierdo() != null) {
				listado += "Hijo izquierdo: " + nodo.getIzquierdo().getElemento() + " ";
			}
			if (nodo.getDerecho() != null) {
				listado += "Hijo derecho: " + nodo.getDerecho().getElemento() + " ";

			}
			listado += "\n";
			listado += toStringAux(nodo.getIzquierdo());
			listado += toStringAux(nodo.getDerecho());
		}
		return listado;
	}

	public void inOrden() {
		inOrdenAux(this.raiz);
	}

	private void inOrdenAux(NodoArbol<T> nodo) {

		if (nodo != null) {
			inOrdenAux(nodo.getIzquierdo());
			System.out.println(nodo.getElemento());
			inOrdenAux(nodo.getDerecho());
		}
	}

	public void posOrden() {
		posOrdenAux(this.raiz);
	}

	private void posOrdenAux(NodoArbol<T> nodo) {

		if (nodo != null) {
			posOrdenAux(nodo.getIzquierdo());

			posOrdenAux(nodo.getDerecho());
			System.out.println(nodo.getElemento());
		}
	}
	
	

}
