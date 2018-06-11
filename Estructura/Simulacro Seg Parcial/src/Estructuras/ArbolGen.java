package Estructuras;

public class ArbolGen {

	private NodoGene raiz;

	public ArbolGen() {
		this.raiz = null;
	}

	// inserta en la primera posicion y va corriendo la lista de hermanos hacia
	// la derecha
	public boolean insertar(Object hijo, Object padre) {
		NodoGene nuevo;
		boolean exito = false;
		// inserta un elemento
		if (this.raiz == null) {
			nuevo = new NodoGene(hijo);
			this.raiz = nuevo;
			exito = true;
		} else {
			NodoGene aux = obtenerNodo(padre);
			if (aux != null) {
				nuevo = new NodoGene(hijo);
				if (aux.getHijoIzquierdo() != null) {

					nuevo.setHermanoDerecho(aux.getHijoIzquierdo());
					aux.setHijoIzquierdo(nuevo);
				} else {
					aux.setHijoIzquierdo(nuevo);
				}
				exito = true;
			}
		}
		return exito;
	}

	public NodoGene obtenerNodo(Object elem) {
		NodoGene nodo = obtenerNodoAux(this.raiz, elem);
		return nodo;
	}

	private NodoGene obtenerNodoAux(NodoGene nodo, Object elem) {

		NodoGene h = null;
		NodoGene resultado = null;
		if (nodo != null) {
			if (nodo.getElem().equals(elem)) {
				resultado = nodo;
			} else {
				h = nodo.getHijoIzquierdo();

				while (h != null && resultado == null) {
					resultado = obtenerNodoAux(h, elem);
					h = h.getHermanoDerecho();
				}
			}
		}

		return resultado;
	}

	public boolean pertenece(Object elem) {
		boolean resp = perteneceAux(this.raiz, elem);
		return resp;
	}

	private boolean perteneceAux(NodoGene nodo, Object elem) {
		boolean exito = false;
		NodoGene hijo = null;

		if (nodo != null) {
			if (nodo.getElem().equals(elem)) {
				exito = true;
			} else {
				hijo = nodo.getHijoIzquierdo();
				while (hijo != null && !exito) {
					exito = perteneceAux(hijo, elem);
					hijo = hijo.getHermanoDerecho();
				}
			}
		}

		return exito;
	}

	public Object padre(Object elem) {
		Object padre;

		if (this.raiz.equals(elem)) {
			padre = null;
		} else {
			padre = padreAux(this.raiz, elem);
		}

		return padre;
	}

	private Object padreAux(NodoGene nodo, Object elem) {
		Object padre = null;
		if (nodo != null) {
			NodoGene hijo = nodo.getHijoIzquierdo();
			while (hijo != null && padre == null) {
				if (hijo.getElem().equals(elem)) {
					padre = nodo.getElem();
				} else {
					hijo = hijo.getHermanoDerecho();
				}
			}
			if (padre == null) {
				hijo = nodo.getHijoIzquierdo();
				padre = padreAux(hijo, elem);
			}
		}
		return padre;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	public void inOrden() {
		inOrdenAux(this.raiz);
	}

	private void inOrdenAux(NodoGene nodo) {

		if (nodo != null) {
			inOrdenAux(nodo.getHijoIzquierdo());
			System.out.println(nodo.getElem());
			inOrdenAux(nodo.getHermanoDerecho());
		}
	}

	public void posOrden() {
		posOrdenAux(this.raiz);
	}

	private void posOrdenAux(NodoGene nodo) {

		if (nodo != null) {
			posOrdenAux(nodo.getHijoIzquierdo());
			posOrdenAux(nodo.getHermanoDerecho());
			System.out.println(nodo.getElem());
		}
	}

	public int nivel() {
		int niv = 0;

		return niv;
	}

	public boolean verificarCamino(Lista camino) {
		boolean exito = false;
		if (!this.esVacio()) {
			exito = verificarCaminoAux(this.raiz, camino, 1);
		}

		return exito;
	}

	public Lista listarEntreNivel(int niv1, int niv2) {
		Lista lista = new Lista();
		int nivelActual = 0;
		listarEntreNivelAux(nivelActual, niv1, niv2, this.raiz, lista);

		return lista;
	}

	//
	// if (niv1 == niv2) {
	// while (nodo != null) {
	// lista.insertar(nodo.getElem(), lista.longitud() + 1);
	// nodo = nodo.getHermanoDerecho();
	// }
	private void listarEntreNivelAux(int nivelActual, int niv1, int niv2, NodoGene nodo, Lista lista) {

		if (nodo != null) {

		}
	}

	public boolean eliminar(Object elem) {
		boolean exito = false;
		if (!this.esVacio()) {
			if (this.raiz.getElem().equals(elem)) {
				this.raiz = null;
			} else {
				exito = eliminarAux(elem, this.raiz.getHijoIzquierdo());
			}
		}
		return exito;
	}

	private boolean eliminarAux(Object elem, NodoGene nodo) {
		boolean exito = false;
		if (nodo != null) {
			if (nodo.getHijoIzquierdo() != null) {
				if (nodo.getHijoIzquierdo().getElem().equals(elem)) {
					nodo.setHijoIzquierdo(nodo.getHijoIzquierdo().getHermanoDerecho());
					exito = true;
				}
			} else if (nodo.getHermanoDerecho() != null) {
				if (nodo.getHermanoDerecho().getElem().equals(elem)) {
					nodo.setHermanoDerecho(nodo.getHermanoDerecho().getHermanoDerecho());
					exito = true;
				}
			}
			if (!exito) {
				if (nodo.getHijoIzquierdo() != null) {
					eliminarAux(elem, nodo.getHijoIzquierdo());
				}
				if (nodo.getHermanoDerecho() != null) {
					eliminarAux(elem, nodo.getHermanoDerecho());
				}
			}
		}
		return exito;
	}

	private boolean verificarCaminoAux(NodoGene nodo, Lista camino, int pos) {
		boolean exito = false;
		// dada una lista devuelve verdadero si existe un camino desde la raiz a
		// algun nodo
		if (nodo != null) {
			if (nodo.getElem().equals(camino.recuperar(pos))) {
				if (pos == camino.longitud()) {
					exito = true;
				} else if (nodo.getHijoIzquierdo() != null && pos <= camino.longitud()) {
					nodo = nodo.getHijoIzquierdo();
					pos++;
					exito = verificarCaminoAux(nodo, camino, pos);
				} else {
					exito = false;
				}
			} else if (nodo.getHermanoDerecho() != null) {
				nodo = nodo.getHermanoDerecho();
				exito = verificarCaminoAux(nodo, camino, pos);
			} else {
				exito = false;
			}
		}

		return exito;
	}

	public String toString() {
		return toStringAux(this.raiz);
	}

	private String toStringAux(NodoGene nodo) {
		String s = "";

		if (nodo != null) {
			s += nodo.getElem().toString() + "-->";
			NodoGene hijo = nodo.getHijoIzquierdo();
			while (hijo != null) {
				s += hijo.getElem().toString() + ", ";
				hijo = hijo.getHermanoDerecho();
			}
			hijo = nodo.getHijoIzquierdo();
			while (hijo != null) {
				s += "\n" + toStringAux(hijo);
				hijo = hijo.getHermanoDerecho();
			}
		} else {
			s += "Arbol Vacio";
		}
		return s;
	}
}
